<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<h2>회원정보입력</h2>
	<form:form action="step3" modelAttribute="registerRequest">
	<div>
		<label>이메일</label><br>
		<form:input type="text" path="email"/>
		<form:errors path="email"/>
	</div>
	<div>
		<label>이름</label><br>
		<form:input type="text" path="name"/>
		<form:errors path="name" class="error_message"/>
	</div>
	<div>
		<label>비밀번호</label><br>
		<form:password path="password"/>
	</div>
	<div>
		<label>비밀번호확인</label><br>
		<form:password path="confirmPassword"/>
	</div>
	<input type="submit" value="회원가입"/>
	</form:form>
</body>
<style>
.error_message {
	font-size: 11px; 
	color:red;	
}
</style>
</html>