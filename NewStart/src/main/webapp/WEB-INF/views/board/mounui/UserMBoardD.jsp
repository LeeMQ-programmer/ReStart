<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<script type="text/javascript">

onload = function(){
	 var option = document.getElementsByName('category_seq')[0].children;
	//alert('${dto.category_seq}');
	 for (var i = 0; i < option.length; i++) {
		if(option[i].value == '${dto.category_seq}'){
			option[i].selected = true;
		} 
	}
}
	 
</script>
<body>
<div class="container">
  <form action="./insertBoard.do" method="post">
    <input type="hidden" class="form-control" name="mounui_seq" id="modi" value="${dto.mounui_seq}">
  <div class="form-group">
      <label for="usr">카테고리 :</label>
      <input type="text" class="form-control" name="title" id="usr" value="${dto.category_title}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="usr">제목 :</label>
      <input type="text" class="form-control" name="title" id="usr" value="${dto.title}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="comment">내용:</label>
      <textarea class="form-control" rows="5" id="comment" name="content" readonly="readonly">${dto.content}</textarea>
    </div>
    <div class="form-group">
      <label for="usr">등록일 :</label>
      <input type="text" class="form-control" name="regdate" id="usr" value="${dto.regdate}" readonly="readonly">
    </div>
      <input type="hidden" class="form-control" name="filechk" value="N">
  </form>
      <button type="button" class='btn'  onclick="location.href='./UserMBoard.do'">목록</button>
      <button type="button" class='btn' id="del">삭제</button>
</div>

</body>
</html>