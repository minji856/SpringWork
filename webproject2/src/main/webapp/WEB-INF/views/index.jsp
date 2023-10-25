<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
	<h2>Hello World!</h2>
	
	<ul>
		<li><a href="/first">first.jsp를 보여주세요.</a></li>
		
		<!---- 삭제된 코드 <li><a href="/webproject2/second">second.jsp를 보여주세요.</a></li> ---->
			<!-- 데이터를 같이 넘기는 -->
		<li><a href="/second?p1=apple&p2=grape">second.jsp를 보여주세요.</a></li>
	</ul>
	<br><br>
	<form method="post" action="/third">
		<input type="text" name="name"/><br>
		<input type="text" name="age"/><br>
		<input type="text" name="point"/><br>
		<input type="submit" value="전송"/><br>
	</form>
	
	<br><br>	<!-- ModelAndView 이용 -->
	<form method="get" action="/fourth">
		<input type="text" name="name" /><br>
		<input type="text" name="age" /><br>
		<input type="text" name="point"/><br>
				<!-- dto로 묶여지지 않는 값 처리 -->
		<input type="checkbox" name="chk" value="check"/>동의 여부<br>
		<input type="submit" value="전송" /><br>
	</form>
	
	<br><br>
	<a href="/fifth">다섯번째 요청</a>
</body>
</html>
