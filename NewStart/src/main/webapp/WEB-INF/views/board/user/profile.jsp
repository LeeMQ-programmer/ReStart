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

<!-- user_seq		 -->
<!-- pro_school	 -->
<!-- pro_major	 -->
<!-- pro_tech		 -->
<!-- pro_info		 -->
<!-- pro_star		 -->
<!-- career_company	 -->
<!-- career_dept		 -->
<!-- career_job		 -->
<!-- career_term		 -->
<div class="container">
${newstart }<br>
${profileDto }
  <h2>경력 보기</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myCareer">경력 보기</button>

  <!-- Modal -->
  <div class="modal fade" id="myCareer" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
</body>
</html>