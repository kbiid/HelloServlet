<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Manager Login</title>
<style>
body {
	margin: 0;
	padding: 0;
}

#webView {
	overflow: hidden;
	position: relative;
	background:;
	width: 978px;
	height: 600px;
	margin: 0 auto;
	-webkit-transform: translate3d(0, 0, 0);
	transform: translate3d(0, 0, 0)
}

#webView[data-show-memo='true'] {
	overflow: visible
}
</style>
</head>
<body>
	<div>
		<div
			style="position: absolute; top: 29px; left: 800px; width: 300px; height: 58px;">
			<div
				style="font-weight: bold; font-size: 41px; text-align: center; color: rgb(211, 0, 194);"
				class="">Torpedo</div>
		</div>

		<form name="loginForm" method="post" action="/servlet/login">
			<div
				style="position: absolute; top: 157px; left: 740px; width: 120px; height: 40px;">
				<div style="font-size: 20px; text-align: right;">아이디:</div>
			</div>
			<div
				style="position: absolute; top: 157px; left: 871px; width: 300px; height: 40px;">
				<input type="text" data-min-width="60" data-min-height="30"
					name="id" data-text-content="true" placeholder="아이디"
					style="color: rgb(94, 94, 94);">
			</div>
			<div style="position: absolute; top: 243px; left: 740px; width: 120px; height: 40px;">
				<div style="font-size: 20px; text-align: right; line-height: 1.5em;">비밀번호:</div>
			</div>
			<div
				style="position: absolute; top: 243px; left: 871px; width: 300px; height: 40px;">
				<input type="password" data-min-width="60" data-min-height="30"
					name="passwd" data-text-content="true" placeholder="비밀번호"
					style="color: rgb(94, 94, 94);" spellcheck="false" class="">
			</div>
			<input type="submit" value="로그인" id="btnLogin"
				style="font-size: 16px; color: rgb(255, 255, 255); text-align: center; line-height: 2.5em; border-top-left-radius: 4px; border-top-right-radius: 4px; border-bottom-right-radius: 4px; border-bottom-left-radius: 4px; background-color: rgb(52, 152, 219);; position: absolute; top: 350px; left: 901px; width: 100px; height: 40px;">
		</form>
	</div>
</body>
<script type="text/javascript">
	
<%if (request.getAttribute("errormsg") != null) {
	String msg = request.getAttribute("errormsg").toString();
	if (!msg.equals("")) {%>
		alert('<%= msg%>');
	<%}
}%>
</script>
</html>