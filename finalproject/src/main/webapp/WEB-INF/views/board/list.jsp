<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
</head>
<body>
	<h1>게시판 리스트</h1>
	<a href="<c:url value='/board/write'/>">글쓰기</a>
	<br><br>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>등록자</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
	</table>
</body>
</html>