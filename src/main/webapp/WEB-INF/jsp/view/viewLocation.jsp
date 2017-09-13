<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@ page session="true" import="edu.usm.cos375.model.Location" %>
<%
	String locationId = (String) request.getAttribute("locationId");
	Location location = (Location) request.getAttribute("location");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Location Visit</title>
	</head>
	<body>
		<a href="<c:url value="/login?logout" />">Logout</a>
		<h2>Location #<%=location.getId() %>:</h2>
		<p style="padding-left: 35px"> 
			<i>Location Name: <%=location.getName() %></i>
			<br />
			<i>Town: <%=location.getTown() %></i>
			<br />
			<i>County: <%=location.getCounty() %></i>
			<br />
			<i>Latitude: <%=location.getLatitude() %></i>
			<br />
			<i>Longitude: <%=location.getLongitude() %></i>
			<br />
			<i>Field Worker Name: <%=location.getFieldWorkerName() %></i>
		</p>
		<br />	
		<a href="<c:url value="/locations" />">Return to list locations</a> 
	</body>
</html>