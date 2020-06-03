<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공 페이지</title>
</head>
<body>
로그인 성공!
${dto}
<form action="./logout.do" method="post">
<input type="submit" value="로그아웃">
</form>
</body>
</html>