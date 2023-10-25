<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>JSTL</title>
</head>
<body>
	<%---- <c:out value="Hi!">Hello!</c:out> ----%>
	좋아하는 음식<br>
	<c:forEach var="i" items="${tang}">
		${i}<br>
	</c:forEach>
	
	<br><br>
	좋아하는 과일 : ${f1}, ${f2}, ${f3}

	<br><br> <!-- 반복문도 사용가능 -->
	좋아하는 요일: ${day[0]}, ${day[1]}, ${day[2]}, ${day[3]}
	
</body>
</html>