# Python

- 스크립트 언어 (테스트를 위한)
  - 특정 분야를 겨냥해서 만든 언어(ex. 자바스크립트 : 브라우저)
- 간편함, 구조적으로 배우기 쉬움, 빠르게 테스트할 수 있음
- AI와 BigData로 인해 파이썬의 필요가 급증
  - 논문이나 설계 결과를 AI로 활용하기 위해서 라이브러리를 만드는데 다른 언어와 다르게 빠르게 업로드 할 수 있다는 장점이 있음
- 구글에서 만든 AI프레임워크가 파이썬으로 동작하도록 만들었음
- 학습비용이 굉장히 적게 들어감, 자바나 C, C++에 비해 난이도가 낮음
- 자바 언어와의 비교를 통해 언어특성을 습득할 것(단순 암기 X)

## 데이터 표기

- Data (숫자, 문자, 논리) : 변수

  - 데이터 타입이 주어지지 않음
  - 연산자를 이용할 때 타입에 따라서 결과가 도출 되었던 자바와 달리 나눗셈의 몫 구하는 ``//``연산자가 존재함
  - 텍스트
    - 배열의 표기법 이용

- Process : 함수

  - 함수 이름과 값을 집어 넣는 파라메터 리스트가 있음

- 라이브러리 사용

  ```python
  >>>import math
  ```

- 디렉토리는 이클립스의 패키지 개념과 동일

- 확장자는 ``.py``

- Python Console창

  - 인터프리터와 상호작용해서 바로바로 결과를 보여줌

- Pythonfile 내에서는 함수를 이용하여 만들어주어야 함

- 함수와 함수 사이는 두줄 띄워 주어야 함 그러나 무시해도 상관 없음

- 함수 내의 메소드나 코딩은 탭(관례 : 스페이스 4칸) 만큼 띄워 주면서 종속을 표시

- 자바에서는 ``{}``로 블럭을 표시했지만 파이썬에서는 ``:``의 하위에 탭 만큼 띄어진 곳 까지 블럭

- 들여쓰는 것으로 블럭을 대신 함

  ```python
  #주석입니다.
  ```

- ```python
  # 두 정수를 외부에서 입력 받아서 곱한 후에 결과를 리턴하는 함수를 작성하고 해당 함수를 호출해서 결과를 출력하는 코드를 작성하세요
  def test(m,n):
      return m*n
  
  
  result = test(10,2)
  print(result)
  # 결과 : 20
  ```

### 텍스트

- ``''``, ``""`` 으로 감싸서 문자열 표시

- 슬라이싱 (``s[0:4]``)

  - 0번째 부터 4번째 문자 앞까지 분리
  - 문자열의 처음부터 슬라이싱을 원한다면 (``s[:4]``)
  - 문자열의 마지막까지 슬라싱을 원한다면 (``s[5:]``)

- ``len()`` : 문자열, 순서열 길이를 재는 함수

- ``format()`` : 객체 표기법을 사용해서 함

  ```python
  a='My name is {0}. I am {1} years old.'.format('Mario', 40)
  
  # 결과 : My name is Mario. I am 40 years old.
  ```

- ```python
  def controlStatement():
      # 1~10까지 반복문 작성
      for i in range(10):
          print(i, end="\t")
      pass
  # range를 사용하여서 범위를 설정할 수 있고 괄호 안에 (a, b) a부터 b 전 까지 
  # end="\t"구문을 이용해서 문자를 이어서 출력하는 것이 가능 자바의 print와 같음
  # 생략 시 println으로 출력
  # range를 생략하면 수정이 불가능한 리스트[], 튜플()
  	print()
      for letter in 'abcde':
          print(letter, end="\t")
          pass
      print()
      for i in range(1,11):
          if(i%2==0):
              print(i, end="\t")
              pass
          pass
  # pass를 이용하면 들여 쓰기를 끝내고 새로 쓸 수 있게 시각화 해줌
  ```

  ![파이썬반복문실행결과](md-images/untitle.png/%ED%8C%8C%EC%9D%B4%EC%8D%AC%EB%B0%98%EB%B3%B5%EB%AC%B8%EC%8B%A4%ED%96%89%EA%B2%B0%EA%B3%BC.JPG)

- 함수의 숨겨져 있는 파라메터에 주의할 것

  - ```python
    for i in range(10):
            print(i, end="\t")
        pass
    # 결과 : 0 1 2 3 4 5 6 7 8 9
    for i in range(1,11):
            print(i, end="\t")
        pass
    # 결과 : 1 2 3 4 5 6 7 8 9 10
    for i in range(1,10,2):
            print(i, end="\t")
        pass
    # 결과 : 1 3 5 7 9
    ```

- 8월 달력 만들기

  ```python
  def viewCalendar():
      # 8월 달력을 출력하는 코드 작성
      print("\t\t\t8월\t\t\t")
      print("일\t월\t화\t수\t목\t금\t토")
      for i in range(1,32):
          print(i, end="\t")
          # if i%7==0:
          if i==7 or i==14 or i==21 or i==28:
              print()
              pass
          pass
      pass
  ```

- 윤년 체크하기

  ```python
  def isLeapYear():
      flag = False # 윤년이 아님을 의미
      year = 2021
      condition1 = year%400==0
      condition2 = year%4==0 and year%100!=0
      if condition1 or condition2:
          flag = True
          pass
      print(flag)
      return flag
  ```

## 논리 연산자

- True 와 False를 사용(키워드가 대문자로 시작하는 것에 주의)

- ```python
  () # 튜플 - 리스트(Read only)
  [] # 리스트 - 배열
  {} # 딕셔너리 - JSON의 맵핑방식과 유사, 사전형, key&value
  ```

- 자바에서 사용하던 논리 연산자 기호(``||``,``&&``)를 쓰지 않고 글자 그대로 ``and``, ``or``를 사용한다

## 코드 블록과 들여쓰기

- 코드 블록
  - 여러 코드가 이루는 일정한 구역, 보통 스페이스 4칸(관례)
  - ``:`` (콜론)을 통해서 블록이 시작하며  ``pass``를 통해서 들여쓰기를 종료할 수 있음

## 분기문 - if문

- 자바의 if문과 유사 단, else if 는 elif로 쓰임

## 반복문 - for문

- ```python
  for i in range(10):
          print(i, end="\t")
      pass
  for 반복변수 in 순서열:
      코드블록
  ```

- range(시작값, 최종값, 증가값)

- 딕셔너리의 요소 순회

  ```python
  dic={'애플':'www.apple,com','파이썬':'www.python.org'}
  for k,v in dic.items():
      print("{0}:{1}".format(k,v))
      pass
  # 결과
  애플 : www.apple.com
  파이썬 : www.python.org
  ```

  

- continue : 코드블록의 나머지 부분을 실행하지 않고 다음 반복으로 건너가도록 흐름 조정

- break : 루프를 중단시키는 기능

## Random

```python
import random
def makeRandomNumber():
    # rnd = random.random() # 0은 포함하고 1은 포함하지 않는 double값이 나옴
    for _ in range(10):
        # 단순 반복을 위해서 사용하기 때문에 반복변수는 _ 를 사용
        rnd2 = random.randrange(1,3) # 1과 2에서 랜덤으로 출력
        rnd3 = random.randint(1,3) # 1과 3 사이에서 랜덤으로 출력
        print(rnd2)
    pass
```

- 



# Q&A

1. 숫자에서 문자로의 변환 등이 이루어지는 이유
   - 모든 정보는 해당되는 타입으로 표시되려면 부담이 커서 문자로 일괄적으로 저장 후에 사용할 때 해당 타입으로 변환해서 사용
2. 자바에서 List와 ArrayList의 차이
   - 이빠짐을 해결할 수 있는가 없는가
3. 파이썬의 표기법
   - 함수 표기법
   - 객체 표기법 (AI, BigData)
4.  파이썬 2는 스크립트에 치중되어 있었음 파이썬 3이 되고 나서 객체와 AI관련해서 다룰 수 있는 것에 중점이 됨
5. 모든 언어에서는 기본적으로 String으로 받아들이게 됨
6. 어드밴스 for문 배열을 가져와서 배열의 크기에 따라 그 크기 만큼 반복을 돌려주는 것
7. CRUD 중요하고, 사이즈 (몇 개를 모았는지) 말고도 중요하다고 했는데 무엇인가?
   - 자료 구조에서 자료를 모을 때 처음인가? 끝인가?를 결정하는 것이 중요
   - 해당 되는 컬렉션이 비어있는가? 채워져 있는가?
8. 표기에 중점을 두고 공부할 것(자바를 기본으로 python의 특징을 구분할 것)

# Error

- 파이썬은 오버로드가 적용되지 않음 함수의 이름은 가능하면 다르게





