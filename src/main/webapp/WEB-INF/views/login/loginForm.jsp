<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인하기</h2>
<form:form modelAttribute="loginCommand">
	<form:errors/>
	<div>
		<label>
			이메일 : <form:input path="email"/>
			<form:errors path="email"/>
		</label><br>
		<label>
			비밀번호 : <form:password path="password"/>
			<form:errors path="password"/>
		</label>
	</div>
	<input type="submit" value="로그인">
</form:form>
</body>
</html>