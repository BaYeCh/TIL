# Web Application Developer

>  오늘 당신이 헛되이 보낸 하루는 어제 죽은 이가 그렇게 보내고 싶었던 내일이었습니다.

## Network

- 3-Tier(Client-Server-Database)
- 하나의 서버는 자신이 책임지는 부분에 대해서만 서비스 한다
- 서버를 이용하기 위해서는 기본적으로 서비스 상태여야만 이용할 수 있다
- 눈에 보이는 것이 중심! 

![웹 어플리케이션의 기능 기본 연결도](md-images/untitle.png/%EC%9B%B9%20%EC%96%B4%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98%EC%9D%98%20%EA%B8%B0%EB%8A%A5%20%EA%B8%B0%EB%B3%B8%20%EC%97%B0%EA%B2%B0%EB%8F%84.JPG)

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



- 클라이언트에서 요청을 보내서 서버에서 받고 서버는 이를 받아서 로직을 수행한다.

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

  타입을 지정하지 않아도 알아서 판단(Python도 같은 특징을 갖음)

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
  function 함수이름(){
  
  }
  ```

- 매개변수와 반환 값

  ```javas
  function 함수이름(매개변수, 매개변수, 매개변수){
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

## Scrum

![스크럼방법론](md-images/untitle.png/%EC%8A%A4%ED%81%AC%EB%9F%BC%EB%B0%A9%EB%B2%95%EB%A1%A0.JPG)

- Product Owner (발주자)
  - ScrumMaster의 입장에서가 아닌 PO의 입장에서 웹의 여러 가지 서비스 중 불편하거나 개선을 생각
- ProductBacklog (아이디어)

## 코딩테스트

- 알고리즘이 프로그래머로써의 역량을 보여주는 것은 아니다.
- 알고리즘이 적용되는 파트가 10%가량의 점유율을 가진다.
- 코딩테스트의 가장 주안점은 논리성을 보고자 함.
- 최근에는 어려워져 외워서 테스트를 보는 형태가 됨
- 알고리즘 문제 풀이
  - [1](https://programmers.co.kr/)
  - [2](https://www.acmicpc.net/)
  - [3](https://swexpertacademy.com/main/main.do)

## AI

- Digital Transformation 분야에서 많은 기회가 있을 수 있음
- 라즈베리 파이의 커맨드 창을 열어서 ifconfig를 치고 wlan에 나와 있는 IP주소를 확인할 수 있음
- 음성인식(STT, Speech-to-Text)
  - AMK 실습 ex2
- 음성합성(TTS, Text-to-Speech)
  - AMK 실습 ex3(동작 안함)
- 기업에서 요구하는 인재상이란?
  - 가지고 있는 데이터를 활용해서 또 다른 데이터를 재생산하는 아이디어를 반영해서 소프트웨어를 만들 수 있는 지식
  - 시스템 지식이 필요하다
  - 기발한 아이디어는 시스템과 결합했을 때 발생한다
- MVC모델의 Service 파트에 들어가서 DB에서 쿼리를 보내거나 Controller로 작업지시를 내리는 역할을 한다.
- AI에 대한 기본지식을 첨가해서 만들고자 하는 소프트웨어를 개선하는데 기여함
- api는 제공하는 쪽에서 결정권을 가지고 있기 때문에 우리가 원하는 것을 찾지 못한다면 쓰지 못하므로 과감히 버릴 것
- AI쪽에 관심이 있다면 챗봇을 통해서 기본을 다져보는 것도 좋은 방법이 될 것

## Cloud

- 무수한 컴퓨터로 연결된 네트워크 언제 어디에서나 접속할 수 있음
- 통신망을 통해서 음성, 데이터 등을 전송 수신을 할 수있음

### Naver Cloud Platform

- ![mvc확장](md-images/untitle.png/mvc%ED%99%95%EC%9E%A5.PNG)

- 필요한 것을 골라 쓴다

- api의 활용 코드는 제공되나 본인이 사용하는 툴이나 구조에 맞게 재 작성해주어야 함

- api해석(Papago Translation)

  ```java
  public String translate(String words) throws DataAccessException {
  			// TODO Auto-generated method stub
  			//String result = "번역완료";
  			 StringBuffer res = null;
  			 String clientId = "y3ewx22er5";//애플리케이션 클라이언트 아이디값";
  		     String clientSecret = "z2Zsxj68tX5B0DUADpbSgjdEqmkMjlkfQmyK3wZC";//애플리케이션 클라이언트 시크릿값";
  		     try {
  		         String text = URLEncoder.encode(words, "UTF-8");
  		         String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
  		         //jdbc 처리하던 방법과 유사
  		         URL url = new URL(apiURL);
  		         HttpURLConnection con = (HttpURLConnection)url.openConnection();//DB연결할 때 썼던 connection과 비슷
  		         con.setRequestMethod("POST");
  		         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
  		         con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
  		         // post request
  		         String postParams = "source=ko&target=en&text=" + text;
  		         con.setDoOutput(true);
  		         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
  		         wr.writeBytes(postParams); //바이트로 쪼갬
  		         wr.flush(); //남김없이 모두 보내는(변기 물 내리는 것 생각)
  		         wr.close();
  		         int responseCode = con.getResponseCode();
  		         BufferedReader br;
  		         if(responseCode==200) { // 정상 호출
  		             br = new BufferedReader(new InputStreamReader(con.getInputStream()));//바이트로 들어온 것을 문자열로 바꾸고 
  		         } else {  // 오류 발생
  		             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
  		         }
  		         String inputLine;
  		         res = new StringBuffer();
  		         while ((inputLine = br.readLine()) != null) {
  		             res.append(inputLine);
  		         }
  		         br.close();
  		         System.out.println("service "+res.toString());
  		     } catch (Exception e) {
  		         System.out.println(e);
  		     }
  			
  		     //요청한 내용에 대한 번역한 결과
  			return res.toString();
  			// res.toString()의 결과service {"message":{"@type":"response","@service":"naverservice.nmt.proxy","@version":"1.0.0","result":{"srcLangType":"ko","tarLangType":"en","translatedText":"Hello"}}}
  }
  ```

- CLOVA Speech Recognition

  - AiController

    ```java
    @RequestMapping(value="/clovaSTT", produces = "application/text; charset=UTF-8")
    	@ResponseBody
    	public String stt(@RequestParam("uploadFile") MultipartFile file,
    								@RequestParam("language") String language) {
    		String result = "";
    		
    		try {
    			//1. 파일 저장 경로 설정 : 실제 서비스 되는 위치 (프로젝트 외부에 저장)
    			  String uploadPath =  "c:/ai/";
    			  
    			  //2.원본 파일 이름
    			  String originalFileName = file.getOriginalFilename();  
    			  
    			  //3. 파일 생성 
    			  String filePathName = uploadPath + originalFileName;
    			  File file1 = new File(filePathName);
    			  System.out.println(filePathName);
    			  //4. 서버로 전송
    			  file.transferTo(file1);
    			  
    			  result = aiService.clovaSpeechToText(filePathName, language);
    			  System.out.println("ai "+result);
    			  
    		}catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return result;
    	}
    ```

  - AiService

    ```java
    public String clovaSpeechToText(String filePathName, String language) {
    		// TODO Auto-generated method stub
    		String clientId = "";             // Application Client ID";
            String clientSecret = "";     // Application Client Secret";
            String result = null;
            try {
                String imgFile = filePathName;
                //파일 객체 생성
                File voiceFile = new File(imgFile);
    
                //String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
                String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
                URL url = new URL(apiURL);
    
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setUseCaches(false);
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestProperty("Content-Type", "application/octet-stream");
                conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
                conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
    
                
                OutputStream outputStream = conn.getOutputStream();
                FileInputStream inputStream = new FileInputStream(voiceFile);
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
                inputStream.close();
                BufferedReader br = null;
                int responseCode = conn.getResponseCode();
                if(responseCode == 200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf8"));
                } else {  // 오류 발생
                    System.out.println("error!!!!!!! responseCode= " + responseCode);
                    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                }
                String inputLine;
                
                if(br != null) {
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = br.readLine()) != null) {
                        response.append(inputLine);
                    }
                    br.close();
                    System.out.println(response.toString());
                    result = response.toString();
                    //왜 toString인가? 코드가 지저분해짐(String으로 사용하면 정보 수정관리가 쉽지 않음)
                    //브라우저나 페이지가 했던 작업을 대신 해주는 것
                    //String은 불변의 자료형(내부적 배열(크기 고정))
                } else {
                    System.out.println("error !!!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
    		return result;
    	}
    ```

  - ``stt.js`` 해석

    ```js
    alert('stt_text');
     $(function(){
    	$('#sttForm').on('submit', function(event){
    		event.preventDefault(); //submit 후에  reload 안 되게
    		formData = new FormData($('#sttForm')[0]);
    		
    		$.ajax({
    			type:"post",
    			enctype:"multipart/form-data",//필수
    			contentType:"application/json; charset:UTF-8",
    			url:"clovaSTT",
    			data:formData,
    			processData:false, //필수
    			contentType:false, //필수
    			success:function(result){
    				alert(result);
    				data = JSON.parse(result);
                    //key&value 값으로 받음(Map방식)
    				$('#resultDiv').text(data.text);
    			},
    			error:function(e){
    				alert("에러 발생 : " + e);
    			}			
    		});
    	});
    });
    ```

    한글 처리가 이루어지지 않았고, 이는 입력과 출력의 문제에서 해결할 수 없었음(바이트로 쪼개서 해석하기 때문에) 이를 해결하기 위해서

    ```java
    br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf8"));//바이트로 들어온 것을 문자열로 바꾸고
    //utf8을 추가하여 해결
    ```

    

#### Chat BOT

질문 유형

- 표현은 다르지만 의미가 비슷한 질문들을 15~20개(이상적 : 50여개)를 추가함

공통메시지

- 질문을 인식하지 못했을 때 사용하는 메시지
- 웰컴메시지는 반드시 적어야 함\

대화모빌빌드

- 빠른 빌드(머신러닝 없이 완전 일치 매칭으로 동작)
- 대화 모델 빌드(적어놓은 여러 가지 질문들을 머신러닝하여 다양한 질문에 유연하게 대처할 수 있음)

수동테스트를 통해서 빌드를 확인하고 시험해볼 수 있음

어디서든지 만든 챗봇을 연결하기 위해서

- 챗봇 설정에서 메신저 연동 Custom (API Gateway End-point)를 활성화

- 실행 과정

  1. 컨트롤러와 서비스를 만들고 URL과 KEY값을 세팅

  2. server.xml에 추가

     ```xml
     <Context docBase="e:\\ai\\" path ="/ai/" reloadable="true"/>
     ```

- 실행 확인

  1. 웰컴 인사 확인
  2. 문자 질문 테스트
  3. 음성 질문 테스트



#### Error

- ![STT500에러](md-images/untitle.png/STT500%EC%97%90%EB%9F%AC.JPG)

  연결하지 못했다는 신호 이 경우는 따로 url을 접속하는 RequestMapping을 만들어 주지 않아서 생겼다.

- API와 이클립스 간의 연결은 스트림을 통해서 이루어 짐

- TTS

  - ```java
    var formData = new FormData($('#ttsForm')[0]);
    //
    ```

  - 새로 연습할 때 주의점

    - maxSize를 지켰는가를 확인(servlet-context에서 확인)
  
- Web Dynamic Map

  - 할당한 url을 정확하게 사용할 것
  
- 챗봇 웰컴 메시지 나오지 않는 에러

  ![챗봇웰컴메시지나오지않는에러](md-images/untitle.png/%EC%B1%97%EB%B4%87%EC%9B%B0%EC%BB%B4%EB%A9%94%EC%8B%9C%EC%A7%80%EB%82%98%EC%98%A4%EC%A7%80%EC%95%8A%EB%8A%94%EC%97%90%EB%9F%AC-16381675232071.JPG)

  다른 사람의 URL과 키를 사용하니까 정상적으로 작동됨.
  
  내가 만든 API에 문제가 있는 것으로 보임(맞왜틀 시전중)

## 공공데이터 포탈

- xml 파싱

  ```java
  public class test3 {
  
      // tag값의 정보를 가져오는 메소드
  	private static String getTagValue(String tag, Element eElement) {
  	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
  	    Node nValue = (Node) nlList.item(0);
  	    if(nValue == null) 
  	        return null;
  	    return nValue.getNodeValue();
  	}
  
  	public static void main(String[] args) {
  		int page = 1;	// 페이지 초기값 
  		String servicekey = "KNJDk8kQqqEUjNwKv4aYv2v6KA4JUb3i3uLgrv36XFZ0OW3GvOh1ILHDtQDA0lWMxIoxc9m%2FjGdD9E5lvlY5xg%3D%3D";	// 병원 위치 찾기
  		String WGS84_LON = "127.085156592737";	//입력 사항
  		String WGS84_LAT = "37.488132562487";	//입력 사항
  		int pageNo = 1;	//입력 사항
  		String numOfRows = "5";	//입력 사항
  		try{
  			while(true){
  				// parsing할 url 지정(API 키 포함해서) 바꿔야됨
  				String url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getBabyLcinfoInqire?"+"serviceKey="+servicekey+"&WGS84_LON="+WGS84_LON+
  						"&WGS84_LAT="+WGS84_LAT+"&pageNo="+Integer.toString(pageNo)+"&numOfRows="+numOfRows;
  				
  				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
  				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
  				Document doc = dBuilder.parse(url);
  				
  				// root tag 
  				doc.getDocumentElement().normalize();
  				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
  				
  				// 파싱할 tag
  				NodeList nList = doc.getElementsByTagName("item");	//변경함
  				//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
  				
  				for(int temp = 0; temp < nList.getLength(); temp++){
  					Node nNode = nList.item(temp);
  					if(nNode.getNodeType() == Node.ELEMENT_NODE){
  						
  						Element eElement = (Element) nNode;
  						//System.out.println("######################");
  						//System.out.println(eElement.getTextContent());
  						System.out.println("병원코드  : " + getTagValue("hpid", eElement));	//변경해야됨
  					}	// for end
  				}	// if end
  				
  				pageNo += 1;
  				System.out.println("page number : "+pageNo);
  				if(pageNo > 3){	//변경함
  					break;
  				}
  			}	// while end
  			
  		} catch (Exception e){	
  			e.printStackTrace();
  		}	// try~catch end
  	}	// main end
  }	// class end
  ```

  

## 취업 관련

- 자신이라는 상품을 기업에게 ''설득''
- 기업을 정하고 그에 맞추어 자기소개서를 작성하는 것이 전략적
