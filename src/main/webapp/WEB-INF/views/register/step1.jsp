<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1><spring:message code="member.register" /></h1>
<p><spring:message code="member.name" arguments="${name}, ${age}" /></p>
<h2>약관</h2>
<form action="step2" method="post">
	<label>
		<input type="checkbox" name="agree" value="true">약관동의
	</label>
	<input type="submit" value="다음단계"/>
</form>
</body>
</html>