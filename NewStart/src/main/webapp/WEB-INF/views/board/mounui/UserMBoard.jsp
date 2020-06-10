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
<body>


<div class="container">
  <h2>Basic Table</h2>
  <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>            
  <table class="table">
    <thead>
      <tr>
        <th>#</th>
        <th>카테고리</th>
        <th>제목</th>
        <th>내용</th>
        <th>등록일</th>
        <th>답변 처리 여부</th>
      </tr>
    </thead>
    <tbody>
		<c:forEach items="${dtos}" var="dto" varStatus="idx">
		      <tr>
       			 <td>${fn:length(dtos)-idx.index}</td>
       			 <td>${dto.category_title}</td>
        		 <td><a href="./UserMBoardDetail.do?seq=${dto.mounui_seq}">${dto.title}</a></td>
        		 <td>${dto.content}</td>
        		 <td>${dto.regdate}</td>
        		 <td>
        		 	<c:choose>
						<c:when test="${dto.replychk eq 'N'}">답변 처리 중</c:when>
						<c:when test="${dto.replychk eq 'Y'}">답변 완료</c:when>
					</c:choose>
        		 </td>
      		</tr>
		</c:forEach>
    </tbody>
  </table>
</div>



</body>
</html>