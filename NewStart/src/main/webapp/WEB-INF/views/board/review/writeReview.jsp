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
${newstart }
	<form action="./insertReview.do" method="post" >
		<input type="hidden" id="user_seq" name="user_seq" value="${newstart.user_seq}">
		
		re_star : <input type="text"  name="re_star"><br>
		re_teacher : <input type="text"  name="re_teacher"><br>
		${teacher }<br>
		re_title : <input type="text" name="re_title"><br>
		re_content : <textarea rows="5" cols="50" name="re_content"></textarea><br>
		
		<input type="submit" value="새글 쓰기">
		<input type="reset" value="다시쓰기">
	</form>

</body>
</html>