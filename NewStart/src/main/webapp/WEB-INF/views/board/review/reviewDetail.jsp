<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function delClick(re_seq){
		location.href = "./reviewDelete.do?re_seq="+re_seq;
	}
	//답글 달기
	function insertClick(re_seq){
		location.href = "./moveReply.do?re_seq="+re_seq;
	}
	//수정하기
	function modifyClick(re_seq){
		location.href = "./moveModify.do?re_seq="+re_seq;
	}
	
</script>
<body>
	<%@ include file="/WEB-INF/views/boardTopMenu.jsp"%>
${newstart }<br><br>

<div class="container">
	글번호 :${dto.re_seq}<br>
   제목 ; ${dto.re_title }<br>
   내용 : ${dto.re_content }<br>
   작성일 : ${dto.re_regdate }<br>
   별점 : ${dto.re_star }<br>
   강사 : ${dto.re_teacher }<br>
   
   
   	<input type="button" value="글 수정하기" onclick="modifyClick(${dto.re_seq})">
   	<input type="button" value="글 삭제하기" onclick="delClick(${dto.re_seq})">
   	<input type="button" value="답글 달기" onclick="insertClick(${dto.re_seq})">
   	
   	
</div>
</body>
</html>