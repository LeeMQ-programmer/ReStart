<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WriteForm</h1>

<div class="container">
  <h2>Form control: input</h2>
  <p>The form below contains two input elements; one of type text and one of type password:</p>
  <form action="./">
    <div class="form-group">
      <label for="pro_school">대학교 :</label>
      <input type="text" class="form-control" id="pro_school">
    </div>
    <div class="form-group">
      <label for="pro_major">전공 :</label>
      <input type="password" class="form-control" id="pro_major">
    </div>
    <div class="form-group">
      <label for="pro_tech">보유 기술 :</label>
      <input type="password" class="form-control" id="pro_tech">
    </div>
    <div class="form-group">
      <label for="pro_info">자기 소개 :</label>
      <input type="password" class="form-control" id="pro_info">
    </div>
    <div class="form-group">
      <label for="pro_star">별점 :</label>
      <input type="password" class="form-control" id="pro_star">
    </div>
    <input type="submit" value="다음으로 가기">
  </form>
</div>
</body>
</html>