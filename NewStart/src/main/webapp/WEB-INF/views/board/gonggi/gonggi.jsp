<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 게시판</title>
<link type="text/css" rel="stylesheet" href="./../../css/gonggi.css">
</head>
<body>
	<%@include file="/WEB-INF/Header.jsp"%>
	<table>
		<thead>
			<tr>
				<th>NO</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${lists}" varStatus="vs">
				<tr>
					<td>${fn:length(lists) - vs.index}</td>
					<td>
						<a href="./gonggiOneSel.do?seq=${dto.gi_seq}&category=${dto.gi_category}">
							${dto.gi_title}
						</a>
					</td>
					<td>${dto.gi_regdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<input class="btn btn-success" type="button" value="세글작성" onclick="writeForm()">
	</div>
	
	<script type="text/javascript">
		function writeForm(){
			location.href="./writeForm.do";
		}
	</script>
</body>
</html>