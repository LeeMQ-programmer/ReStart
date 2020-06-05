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
	<h1>review Mian</h1>
	<form action="#" method="post" id="frm">
		<div>
			<table>
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>해당 강사</th>
						<th>별점</th>
						<th>작성일</th>
						<c:if test="${newstart eq 'A' }">
							<th>삭제여부</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${lists}" varStatus="vs">
						<tr>
							<th>${list.re_seq }&nbsp;&nbsp;</th>
							<th>${list.user_seq }&nbsp;&nbsp;</th>
							<th>${list.re_title }&nbsp;&nbsp;</th>
							<th>${list.re_teacher }&nbsp;&nbsp;</th>
							<th>${list.re_regdate }&nbsp;&nbsp;</th>
							<th>${list.re_star }&nbsp;&nbsp;</th>
							<c:if test="${newstart eq 'A' }">
								<th>${list.re_delete })</th>
							</c:if>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>