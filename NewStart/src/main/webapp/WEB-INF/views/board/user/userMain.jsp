<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function moveDetail(user_seq){
		location.href="./moveDetail.do?user_seq="+user_seq;
	}
</script>
<body>
	<%@ include file="/WEB-INF/views/boardTopMenu.jsp"%>
	<h1>관리자만 사용 가능</h1>
	<form action="#" method="get" id="frm">
		<div>
			<table class="table">
				<thead>
					<tr>
						<th><input type="checkbox" onclick="checkAll(this.checked)"></th>
						<th>유저 번호</th>
						<th>이메일</th>
						<th>이름</th>
						<th>닉네임</th>
						<th>등급</th>
						<th>타입</th>
						<th>이메일 수신 여부</th>
						<th>강사 인증 여부</th>
						<th>가입일</th>
						<th>상세보기</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lists }" var="list" varStatus="vs">
						<tr>
							<td><input type="checkbox" name="seq" value="${list.user_seq}"> </td>
							<td>${list.user_seq }</td>
							<td>${list.user_email }</td>
							<td>${list.user_name }</td>
							<td>${list.user_nickname }</td>
							<td>${list.user_grade }</td>
							<td>${list.user_type }</td>
							<td>${list.user_adchk }</td>
							<td>${list.user_tchk }</td>
							<td>${list.user_regdate }</td>
							<td><button onclick="moveDetail(${list.user_seq})">상세보기</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<input type="button" value="문자보내기" onclick="">
			<input type="button" onclick="">
			<input type="button" onclick="">
		</div>
	</form>
</body>
</html>