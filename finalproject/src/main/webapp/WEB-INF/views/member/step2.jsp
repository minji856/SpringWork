<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 입력</h2>
	<form action="<c:url value='/member/step3'/>" method="post">
		<p>
			<label>이메일:<br> <input type="text" name="email"
				id="email" />
			</label>
		</p>
		<p>
			<label>이름:<br> <input type="text" name="name" id="name" />
			</label>
		</p>
		<p>
			<label>패스워드:<br> <input type="password" name="password"
				id="password" />
			</label>
		</p>
		<p>
			<label>패스워드 확인:<br> <input type="password"
				name="confirmPassword" id="confirmPassword" />
			</label>
		</p>
		<input type="submit" value="가입 완료" />
	</form>
</body>
</html>