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
