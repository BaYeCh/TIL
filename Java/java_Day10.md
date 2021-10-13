# Day 10

여러 개의 데이터는 인스턴스를 설명할 수 있어야 한다.

여러 개의 데이터가 모여야 의미가 있다.

## 제너릭

```java
private ArrayList<ScoreData> list;
list = new ArrayList<ScoreData>();
//제너릭
```

- ArrayList의 경우에는 여러 다양한 데이터를 저장할 수 있다.
- 동일한 타입만 들어가도록 하는 것이 제너릭임
- 이미 고정된 타입, 동적 타입이 아닌 고정된 타입

## file 파일

```java
//파일에 접속하기 위한 코드
import java.io.File;
File file = new File(filePath);
```

- 지역변수는 항상 초기화 할 것.

# Day 11

## 자바를 이용한 데이터베이스 활용

### 데이터베이스와 자바의 연결

```java
import java.sql.Connection;
public Connection makeConnection(){
    Connection con = null;
    String driver  = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String id = "HR";
    String pwd = "1234";
    
    Class.forName(driver);
    con = DriverManager.getConnection(url, id, pwd);
    
    return con;
}
```

### 삽입하는 코드

```java
public void insertData(){
    String sql = "INSERT INTO studentTBL VALUES(990001, 'addx', 17, 29, 16, 49, 43, 154,'C', 'A', 'C')";
    Connection con = this.makeConnection();
    Statement stmt = con.createStatement();
    
    //삽입이 되었는지 확인하는 코드
    int affectedCount = stmt.executeUpdate(sql);
    if(affectedCount > 0){
        System.out.println("삽입 완료");
    }
    stmt.close();
    con.close();
}
```

- ``executUpdate()``는 실행의 개수가 몇 개인지를 헤아려주는 메소드

# Day 13

## 여러 가지 클래스

해당 클래스의 인스턴스를 생성하시오.

```java
A a = new A();
B b = new B(Sth.);//Sth. : something
C c = C.getInstance; //Calendar
//인스턴스를 만들 필요가 없는 것들 : DriverManager, Class, Math 항상 하는 일이 같음
```



- Random 


```java
Random rd = new Random();
```

- String


```java
String sql = "";
```

- Integer


```java
int amo = Integer.parseInt(String);
```

- Connection : 다른 객체에서 여러가지 정보를 조합해서 객체 생성(database : java.sql)


```java
public Connection makeConnection(){
    Connection con = null;
    String driver ="";
    String url = "";
    String id = "";
    String pwd = "";
    
    //Class
    Class.forName(driver);//driver정보가 인스턴스로 만들어짐
    //DriverManager : 클래스를 로딩하는 역할
    con = DriverManager.getConnection(url,id,pwd);
    
    return con;
}
```

- Statement(database : java.sql) : 다른 인스턴스로부터 만들어짐


```java
Connection con = this.makeConnection();
Statement stmt = con.createStatement();
```

sql로 만든 작업지시를 database로 보내서 결과를 받음

- PreparedStatement(database : java.sql)

```java
String sql = "INSERT INTO studentTBL VALUES(?,?,?,?)";
Connection con = this.makeConnection();
PreparedStatement stmt = con.prepareStatement(sql);
//몇 개의 작업이 완료되었는지
int affectedCount = stmt.executeUpdate();
```

쿼리 먼저 보내고 쿼리에서 중요하게 여겨지는 값은 나중에 보내는 역할

Statement의 특징에 더해서 매번 바뀌는 값에 대한 대처를 위한 클래스

그냥 Statement를 사용하게 될 경우에는 정보를 삽입할 때 그 개수만큼의 쿼리를 작성해 주어야 함.

잘못된 정보를 삽입하는 것을 방지할 수 있음

- ResultSet(database : java.sql)


```java
ResultSet rs = stmt.executeQuery();
while(rs.next()){
    
}
rs.close();
stmt.close();
con.close();
```

- 메소드를 통해서 리턴되는 타입

  - Select의 결과, 테이블의 모양

  - 총 3부분으로 이루어져 있음

    1. first
    2. record : 수집한 데이터가 이곳에 들어가 있음
    3. last

    기본적인 준비상태는 커서가 first를 가리키고 있음, while문에서 rs.next()를통해 한칸씩 밑으로 내려감

    커서가 last를 가리키게 되면 false로 바뀌어 while문을 중단시킨다.

  - 데이터 무결성을

- Calendar


```java
Calendar cal = Calendar.getInstance();
```

- Math : 인스턴스를 만들 필요가 없는 클래스


- ArrayList


```java
ArrayList<String> list = new ArrayList<String>();
```

- HashMap(?)


```java
Map<String, Integer> map = new HashMap<K, V>();
```

- HashSet(?)


- Object 객체 생성 하지 않음(equals와 toString : java.lang)


- SimpleDateFormat


- Thread


- File


```java
File file = new File("./data/Abc1115.csv");
```

- Filereader


```java
FileReader fr = new FileReader(file);
```

- BufferedReader


```jav
BufferedReader br = new BufferedReader(fr);
```

- FileWriter : new


- PrintWriter : new


- Scanner


```java
Scanner scan = new Scanner();
```

- Comparator


```java
public class ScoreComparator implements Comparator<ScoreData> {
	//클래스 생성 탭에서 interface Add후 comparator 검색후 적용 클래스 생성시 작성
	@Override
	public int compare(ScoreData o1, ScoreData o2) {
		// TODO Auto-generated method stub
		int result = 0;
		result = o2.calcuNo2( ) - o1.calcuNo2();//내림차순
		//result = o1.calcuNo2() - o2.calcuNo2(); //오름차순
		return 0;
	}
}
//적용
Collections.sort(sortedList, new ScoreComparator());//(정렬하고자 하는 대상, 정렬 방법)
		
		for(int i=0; i<10 ;i++) {
			ScoreData temp = sortedList.get(i);
			System.out.println(temp.getSno()+" : "+temp.calcuNo2());
		}
		result = String.valueOf(sortedList.get(4).getSno());
		
		return result;
```



# Day 15

## Override

- 재정의 ,다형성의 한 종류
- 상위 클래스에 있는 내용은 그대로 받아오면서 내용만 바꾸어준다.
- 똑같은 기능임에도 다르게 동작하는 경우를 대비하기 위한 목적
- access modifier, type, parameter, exception가 다르면 전혀 다른 메소드가 됨
- Annotation @문자열을 통해서 원하는 규칙에 맞는지 확인

## Overload

- 중복 정의, 다형성의 종류

- 하나의 클래스 안에서 동일한 메소드 이름을 사용할 수 있다.

  1. 메소드 이름이 같아야 함
  2. 파라메타 리스트를 다르게 함(개수, 타입, 순서)

- 리턴 타입은 오버로드에 영향을 미치지 않음, 고려 대상이 아님

  ```java
  1. public void a (int a, int b){}
  2. public void a (int b, int a){}
  3. public void a (int a, float b){}
  4. public String a (float a, int b){}
  5. public String a (int a, int b){}
  //1과 2는 오버로드가 아님
  //2와 3은 오버로드
  //1과 5는 오버로드 아님
  //1과 4는 오버로드
  ```

  

