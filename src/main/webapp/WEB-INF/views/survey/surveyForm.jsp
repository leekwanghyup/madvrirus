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
<h2>설문조사</h2>

<form method="post">

<c:forEach var="q" items="${questions}" varStatus="status">
	${status.index + 1}. ${q.title}<br>
	<c:if test="${q.choice}">
		<c:forEach var="option" items="${q.options}">
			<label>
				<input type="radio" name="responses[${status.index}]" value="${option}">
				${option}<br>
			</label>
		</c:forEach>
	</c:if>
	<c:if test="${not q.choice}">
		<input type="text" name="responses[${status.index}]">
	</c:if>
</c:forEach>

<div>
	<label>응답자 위치 : 
		<input type="text" name="res.location">
	</label>
		
</div>
<div>
	<label>응답자 나이 : 
		<input type="text" name="res.age">
	</label>
</div>
<input type="submit" value="전송">
</form>
</body>
</html>