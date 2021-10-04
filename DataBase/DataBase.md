# Data Base

일련의 데이터들을 사용자가 이용할 수 있게끔 가공, 정제하는 과정, 비절차적 언어, 무결성 : 오염되지 않은 데이터들의 집합, 판단의 로직이 아니라 판단의 근거가 되는 데이터를 집어넣은 것

## DBMS

Data Base Management System

### History

- 계층형 (1960)
  - 1 : N의 관계, 최초 
- 망형 (1970)
  - N : M의 관계, 효과적이고 빠른 데이터 추출
- 관계형 (1980~90)
  - RDBMS, 테이블이라는 최소 단위 구성, 테이블은 하나 이상의 열로 구성됨 
- 객체지향형 
  - Object-DB, 사용빈도 낮음
- 객체관계형 (현재)
  - ORDB,  필요하다면 Object로 저장할 수 있음, 기본은 관계형으로 데이터가 저장됨

## Entity

- 클래스와 유사함.
- 여러 정보들과 관계를 가져야 함.
- 각 엔티티는 자신이 필요로 하는 데이터로 구성되어 있음.
- 메소드는 없다. 로직을 가지고 처리하는 것이 아니라 관계대수의 집합이론을 가지고 하기 때문에 절차가 없음.
- 작업 절차가 없음.
- 테이블 모양을 갖음. (schema와 record(instance, example)로 이루어짐)
- 파일 구조의 확장.

## SQL(Structured Query Language)

- 관계형 데이터베이스에서 사용되는 언어
- DBMS 제작회사와 독립적
- 다른 시스템으로 이식성 좋음
- 표준이 계속 발전 (기업간의 상호 합의)
- 대화식 언어 = 비 절차적 언어
- 분산형 클라이언트/서버 구조 = 데이터가 다른 기기에 존재함
  - 유/무선으로 연결할 때 상호 간의 프로토콜 
  - 서버와 클라이언트는 같은 회사에서 나오는 것이 기본
- 테이블에 저장된 데이터를 가지고 회사에서 요구하는 비즈니스 로직을 처리하기 위한 프로그램을 짜는 사람을 데이터베이스 개발자라고 한다.
- 비 절차적 언어이긴 하나, 간단한 함수가 들어감.
- Stored Procedure, Built-in Function이 필요함 = java에서 해결 가능 >> 데이터베이스 어플리케이션 개발자

query문을 직접 작성하는 것을 목표로 한다.

### CRUD

#### Create (생성, 데이터 삽입)

- 우리가 저장할 테이블을 만드는 것, 구조 잡기
- 구조 안에 구체적인 값을 집어 넣는 것, 인스턴스(레코드) 생성 하는 것
- 생성 코드

```sql
CREATE TABLE 식별자이름(
    
);
```

- 삽입 코드

```sql
INSERT INTO userTBL VALUES('~~','--');
```

위의 경우는 userTBL이 가진 모든 변수를 적어주어야 한다.

```sql
INSERT INTO userTBL('~~','--') VALUES;
```

위의 코드를 통해 userTBL에 특정 정보만을 삽입할 수도 있다.

#### Read (조회)

- 

## SQL 문법

### 데이터 형식

- 숫자 데이터 형식

  ```sql
  CREATE TABLE userTBL(
  	birthYear NUMbER(4) NOT NULL
  );
  ```

  4자리까지의 숫자를 받는다

- 문자 데이터 형식

  ```sql
  CREATE TABLE userTBL(
      userID CHAR(8) primary key,
      userName NVARCHAR2(10) NOT NULL,
      addr NCHAR(100) NOT NULL
  );
  ```

  - CHAR : 고정길이 문자형, 숫자 없이 문자열만 
  - NCHAR : 유니코드 고정길이 문자형, 한글을 저장할 수 있다.(N : national)
  - VARCHAR : 가변길이형 문자열로 공간의 효율적 운용이 가능

### 제약 조건

 : 데이터의 무결성을 지키기 위한 제한된 조건

무조건적으로 입력되는 것이 아닌 어떠한 조건을 만족했을 때 입력되도록 제약할 수 있음

- PRIMARY KEY : 기본키, NOT NULL + UNIQUE

```SQL
userID CHAR(8) PRIMARY KEY
```

- FOREIGN KEY : 두 테이블 사이의 관계를 선언함으로써, 데이터의 무결성을 보장해주는 역할

  관계설정 시 하나의 테이블이 다른 테이블에 의존하게 됨

  ```sql
  CREATE TABLE userTBL (
  	userID CHAR(8) NOT NULL PRIMARY KEY,
      --중략--
  );
  CREATE TABLE buyTBL(
  	userID CHAR(8) REFERENCES userTBL(userID),
      --중략--
  );
  ```

  ``REFERENCE`` 키워드를 이용하여 설정

  외래 키 테이블이 참조하는 기준 테이블의 열은 반드시 Primary key이거나, Unique 제약 조건이 설정되어 있어야 함.

- UNIQUE

  '중복되지 않는 유일한 값'을 입력해야 하는 조건, NULL값을 허용함.

- CHECK

  입력되는 데이터를 점검

  ```sql
  CHECK (height >= 0);
  ```

- DEFAULT

  값을 입력하지 않았을 때 자동으로 입력되는 기본 값을 정의

- NULL

  NULL값 허용