<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="resources/css/join.css">
    <script src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="resources/js/ajax.js"></script>
</head>
<body>
    <section class="join-form">
        <h1>회원가입</h1>
        <form action="">
            <div class="int-area">
                <input type="text" name="id" id="id" autocomplete="off" required>
                <label for="id">USER NAME</label>
            </div>
            <div class="int-area">
                <input type="password" name="pwd" id="pwd" autocomplete="off" required>
                <label for="pwd">PASSWORD</label>
            </div>
            <div class="int-area">
                <input type="password" name="checkpw" id="checkpw"  onchange="checkPW()" autocomplete="off" required>
                <label for="checkpw">Check PASSWORD</label>
            </div>
            <span id="message" class="message"></span>
            <div class="int-area">
                <input type="text" name="name" id="name" autocomplete="off" required>
                <label for="name">이름</label>
            </div>
            <div class="int-area">
                <input type="text" name="sub_name" id="sub_name" autocomplete="off" required>
                <label for="name">닉네임</label>
            </div>
            <div class="int-area">
                <input type="text" name="birth" id="birth" autocomplete="off" required placeholder="8자리 ex) 19910102">
                <label for="birth">생년월일</label>    
            </div>
            <div class="int-area">
                <input type="text" name="num" id="num" autocomplete="off" required placeholder="숫자만 입력">
                <label for="num">휴대폰 번호</label>
            </div>
            <div class="int-area">
                <input type="email" name="email" id="email" autocomplete="off" required>
                <label for="email">이메일</label>
            </div>
            <div class="int-area">
                <input type="text" name="si" id="si" autocomplete="off" required>
                <label for="si">시</label>
            </div>
            <div class="int-area">
                <input type="text" name="doe" id="doe" autocomplete="off" required>
                <label for="doe">도</label>
            </div>
            <div class="int-area">
                <input type="text" name="gu" id="gu" autocomplete="off" required>
                <label for="gu">구</label>
            </div>
            <div class="int-area">
                <input type="text" name="detail_address" id="detail_address" autocomplete="off" required placeholder="상세주소">
                <label for="detail_address">상세주소</label>
            </div>
            <div class="btn-area">
                <button id="member_add" type="submit">회원가입</button>
            </div>
        </form>
    </section>

    <script>
        function checkPW() {
            var a = document.getElementById("pwd").value;
            var b = document.getElementById("checkpw").value;

            if(a!=b) {
                document.getElementById("message").innerHTML="비밀번호가 일치하지 않습니다.";
                document.getElementById("message").style.color='red';
            } else {
                document.getElementById("message").innerHTML="비밀번호가 일치합니다."
                document.getElementById("message").style.color='blue';
            }
        }
    </script>
</body>
</html>