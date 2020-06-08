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
<h1>aaa</h1>${newstart }
	<h1>review Mian</h1>
	<form action="./writeReview.do" method="get" id="frm">
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>글번호</th>
						<th>유저 번호</th>
						<th>제목</th>
						<th>해당 강사</th>
						<th>별점</th>
						<th>작성일</th>
						<th>RE_GROUP</th>
						<th>RE_REPLY</th>
						<th>RE_DELETE</th>
						
<%-- 						<c:if test="${newstart eq 'A' }"> --%>
<!-- 							<th>삭제여부</th> -->
<%--RE_GROUP, RE_REPLY, RE_DELETE, 						</c:if> --%>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${lists}" varStatus="vs">
						<tr>
							<td>${list.re_seq }&nbsp;&nbsp;</td>
							<td>${list.user_seq }&nbsp;&nbsp;</td>
							<td><a href="./reviewDetail.do?re_seq=${list.re_seq}">${list.re_title }&nbsp;&nbsp;</a></td>
							<td>${list.re_teacher }&nbsp;&nbsp;</td>
							<td>${list.re_star }&nbsp;&nbsp;</td>
							<td>${list.re_regdate }&nbsp;&nbsp;</td>
<%-- 							<c:if test="${newstart eq 'A' }"> --%>
<%-- 								<td>${list.re_delete })</td> --%>
<%-- 							</c:if> --%>
							<td>${list.re_group }</td>
							<td>${list.re_reply }</td>
							<td>${list.re_delete }</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					
				</tfoot>
			</table>
		</div>
		<input type="submit" value="새글 쓰기">
	</form>
</body>
</html>























