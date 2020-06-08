<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/boardTopMenu.jsp"%>

	<form action="./insertReview.do" method="get" >
		<input type="hidden" id="user_seq" name="user_seq" value="${dto.user_seq}">
		re_title : <input type="text" name="re_title"><br>
		re_content : <input type="text"  name="re_content"><br>
		re_teacher : <input type="text"  name="re_teacher"><br>
		re_star : <input type="text"  name="re_star"><br>
		
		<input type="submit" value="새글 쓰기">
		<input type="reset" value="다시쓰기">
	</form>

</body>
</html>