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



function modify(){
	var title = document.getElementsByName('title')[0];
	var category = document.getElementsByName('category_seq')[0];
	var content = document.getElementsByName('content')[0];
	var btn = document.getElementById('modify');
	var btn2 = document.getElementById('del');
	
	title.readOnly = false;
	category.disabled = false;
	content.readOnly = false;
	btn.innerHTML = "취소";
	btn.setAttribute("onclick","cancel()");
	btn2.style.display = 'none';
	
}

function cancel(){
	if(confirm('작성하던 내용이 모두 사라집니다. 그래도 취소하시겠습니까?')){
		location.href='./UserMBoardDetail.do?seq='+${dto.mounui_seq};
	}
}
	 
//location.href='./UserMBoard.do'
function goback(){
	var btn = document.getElementsByClassName("btn")[1];
	if(btn.innerHTML == '취소'){
		if(!confirm('작성하던 내용이 모두 사라집니다. 그래도 취소하시겠습니까?')){
			return;
		}
	}
			location.href='./UserMBoard.do';
}
</script>
<body>
<div class="container">
  <form action="./insertBoard.do" method="post">
    <input type="hidden" class="form-control" name="mounui_seq" id="modi" value="${dto.mounui_seq}">
    <div class="form-group">
     <label for="sel1">카테고리 :</label>
      <select class="form-control" name="category_seq" id="sel1" disabled="disabled">
        <c:forEach items="${Fdto}" var="fdto">
	        <option value="${fdto.category_seq}">${fdto.category_title}</option>
        </c:forEach>
      </select>
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
      <button type="button" class='btn'  onclick="goback()">목록</button>
      <button type="button" class='btn' id="modify" onclick="modify()">수정</button>
      <button type="button" class='btn' id="del">삭제</button>
</div>

</body>
</html>