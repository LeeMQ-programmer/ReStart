<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<body>
	<%@include file="/WEB-INF/Header.jsp"%>
	<table>
		<tr><th>제목</th><td>${dto.gi_title}</td></tr>
		<tr><th>내용</th><td>${dto.gi_content}</td></tr>
		<tr><th>날짜</th><td>${dto.gi_regdate}</td></tr>
		<tr><th>조회수</th><td></td></tr>
	</table>
</body>
</html>