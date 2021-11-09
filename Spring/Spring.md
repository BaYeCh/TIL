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

- Object Relational Mapping

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


# Day28

- XML parser

  ```xml
  <select id="selectAllMemberList" resultMap="memResult">
      <!-- xml parser 구문-->
        <![CDATA[
           select * from t_member	order by joinDate desc	 	
        ]]>
  	</select>
  ```

### Spring Annotation

- 자동화

- 여러 가지 스테레오 타입 **애너테이션**

  ```java
  @Controller("mainController")
  //컨트롤러 빈
  @RequestMapping("/test")
  public class MainController {
     @RequestMapping(value="/main1.do" ,method=RequestMethod.GET)
     public ModelAndView main1(HttpServletRequest request, HttpServletResponse response)  throws Exception{
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg","main1");
        mav.setViewName("main");
        return mav;
     }
  ```

  ``<component-scan>``태그에 의해 지정한 클래스를 ``@Controller`` : 컨트롤러 빈, ``@service`` : 서비스 빈, ``@Repository`` : DAO 빈, ``@Component`` : 빈 으로 자동 변환

- ``<component-scan>``태그

  ```xml
  <context:component-scan base-package="com.spring"/>
  ```

- ``@Autowired``

  별도의 setter나 생성자 없이 속성에 빈을 주입할 수 있음

# Maven

- 4차 산업에서 핵심 : 반도체
- POM(Project Object Model)
  - Object - ``<>``태그들
- WEB-INF의 폴더 안에 JSP를 넣는다
  - 외부에서 들어오는 방법이 없으며, 보안의 가장 기본적인 방법
  - Controller를 통해서만 들어와야 함
- 기준 소스파일구조를 따를 것(자바 웹을 다루는 기술 967p)
- xml을 이용하여 환경설정
- 동작하지 않을 시 가장 먼저 체크해야 할 항목이 환경설정
- 프로그램 동작에 필요한 파일들이 서로 연결되어 있는지 확인을 하는 것이 중요
- 환경설정 시에 어느 정도 시간이 소요 되므로 조금 기다리거나 재부팅을 해볼 것
- pom.xml의 역할
  - 프로젝트를 정의하고, 프로젝트에 필요한 jar파일들을 관리(dependency)
  - 라이브러리를 수급해 코딩하기위한 준비 작업
- [pom.xml관련 dependency](https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload)
- pom을 통해서 해당되는 태그 입력 시 필요한 jar을 받아오게 됨



- LoginMVC를 스프링의 최종 버전으로 바꾸기 위한 방법
  - pom.xml을 이용한 jar 업로드
  - WEB-INF로 jsp파일 및 여러 설정 파일(action-mybatis등)을 변경

# Day29

- 의사소통 능력을 키워야 함
- 반드시 팀 활동 위주로 할 것
- 모든 활동은 오픈형
- Spring Boot
  - 성능이 빠르진 않음
- localhost(도메인) = 127.0.0.1(IP) 로 브라우저에서 대신할 수 있음 

# Day30

- 환경설정
  - 자바 웹을 다루는 기술 27장이 기본
  - pom.xml을 무조건 복사 하지 않는다
    - 기본으로 만들어진 것에 필요한 것을 한꺼번에 넣지 않고 하나씩 추가한다.
    - pom.xml 컴파일 에러 발생 시 반드시 수정 후 코딩
  - mySQL의 경우 Timezone과 드라이버 이름의 변경으로 인한 에러에 주의한다.
    - maven의 8.0.27버전의 mySQL을 사용
  - 서비스(**``@Service``**), 컨트롤러(**``@Controller``**), VO, DAO(**``@Repository``**)에 대한 어노테이션을 정확히 작성한다.
  - 마이바티스의 modelConfig.xml에 적용되는 VO의 패키지명을 정확히 입력한다.(복붙 시 패키지명이 달라짐)
  - 파일 이미지에 S가 나와있으면 스프링이 적용되고 있음을 의미

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
14. Dependency Injection이란?
    - 작업절차 진행 시 자기책임성의 원칙에 따라서 데이터에 의존할 수 밖에 없음
    - 한 클래스가 필요로 하는 데이터를 생성자나 set메소드를 통해서 공급받는데 그 타입이 클래스타입이다.
    - 기존과 무엇이 다른가? 개발자가 직접 작성하는 것이 아니라 필요한 시점에 <u>외부에서 컨테이너가 자동(IoC)</u>으로 Injection해줌
15. Servlet : server applet
16. 마이바티스(ORM)의 역할
    - JDBC의 역할, 커넥션관리(Connection pooling), action태그를 이용해서 태그 안의 정보로 <u>외부에서</u> 작업지시가 이루어짐
17. 다형성이란?
    - 상위 클래스의 타입을 가진 변수에 하위클래스를 인스턴스할 수 있다.
    - 자바 언어의 특징
18. 프레임 워크란?
    - 반 제품, 반 자동화
    - 연결의 방법과 구조는 이미 정해져 있음

19. 프로그래밍에서 자동화란?
    - 개발자가 코드를 작성하지 않는 것을 의미
    - Annotation, xml

20. Spring 프레임워크에서 사용하는 xml들
    - web.xml : 컨트롤러 위치를 알려주며, ``filter``를 통해 한글 처리, 웹어플리케이션 기본 환경설정 
    - servlet-context.xml : 요청 처리와 아웃풋 처리하는 데 필요한 정보
    - db.properties : 데이터 소스관리
    - action-mybatis.xml : 데이터베이스 연결, 커넥션 풀, 쿼리 자동화(저수준의 jdbc), VO정보 위치
    - mapper.xml : 쿼리 자동화
    - mybatisconfig.xml : VO정보 위치
    - pom.xml : jar파일 자동 업로드

21. member.xml에서 resultMap 리스트를 리턴할 때



# Error

- 프로젝트 임포트 시 에러 multi method error 

  Build Path를 들어가서 문제의 파일 클릭 후 Edit 클릭 후 Workspace default JRE로 변경

- ![mysql라이브러리에러](md-images/untitle.png/mysql%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC%EC%97%90%EB%9F%AC.JPG)

com.mysql.cj.jdbc.Driver에서는 3.0버전을 호환하지 않음 따라서 8.0 버전을 카피해서 해결, 위의 에러는 철자도 다름

- ![빈생성오류](md-images/untitle.png/%EB%B9%88%EC%83%9D%EC%84%B1%EC%98%A4%EB%A5%98.JPG)

브라우저에서는 서블릿이 호출이 되지 않았으며, 콘솔상으로는 빈이 생성되지 않았다는 오류

해결방법

```xml
<listener>
      <listener-class>
         org.springframework.web.context.ContextLoaderListener
     </listener-class>
   </listener>
```

ContextLoaderListener를 추가하여 실행하여 확인한다

- 500 MySQL Connection 에러

  1. pom.xml에서 8.0버전을 업로드 하는 방법
  2. 5버전에서 존재하는 것만을 사용 com.mysql.jdbc.Driver

- ![한글이 안나오는 경우](md-images/untitle.png/%ED%95%9C%EA%B8%80%EC%9D%B4%20%EC%95%88%EB%82%98%EC%98%A4%EB%8A%94%20%EA%B2%BD%EC%9A%B0.JPG)

  보통 입력 부분, DB 입력 부분, 출력부분으로 총 3부분에서 에러가 남 그래서 DB에 들어가는 데이터를 확인 하고 정상적으로 나온다면 출력부분이 데이터가 정상적이지 않다면 입력부분에서 문제가 생긴다는 것을 확인할 수 있음

  해결 : web.xml을 변경하는 것으로 할 수 있음

  ```xml
  <filter>
  		<filter-name>encodingFilter</filter-name>
  		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
  		<init-param>
  			<param-name>encoding</param-name>
  			<param-value>UTF-8</param-value>
  		</init-param>
  	</filter>
  	<filter-mapping>
  		<filter-name>encodingFilter</filter-name>
  		<url-pattern>/*</url-pattern>
  	</filter-mapping> 
  ```

  - ![입력부분은정상이지만출력에서문제가발생](md-images/untitle.png/%EC%9E%85%EB%A0%A5%EB%B6%80%EB%B6%84%EC%9D%80%EC%A0%95%EC%83%81%EC%9D%B4%EC%A7%80%EB%A7%8C%EC%B6%9C%EB%A0%A5%EC%97%90%EC%84%9C%EB%AC%B8%EC%A0%9C%EA%B0%80%EB%B0%9C%EC%83%9D-16360909671311.JPG)

  DB에서 저장이 올바르지 못한 것으로 확인

- ![properties를수정](md-images/untitle.png/properties%EB%A5%BC%EC%88%98%EC%A0%95.JPG)

  properties를 수정하여서 url을 불러 올 때 characterEncoding으로 바꾸어주는 것을 추가

  ![디버깅후결과](md-images/untitle.png/%EB%94%94%EB%B2%84%EA%B9%85%ED%9B%84%EA%B2%B0%EA%B3%BC.JPG)

디버깅 시에 어디에서 에러가 발생하는지를 위치를 추리고 그 장소에서 출력을 통해 확인한다.

- 404 에러 시에는

  server.xml까지 확인해 볼 것

- 400 에러 - 잘못된 요청(Bad Request) : 처리할 수 있는 인증, 권한이 없음을 의미

  - 요청을 하려면 요청한 내용을 인식해야 하지만 서버가 내용을 인식하지 못함
  - 원인 :  url에 한글정보가 기입되어 있는 경우(원래는 자주 나오지는 않으나 Download의 경우 발생하게 됨)
  - 해결 : 
    1. post를 이용하여 url정보에 한글이 기입되는 경우를 제거 
    2. SetCharacterEncoding을 이용
    3. ``<a>``태그로 보내는 것이 아니라 ``<form>``태그로 변환하여 보내면 원인을 제거 가능
