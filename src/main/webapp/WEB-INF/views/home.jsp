<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	Hello? 
	<c:if test="${not empty authInfo }">
		${authInfo.name}님 환영합니다.<br>
		<a href="${pageContext.request.contextPath}/logout">[로그아웃]</a>
	</c:if>
	
</body>
</html>