<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./singUpSc.do" method="post">
아이디 : <input type="text" name="user_email">
닉네임 : <input type="text" name="user_nickname">
이름 : <input type="text" name="user_name">
비밀번호 :<input type="text" name="user_pw">
핸드폰 번호 : <input type="text" name="user_phone">
광고알림 : <input type="text" name="user_phone" value="Y">

<input type="submit" value="회원가입">
</form>
</body>
</html>