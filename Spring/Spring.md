# Day27

## Spring

- 기능을 미리 클래스나 인터페이스 등으로 만들어 제공하는 <u>반제품</u>
- <u>개발 생산성</u>과 <u>품질</u>이 보장된 애플리케이션을 개발 가능, <u>안정성 보장</u>
- <u>의존성 주입(DI, Dependency Injection)</u>과 <u>제어역전(IoC, Inversion of Control)</u>을 이용하여 개선
- 경량 컨테이너 : 자기 실행환경
- 여러 가지 빈(클래스 객체)을 개발자가 아닌 <u>스프링이 권한을 가지고 직접 관리</u>
- <u>영속성(persistence)</u>과 관련된 다양한 서비스 지원 : <u>데이터베이스</u>에 접속하는 기술, <u>xml</u>
- <u>관점 지향(AOP, Aspect-Oriented Programming)기능</u>을 이용해 자원 관리

### 의존성 주입(DI)

- 컨테이너가 사용 관계를 직접 규정, 객체와 객체의 결합 관계

- 기존에는 다른 클래스의 메소드를 사용하기 위해서는 인스턴스를 생성해야 하지만 의존성 주입을 통해 직접적인 사용 관계를 발생하지 않도록 하여 각 클래스의 변경이 자유롭게 함(약한 결합)

  - XML을 통해 밖에서 전달, <u>애너테이션</u>을 이용해 객체 주입

- 객체 생성을 누가 결정하는가? 컨테이너

- 해당하는 클래스가 필요로 하는 정보를 적절하게 넣어주는 방법

  1. 생성자를 통해서 제공
  2. set메소드를 통해서 제공하는 방법

- 의존하는 객체를 컨테이너 실행 시 주입하기 때문에 DI

- 속성을 통한 의존성 주입

  ```xml
  <bean id="viewResolver"
  		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
  		<property name="viewClass"
  			value="org.springframework.web.servlet.view.JstlView" />
  		<property name="prefix" value="/test/" />
  		<property name="suffix" value=".jsp" />
  	</bean>
  <!-- 내부적으로는 set method를 사용, <property>태그를 사용해야 하며, name 속성값이 호출하고자 하는 메소드의 이름-->
  ```

  

### 제어 역전(IoC)

- 일반적으로 DI로  IoC의 기능을 구현해서 IoC보다는 DI라는 용어를 더 많이 사용

- lazy-init

  ```xml
  <beans>
  	<bean id="firstBean" class="com.spring.ex04.First" lazy-init="false" />
      <bean id="secondBean" class="com.spring.ex04.Second" lazy-init="true" />
      <bean id="thirdBean" class="com.spring.ex04.Third" lazy-init="default" />
  </beans>
  <!--결과
  First 생성자 호출
  Third 생성자 호출
  SecondBean 얻기
  Second 생성자 호출
  -->second가 나중에 호출 됨
  ```

- XML

  - 프로세스를 처리하는 것이 아니라 데이터가 저장되는 것

- [Spring Framework 동작원리](https://juyoungit.tistory.com/268)

### Spring JDBC 연동

- Driver이름과 DB의 url정보가 필요함 jdbc.properties에 저장해 놓을 것임

  ```properties
  jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
  jdbc.url=jdbc:oracle:thin:@localhost:1521:XE
  jdbc.username=scott
  jdbc.password=tiger
  key&value 방식, 가장 전형적임
  ```

- Jdbc Template

  조금 더 간략한 형태의 스프링의 JDBC기능을 제공하는 클래스

  이것보다 더 간략해지는 형태가 나옴

- RowMapper

  anonymous inner class

### ORM

- 마이바티스 프레임워크

  - SQL문의 가독성을 높여 사용하기 편하게 만든 것
  - SQL문을 미리 SqlMapConfig.xml에 작성해 놓고 애플리케이션에서 데이터베이스 연동 시 해당 SQL문에서 사용될 데이터를 지원하는 해당 매개변수에 저장한 후 SQL문에 전달

  ```xml
  <resultMap id="memResult" type="memberVO">
  		<result property="id" column="id" />
          <result property="pwd" column="pwd" />
          <result property="name" column="name" />
          <result property="email" column="email" />
          <result property="joinDate" column="joinDate" />
  	</resultMap> 
  <--! 컬렉션과 유사-->
  ```

  - DB에서의 Session

    - Connection 부터 close까지 그 사이의 작업

    ```java
    SqlSession session = sqlMapper.openSession();
    //openSession을 하는 즉시 Connection된다.
    ```

  - 

# Q&A

1. 컨테이너란?

   - 자기 실행 환경, 서블릿 실행 환경
   - 톰캣 : 서블릿의 생성, 초기화, 서비스 실행, 소멸에 관한 모든 권한을 가지고 서블릿을 관리
2. 페이지는 무엇인가?

   - 정보를 제공해주는 역할, 후에 프로세스를 처리해주는 역할까지 확장, servlet이 이 역할을 맡게 됨
3. 빈(bean)이란?

   - 오브젝트, 인스턴스 객체
4. url 분석

   - ``https://us02web.zoom.us/postattendee?mn=1osXnULwF-l8SkxYDBYzwdQ1X4sLlUk_oy4c.5bTyFkjbE08tsg5R&id=1``
   - http 프로토콜,  s 시큐리티
   - us02web.zoom.us 도메인
   - postattendee 페이지
   - ?mn=1osXnUL~ 쿼리 스트링 key&value방식
5. 스프링이란?
   - MVC모델을 자동화 한 것
6. 프로젝트 구조란?
   - 환경 설정을 의미, 각종 파일이 어디에 위치하는지에 유의
7. 22장에서는 ConnectionManager가 존재하지 않는 이유?
   - Spring에서는 컨테이너가 ConnectionManager의 역할을 함
8. 스프링의 두 가지 기능
   - DI 와 IoC
   - 데이터를 외부에서 공급하고, 데이터를 처리하는 클래스도 외부에서 공급함
9. 824p의 제대로 처리해 주지 않으면의 의미는?
   - Close가 되지 않은 것을 의미
10. 마이바티스나 하이버네이트 같은 데이터베이스 연동관련 프레임워크 : ORM FrameWork
11. ``<bean>``태그를 모두 작성하려 하기 보다 그 안의 ``<prop key>``값과 ``<property>`` 설정에 더 집중할 것
12. 현재 프로그램의 특징
    - 요구사항의 변경이 심해 언제든지 코딩의 변화가 필요함
    - 따라서 DI와 IoC와 같은 기술을 가진 스프링이 필요한 것, 고정 제거
13. 스프링의 목적
    - 쉽게 기업형 프로그램(반제품을 통해)을 만들기 위해
14. 



# Error

- 프로젝트 임포트 시 에러 multi method error 

  Build Path를 들어가서 문제의 파일 클릭 후 Edit 클릭 후 Workspace default JRE로 변경

- ![mysql라이브러리에러](md-images/untitle.png/mysql%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC%EC%97%90%EB%9F%AC.JPG)

com.mysql.cj.jdbc.Driver에서는 3.0버전을 호환하지 않음 따라서 8.0 버전을 카피해서 해결
