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
<h2>비밀번호 변경</h2>
<form:form modelAttribute="command">
	<label>현재 비밀번호 : 
		<form:password path="currentPassword"/>
		<form:errors path="currentPassword"/>
	</label>
	<label>
		새로운 비밀번호 : 
		<form:password path="newPassword"/>
		<form:errors path="newPassword"/>
	</label>
	<button>변경</button>
</form:form>
</body>
</html>