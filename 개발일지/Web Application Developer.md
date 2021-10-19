# Web Application Developer

## Network

- 3-Tier(Client-Server-Database)
- 하나의 서버는 자신이 책임지는 부분에 대해서만 서비스 한다
- 서버를 이용하기 위해서는 기본적으로 서비스 상태여야만 이용할 수 있다
- 눈에 보이는 것이 중심! 

![웹어플리케이션 구조](md-images/untitle.png/%EC%9B%B9%EC%96%B4%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98%20%EA%B5%AC%EC%A1%B0.png)

- M(DB: model)V(Client: view)C(Middleware: controller) 17장

## Web

- 웹에서 기본 단위는 페이지
  - 초창기 페이지는 정적자료, 정확한 어떤 사실만을 기록
  - Hyper Text(Link)를 이용해서 수 많은 페이지 중에서 원하는 페이지를 고를 수 있음
  - 중복 제거를 통해 동적 페이지(``JSP``)
- ``HTML``,``CSS``

## ``JSP``

- 자바와 ``SQL``을 연결할 때 Statement를 이용했듯이 ``JSP`` 역시 연결할 스트림이 필요하다
- ``Jsp``의 파일의 구성이 ``html``과 유사한 것이지 ``html``에서 ``jsp``파일처럼 사용할 수는 없다.
- ``JSP``는 로직을 수행하여야 함



- 클라이언트에서 요청을 보내서 서버에서 받고 서버는 

## 자바스크립트

- 브라우저 안에서만 동작함

- ``html``문서(WEB)를 대상으로만 작업을 진행함

- 특정 분야에서만 작업하는 언어를 스크립트라고 함

- ``GUI``

- 문자와 문자열을 따로 구분하지 않음

- 데이터 타입이 하나 ``var``

  ```javascript
  var name = "";
  ```

  타입을 지정하지 않아도 알아서 판단

- ``HTML``에서의 ``JavaScript``

  ```html
  <!-- 이 형태가 필요함-->
  <script type="text/javascript">
  	
  </script>
  ```

- 출력 ``alert``

  ```javas
  alert("메시지");
  ```

- 배열

  ```javasc
  var array = [45, 5, 78, 9];
  ```

  대괄호를 사용하여 배열을 표현

- 선언적 함수

  ```javas
  function 함수(){
  
  }
  ```

- 매개변수와 반환 값

  ```javas
  function 함수 이름(매개변수, 매개변수, 매개변수){
  	//함수코드
  	return 반환 값;
  }
  ```

  리턴 타입이 존재하지 않는다. = 타입은 ``var``만 존재하기 때문에 굳이 구분하지 않음

- 함수를 호출하는 이벤트가 발생하여야 함

### 자바스크립트 외부에서 받아오기

```html
<script type = "text/javascript" src="../js/validate.js"></script>
```

- ``src``안의 내용은 자바스크립트가 저장되어 있는 주소

- 익명 함수 

  - 이름이 없기 때문에 호출할 수 없음

  ```html
  <script>
  //함수를 선언
      var 함수 = function(){};
  </script>
  ```

  따라서 변수에 함수를 선언함

- 함수에는 타입을 적어넣는 자리가 없음

- 매개변수에 타입을 지정해서 넣지 않고 변수 이름만을 넣는다

  ```html
  <script>
  function f(x){
  }
  </script>
  ```

## jQuery

- 자바를 이용해서 메소드를 호출하기에는 너무 길고 외워야 할 부담이 커진다.

- 이를 해결하기 위해 자바스크립트에서 라이브러리를 만들었다

- 데이터 핸들링을 위한 사용법에 주목할 것 = 문서객체 생성과 추가

- 먼저 문서를 읽어야 함

  ```html
  <script>
  	$(document).ready(function(){
                        $
                        });
  </script>
  ```

- 자바스크립트 초기에는 정적데이터이기에 데이터를 처리할 이유가 없었다. 그렇기 때문에 이미지를 관리하고 변경하는 것이 가장 큰 주안점이었다. 하지만 동적데이터를 처리하는 것이 대두되기 시작하면서 ``css``가 이미지를 담당하고 자바스크립트는 오로지 데이터만을 담당하게 되었다.

- 이스케이프 ``\``

  따옴표를 그대로 전달하면 에러가 발생하지만 이스케이프를 한 후 전달하면 전달받는 쪽에서 이스케이프 해제 함수를 사용하지 않아도 이스케이프가 해제된 문자열을 전달 받을 수 있다.

- ```html
  <td>
      <select name="email" id="email" disabled>
          <!-- disabled = "disabled" -->   
      </select>
  </td>
  ```

  ``disabled``를 쓸 수 있는 이유 : html은 유저 친화적으로 다소 부족한 문법을 사용하더라도 인식하고 원하는 바를 출력해준다. 

- ```html
  <input type = "text" name = "" value="" readonly="readonly"
  ```

  ``readonly``는 데이터를 입력할 수 없이 읽기 전용으로 쓰이는 경우 만약 데이터를 지우려할 시에는 페이지가 넘어간다

- Validation(검증)을 주 목적으로 jQuery를 이용함

