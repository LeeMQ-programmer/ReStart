<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/sweetalert.min.js">
	
</script>
${newstart }
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">NewStart</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Main</a></li>
			<li><a href="#">공고 게시판</a></li>
			<li><a href="#">공지 게시판</a></li>
			<li><a href="./reviewMain.do">후기게시판</a></li>
			<li><a href="#">문의게시판</a></li>
			<li><a href="#">FAQ게시판</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
		<c:if test="${newstart eq null }">
			<!-- 로그아웃 상태면 SignUp -->
			<li>
				<a href="./singUpform.do">
					<span class="glyphicon glyphicon-user"></span>Sign Up
				</a>
			</li>
			<!-- 로그아웃 상태면 LogIn -->
			<li>
				<a href="./loginForm.do">
					<span class="glyphicon glyphicon-log-in"></span>Login
				</a>
			</li>
		</c:if>
		<c:if test="${newstart ne null  }">
			<!-- 로그인 상태면 MyPage -->
			 <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">마이 페이지 <span class="caret"></span></a>
        		<ul class="dropdown-menu">
        			<li><a href="./myPage.do">마이 페이지</a></li>
					<li><a href="./proFile.do">프로필</a></li>
          			<li><a href="./logout.do" style="color:red;">로그아웃</a></li>
        		</ul>
      		</li>

			<!-- 로그인 상태면 Logout -->
			<li>
				<a href="#">
					<span class="glyphicon glyphicon-log-out"></span> Login
				</a>
			</li>
			</c:if>
		</ul>
	</div>
</nav>

