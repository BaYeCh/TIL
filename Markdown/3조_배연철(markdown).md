# Git/Git Hub 특강

## Markdown

- 문서작성을 위한 언어
- Notion, 에버노트, word, one note등이 있음
  - 마크업 언어 : html

### 마크다운 문법

#### Fenced Code Block

- backtick 기호 3개를 활용하여 작성(```)

- 특정 언어 명시 시 Syntax Highlighting 적용 가능

  ```java
  // 자바에서 주석
  int a = 10; //highlighting
  ```

#### Inline Code block

- backtick(`) 1개를 이용하여 작성
- `*`

#### Link

- ```[문자열](url)```의 형태로 링크를 작성
- 대괄호와 소괄호 사이에 띄어쓰기는 불가

#### 이미지

- Link에 `!`를 앞에 붙여주면 사용 가능
- 그 외에도 drag and drop 방식으로 사용 가능

#### blockquotes(인용문)

- `>`를 통해서 인용문을 작성

#### Table(표)

- ```|이름 | 비고|```로 제작

- | 이름 | 비고 |
  | ---- | ---- |
  |      |      |

  Typora Tip) ctrl + t로 생성 가능

  | 이름 | 비고 |
  | ---- | ---- |
  |      |      |

#### text 강조

- ```** **```는 굵게 : **굵게**
- ```*** ***```는 이탤릭 : ***test***

#### 수평선

- 3개 이상의 *, -, _

  - `*`

    ***

  - ```-```

  ---

  - ```_```

  ___

#### 미세 Typora tip

- ctrl + shift +[ , ] 를 통해 목록을 만들 수 있다.
- ctrl + [ , ]를 통해 상위 하위 목록으로 변경이 가능하다.
- 마우스 우클릭 시 확인 가능.

### 마크다운 관련 자료

[GitHub Flavored Markdown](https://github.github.com/gfm/)

[Mastering Markdown](https://guides.github.com/features/mastering-markdown/)

[Markdown Guide](https://www.markdownguide.org/ )

## 버전관리

- 일반적으로 파일을 복제하는 형태로 버전관리를 행해왔다.
- 복제만으로는 감당하기 어려운 데이터 양

### 크로미움(크롬 브랑우저의 오픈소스)

- 최신 버전의 용량 1.58GB
- 총 용량이 50GB

### CLI(Command Line Interface)

- 윈도우 이전에는 기본 명령어 인터페이스
- 인터페이스를 제공하는 프로그램을 명령 줄 해석기 또는 셸이라고 한다.
- 인터페이스가 바뀌는 것은 자신의 사고 방식과 행동 방식이 바뀌는 것과 같다.

#### 주의

1. 명령을 하는 곳이 내가 원하는 곳이 맞는지 확인.
2. 명령 수행이 제대로 되고 있는지 확인.

#### CLI 명령어

- pwd(print working directory) 현재 저장되는 위치
- git.pdf확인

### Git

#### 목적

- 분산 버전 관리 시스템으로 코드의 버전을 관리하는 도구
- 여러 명의 사용자들 간에 해당 파일들의 작업을 조율

#### 분산버전관리시스템

- 버전 자체를 공유
  1. 보안성 문제?
  2. 책임성 문제?

- 흐름
  1. 작업한 파일 (Working directory)  -변경 사항
  2. INDEX(staging area) <-add
  3. 버전 (HEAD)<-commit
- 데이터를 파일 시스템의 스냅샷으로 관리하고 매우 크기가 작음
- 파일이 달라지지 않으면 새로 저장하지 않음

##### 기본 명령어 

###### $ git init

- 저장소
- CLI에서 현재 디렉토리가 맞는지 확인할 것

###### $ git add <file>

- 변경 내용 추가

###### $ git commit -m'<커밋메시지>'

- 커밋을 통해 완전한 버전으로 기록이 됨
- 고유한 커밋을 hash값으로 표기

- 명확하게 작성해야 함(띄어쓰기를 잘해야 함)

###### $ git status

- Git 저장소에 있는 파일의 상태를 확인
- 변경사항과 변경목록을 확인(1번째 통과 2번째 통만)

###### $ git log

- 기록된 버전을 조회
  - -1 : 가장 최신의 것을 보여줌
  - -1 --oneline
  - --oneline

###### $ git clone 주소

- 원격저장소를 가져올 때 (복제)

- 내가 명령한 경로에 원격저장소 이름의 폴더가 만들어짐

###### 원격저장소 push

- ```bash
  $ git push origin master
  ```

  커밋만이 push 됨(파일, 폴더 X)

- push 전에 status로 원하는 변경사항들이 모두 커밋되었는지 확인

###### 원격저장소 -> 로컬저장소

- `pull` :커밋들만 가지고온다.

- `clone `:원격저장소 자체를 가져온다.

- `압축파일` .git 파일 X -> 새롭게 `init`하면 새로운 로컬저장소가 됨.

