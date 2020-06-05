<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
${msg}
${error}
<form action="./logingo.do" method="post">

아이디 : 
<input type="text" name="username" value="${id}">
비밀번호
<input type="text" name="password">
<input id="remember_me" name ="remember_me" type = "checkbox"/>Remember me
<input type="submit" value="제출">
</form>

<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
    <font color="red">
        Your login attempt was not successful due to <br/>
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
        <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
    </font>
</c:if>

<a href="./singUpform.do">회원가입</a>
</body>
</html>