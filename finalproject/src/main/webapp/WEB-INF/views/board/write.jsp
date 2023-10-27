<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>글쓰기페이지</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form method="post" action="<c:url value='/board/write'/>">
		제목 : <input type="text" name="bTitle"/><br><br>
		글쓴이 : <input type="text" name="bWriter"/><br><br>
		내용 : <textarea rows="5" cols="50" name="bContent"></textarea><br><br>
		<input type="submit" value="글쓰기" />
	</form>
</body>
</html>