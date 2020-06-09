<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${newstart.user_name}님의 마이페이지</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/boardTopMenu.jsp"%>
<h1>${newstart.user_name}님의mypage</h1>
${newstart }
<div class="container">
  <form action="#" method="post">
    <div class="form-group">
      <label for="usr">이름 :</label>
      <input type="text" class="form-control" id="usr" value="${newstart.user_name }">
    </div>
    <div class="form-group">
      <label for="user_nickname">닉네임 :</label>
      <input type="password" class="form-control" id="user_nickname" value="${newstart.user_nickname }">
    </div>
    <div class="form-group">
      <label for="user_phone">전화번호 :</label>
      <input type="text" class="form-control" id="user_phone" value="${newstart.user_phone }">
    </div>
    <div class="form-group">
      <label for="user_adchk">광고성 수신 여부 :</label>
      <input type="checkbox" class="form-control" id="user_adchk" value="${newstart.user_adchk }">
    </div>
    <div class="form-group">
      <label for="user_tchk">강사 인증 :</label>
      <input type="button" class="form-control" id="user_tchk" value="${newstart.user_tchk }">
    </div>
    
    <input type="text">
  </form>
</div>
</body>
</html>