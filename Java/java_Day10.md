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