<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Log in</title>
	</head>
	<body>
		<h2>Demographic System</h2>
		You must log in to access the location management site.
		<br />
		<br />
		<c:if test="${loginFailed}">
			<b>The username and password you entered are not correct. Please
				try again.</b>
			<br />
			<br />
		</c:if>

		<form:form method="post" modelAttribute="loginForm">
			<form:label path="username">FieldWorker Name:</form:label>
			<br />
			<form:input path="username" />
			<br />
			<br />
			<form:label path="password">Password:</form:label>
			<br />
			<form:password path="password" />
			<br />
			<br />
			<input type="submit" value="Log In" />
		</form:form>
	</body>
</html>
