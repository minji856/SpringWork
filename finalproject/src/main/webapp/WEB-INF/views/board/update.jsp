<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>글 수정 페이지</title>
</head>
<body>
	<h1>글 읽기</h1>
	제목 : <input type="text" name="bTitle" value="${board.bTitle}" readonly="readonly">
	글쓴이 : <input type="text" name="bWriter" value="${board.bWriter}" readonly="readonly">
	내용 : <textarea rows="5" cols="50" name="bContent">${board.bContent}</textarea><br><br>
	<a href="<c:url value='/board/update?bNo=${board.bNo}'/>">수정하기</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<c:url value='/board/delete?bNo=${board.bNo}'/>">삭제하기</a>
</body>
</html>