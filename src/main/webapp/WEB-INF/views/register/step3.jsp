<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<strong>${registerRequest.name}</strong>
		회원가입을 완료했습니다.
	</p>
	<a href="${pageContext.request.contextPath}">[첫화면으로 이동]</a>
</body>
</html>