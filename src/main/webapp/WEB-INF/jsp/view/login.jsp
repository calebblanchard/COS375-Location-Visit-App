<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Location Visit</title>
	</head>
	<body>
		<h2>Login</h2>
		You must log in to access the location management site.
		<br />
		<br />
		<%
		if((Boolean) request.getAttribute("loginFailed"))
		{ 
		%>
			<b>The field worker and/or password you entered are not correct. Please try again.</b>
			<br />
			<br />
		<%
		}
		%>
		<form method="POST" action="<c:url value="/login" />">
			Field Worker Name:
			<br />
			<input type="text" name="username" />
			<br />
			<br />
			Password
			<br />
			<input type="password" name="password" />
			<br />
			<br />
			<input type="submit" value="Log In" />
		</form>
	</body>
</html>