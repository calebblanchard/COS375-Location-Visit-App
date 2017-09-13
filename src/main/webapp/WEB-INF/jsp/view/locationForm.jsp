<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page session="true" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Location Visit Form</title>
	</head>
	<body>
		<a href="<c:url value="/login?logout" />">Logout</a>
		<h2>Create a Location</h2>
		<form method="POST" action="locations" enctype="multipart/form-data">
			<input type="hidden" name="action" value="create"/>
			Name
			<br/>
			<input type="text" name="name"/>
			<br/>
			<br/>
			Town
			<br/>
			<input type="text" name="town"/>
			<br/>
			<br/>
			County
			<br/>
			<input type="text" name="county"/>
			<br/>
			<br/>
			Latitude
			<br />
			<input type="number" min="-90" max="90" name="latitude"/>
			<br/>
			<br/>
			Longitude
			<br />
			<input type="number" min "-180" max="180" name="longitude"/>
			<br/>
			<br/>
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html>