<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.torpedo.helloservlet.domain.User"%>
<jsp:useBean id="repository"
	class="kr.co.torpedo.helloservlet.repository.hibernate.HibernateRepository" />
<!DOCTYPE html>
<html>
<head>
<title>사용자 목록</title>
<script>
	screenWidth = 978;
	projectId = "Dn8aEQNuBakD9AyR9WsZKvPKNJ8Ve7Fe";
	sequenceId = "kb4vb";
</script>
<style>
body {
	margin: 0;
	padding: 0;
}

#webView {
	overflow: hidden;
	position: relative;
	background: #FFFFFF;
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
<body data-locale="ko">
	<div>
		<div
			style="position: absolute; top: 0px; left: 0px; width: 300px; height: 58px;">
			<div
				style="font-weight: bold; font-size: 41px; text-align: center; color: rgb(211, 0, 194);"
				class="">Torpedo</div>
		</div>
		<div style="position: absolute; top: 44px; left: 871px; width: 297px; height: 50px;">
			<div style="font-size: 35px; text-align: center;" class="">고객 목록</div>
		</div>
		<button type="button" onclick="location.href='login.jsp'"
			style="position: absolute; top: 44px; left: 1600px; width: 100px; height: 40px; font-size: 16px; color: rgb(255, 255, 255); text-align: center; line-height: 2.5em; border-top-left-radius: 4px; border-top-right-radius: 4px; border-bottom-right-radius: 4px; border-bottom-left-radius: 4px; background-color: rgb(52, 152, 219);">
			로그아웃</button>
		<table border="1"
			style="position: absolute; top: 176px; left: 670px; width: 400px; height: 90px;">
			<tr>
				<th>Id</th>
				<th>이름</th>
				<th>성</th>
				<th>Email</th>
				<th>성별</th>
				<th>ip 주소</th>
			</tr>
			<%
			 List<User> userList = (List<User>)request.getAttribute("userList");
			
				for (int i = 0; i < 10; i++) {
					User user = userList.get(i);
			%>
			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getFirstName()%></td>
				<td><%=user.getLastName()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getGender()%></td>
				<td><%=user.getIpAddress()%></td>
			</tr>
			<%
				}
			%>
		</table>

	</div>
</body>
</html>