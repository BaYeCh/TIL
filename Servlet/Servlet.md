# Day21

## Servlet

- Servlet : 데이터를 처리하는 클래스
  1. url을 어떻게 결정할 것인가? 클래스를 어떻게 찾아갈 것인가?
  2. httpServlet 클래스가 데이터 처리 작업을 수행
  3. 상속받아서 오버라이딩을 통해 요청을 받을 때 수행함
- get, post방식으로 들어오는 것을 처리할 수 있음
- 클라이언트로부터 외부 정보를 받아오기 위해서는 스트림이 필요함
- 스트림 대신 get과 post의 매개변수(req, resp)를 이용해서 사용함

```java
//클래스 생성시 super클래스에서 HttpServlet을 추가해서 만든 클래스
public class MemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	//doGet과 doPost를 ctrl+space해서 쉽게 만들 수 있다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//브라우저에 보냄
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
         out.print("Hello");
	}
}
```

- VM(virtual machine)은 컨테이너(application server)와 같다.
- I,O에 관련된 두 통로를 모두 알고 있음

### 생명주기

- 로딩 이후에는 더 이상 개발자는 관리하지 않으며, 삭제할 때까지 컨테이너가 이를 책임짐. 컨테이너가 인스턴스를 컨트롤할 때 서블릿의 생명주기에 관련된 메소드를 가지고 관리한다. 관리에 주 목적이 있음
- 로딩 시 이루어지는 과정

1. 초기화
   - init(), 자동으로 DB에 연결하게 됨, 생성자와 동일하지는 않지만 역할은 동일.
   - Connection을 맺은 상태로 계속할 수 없기 때문에 init에서 Connection이 이루어지지 않는다.
2. 작업 수행(서비스)
   - doGet(), doPost() :  요청에 따라 골라 쓰임
3. 종료
   - destroy(), 서버에 접속된 Connection을 제거 함.

- 차례대로 호출 됨, 순서가 어긋나 에러가 일어나지 않음, init과 destroy는 단 한 번만 호출됨

### Web.xml

- 하나의 어플리케이션에 관련된 데이터 환경 정보 설정이 이 xml에 들어감

- extensible markup language

- 서블릿의 등록 정보

- 서비스를 하는 전체적인 내용, 필요한 환경설정 정보, 태그의 집합

- 사용자가 서비스(주소)만 적고 따로 정보가 입력되지 않을 시 자동으로 불러오는 파일

  ```xml
  <welcome-file-list>
      <welcome-file>index.html</welcome-file>
      <welcome-file>index.htm</welcome-file>
      <welcome-file>index.jsp</welcome-file>
      <welcome-file>default.html</welcome-file>
      <welcome-file>default.htm</welcome-file>
      <welcome-file>default.jsp</welcome-file>
    </welcome-file-list>
  ```

- 자바 웹 어플리케이션의 정보를 web.xml에서 일단 다 로딩함

- 작성

  ```xml
  <servlet>
    	<servlet-name>controller</servlet-name>
    	<servlet-class>mc.sn.controller.MemberController</servlet-class>
    </servlet>
    <servlet-mapping>
    	<servlet-name>controller</servlet-name>
    	<!-- url을 지정해서 적어 놓는 과정 -->
    	<url-pattern>/CmdController</url-pattern>
    </servlet-mapping>
  ```

- DOM 방식과 SAX 방식
- 태그의 역할
  - HTML에서는 정보의 구조와 이미지를 책임지고 있다.
  - 데이터를 명시하는 역할
  - 원하는 데이터를 가져가기 위해서는 태그를 사용함 따라서 태그의 설계가 중요함
  - xmlDB가 만들어지긴 하였으나 너무나 방대한 양의 태그로 인해 더 이상 쓰이지 않음
- 관리가 어렵고 다수의 에러 발생으로 최근에는 사용이 줄어드는 추세
- instance를 만들어서 관리하는 것은 컨테이너가 함

# Day22

- Servlet : Controller

  자기 책임성의 원칙에 따라 하는 일을 분리했다.

1. Server
2. Business
3. DAO(Data Access Object)
4. Connection

- VO(Value Object) = DTO(Data Transfer Object) = DataBean

1. VIEW Client(html)
   1. in
   2. out
2. SERVER Controller WAS(java)
   1. Servlet
      1. Business
      2. DB(crud)
      3. Connection
3. MODEL DB(sql)
4. VO(Value Object)

- 하나의 서블릿에 여러 개의 작업을 처리하기 위해서 작업처리 cmd를 QueryString 방법을 이용하여 전ㄷ라함

  ```java
  http:/localhost:9090/BasicWeb/member/CmdController?key=value
  ```

- list의 경우 다른 페이지에 접근하는 것이 아니라 url을 통해 바로 접근했음

## QueryString

- MVC방식 이전에 Model2라 불림
- Servlet의 유무에 따라 Model1과 Model2로 나뉨
- CmdController라는 서블릿을 중복해서 처리할 수는 없기 때문에
- get방식으로 보내는 것을 QueryString이라고 한다.
- url을 ``CmdController?key=value``의 형태
- 의사표시가 가능 : 작업지시 커맨드를 보내는 것
- 하나의 서블릿에 여러 개의 지시가 가능하게 됨

# Day23

- 애자일 방법론

- 삭제 작업

- DAO와 Service의 차이
  - 자바에서 실질적으로 비즈니스 로직을 사용하기 위해 필요한 데이터는 데이터베이스에서 DAO를 통해 가져오게 됨
  - 복잡한 데이터 처리의 경우 Service에서 감당한다
- RequsetDispatcher 
  - 두 세 페이지인 경우에 사용함
- Session
  - 여러 페이지를 오랜 시간동안 사용할 때 사용함
- ConnectionPool
  - 대여와 반납의 개념



# Error

- ![리소스를찾을수없는에러](md-images/untitle.png/%EB%A6%AC%EC%86%8C%EC%8A%A4%EB%A5%BC%EC%B0%BE%EC%9D%84%EC%88%98%EC%97%86%EB%8A%94%EC%97%90%EB%9F%AC.JPG)

리소스를 찾을 수 없다는 에러, 이름이 잘못되었거나 철자가 틀린경우 자주 발생

- ![저장후서버에reload](md-images/untitle.png/%EC%A0%80%EC%9E%A5%ED%9B%84%EC%84%9C%EB%B2%84%EC%97%90reload.JPG)

서블릿에서는 저장 후에 서버에 re-load하는 과정을 거침

- ![listisnullerror](md-images/untitle.png/listisnullerror.JPG)

 Query String 오류, 먼저 리퀘스트를 받고 리스폰스를 하는 과정이 들어가야 하는것이지 곧바로 결과를 도출하려다 나오는 에러, 브라우저에 http://localhost:9090/MVCBasic/CmdController?cmd=list를 통해 멤버 리스트를 호출하는 것!