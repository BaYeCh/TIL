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

