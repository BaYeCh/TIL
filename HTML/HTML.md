# HTML

- Hyper Text Markup Language
- 인터넷 : 네트워크들을 연결한 것
  - LAN
  - WAN

- URL(Uniform Resource Location)
  - 리소스의 위치를 규정
  - 정보를 찾아가기 위한 규칙

## 3 Tier

- 클라이언트 프로그램
  - 프론트엔드
- 서버 프로그램
  - 미들웨어(java)
- 데이터베이스
  - 백엔드(oracle)

## CSS

- HTML페이지에 스타일을 지정하는 스타일시트를 작성할 때 사용하는 언어

## HTML5

- 장치 접근
  - 장치에 접근해 정봐 기능을 사용
- 시맨틱
  - 검색 엔진 같은 프로그램이 정보를 분석, 자료를 검색 및 처리해서 제공하는 지능형 웹
- CSS3 스타일 시트

- WAS : 웹 서버인 동시에 어플리케이션 서버



http://localhost:9090/BasicWeb/day16/welcome.html

http : 프로토콜

- 톰캣의 포트번호가 이미 다른 곳에서 쓰이고 있다는 에러 창

![톰캣의 포트번호를 사용할 수 없다는 에러표시](md-images/untitle.png/%ED%86%B0%EC%BA%A3%EC%9D%98%20%ED%8F%AC%ED%8A%B8%EB%B2%88%ED%98%B8%EB%A5%BC%20%EC%82%AC%EC%9A%A9%ED%95%A0%20%EC%88%98%20%EC%97%86%EB%8B%A4%EB%8A%94%20%EC%97%90%EB%9F%AC%ED%91%9C%EC%8B%9C.JPG)

## 입력 양식 태그

- 개발자가 알아야 할 것
- 데이터를 입력받는 태그가 필요함(정보를 구조화하기 위한 것이 아님)

### 데이터 전달 방식

- ``<form>``태그는 method속성의 방식으로 action 속성 장소에 데이터 전달

  ```html
  <form action = "전송위치" method = "전송 방식">
      
  </form>
  ```

- GET방식 : 주소에 데이터를 입력해서 전달(url+데이터)

  ```html
  <!-- GET 전송 방식 -->
  <body>
      <form method = "get">
          <!-- name : 키값 -->
          <input type = "text" name = "search">
          <input type = "submit">
      </form>
  </body>
  ```

  name : 데이터를 구분할 수 있게 하는 키 값

- POST방식 : 주소 변경 없이 비밀스럽게 데이터 전달

  ```html
  <!-- POST 전송 방식 -->
  <body>
      <form method = "post">
          <input type = "text" name = "search">
          <input type = "submit">
      </form>
  </body>
  ```

## HTML 문서 구조화

- 공간 분할 태그

| 태그          | 설명                                                |      |
| ------------- | --------------------------------------------------- | ---- |
| div(division) | 블록 형식으로 공간 분할 , 줄이 자동으로 바뀜        |      |
| span          | 인라인 형식으로 공간 분할, 왼쪽에서 오른쪽으로 쌓임 |      |

- 시맨틱 태그

  - HTML5에서부터 적용
  - 컴퓨터 프로그램이 코드를 읽고 의미를 인식할 수 있는 지능형 웹

  ```html
  <body>
      <header>
  		<!-- 머리말-->
      </header>
      <nav>
      <!-- 하이퍼링크를 모아둔 내비게이션-->
      </nav>
      <section>
      <!-- 문서의 장이나 절에 해당하는 내용-->
      	<article><!-- 본문과 독립적인 콘텐츠 영역--></article>
          <article></article>
      </section>
      <footer>
      <!-- 꼬리말-->
      </footer>
  </body>
  ```

- 현재는 div와 시맨틱을 혼용해서 쓰고 있음
