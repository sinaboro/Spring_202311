<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cusotm Login Page</h1>
	<h2>error >> ${error}</h2>
	<h2>logout >> ${logout}</h2>
	
	<form method="post" action="/login">
		<div>
			<input type="text" name="username" value="admin">
		</div>
		<div>
			<input type="password" name="password" value="admin">
		</div>
		<div>
			<input type="submit" value="로그인">
		</div>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  />
		
	</form>
</body>
</html>