<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="common.css" rel="stylesheet">
</head>
<body>
	<h1>Welcome to my home~~</h1>
	${message}
	<br>
	<br>
	<c:out value="jstl테스트 입니다.">이것은 대체문자입니다.</c:out>
</body>
</html>