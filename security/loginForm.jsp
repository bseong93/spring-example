<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Board Example</title>
	<link href="${pageContext.request.contextPath}/css/login/login.css" rel="stylesheet">
</head>
<body>

	<div class="main">
		<div class="login-box">
			<form action="j_spring_security_check" method="post">
				<input type="text" name="userId" placeholder="아이디">
				<input type="password" name="userPw" placeholder="패스워드">
				<input type="submit" value="로그인">
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>
		
		<c:if test="${ error ne null }">
			<p class="error-msg">${ error }</p>
		</c:if>
		
	</div>
	
	<script src="${pageContext.request.contextPath}/js/login/login.js" type="text/javascript"></script>

</body>
</html>
