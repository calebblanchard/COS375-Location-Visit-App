<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page session="true" import="java.util.Map, edu.usm.cos375.model.Location" %>
<%
	@SuppressWarnings("unchecked")
	Map<Integer, Location> locationDatabase = 
			(Map<Integer, Location>) request.getAttribute("locationDatabase");
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Location Visit</title>
	</head>
	<body>
		<a href="<c:url value="/login?logout" />">
			<p align="right">Logout</p>
		</a>
		<h2>Locations</h2>
		
		<%
		if(locationDatabase.size() == 0)
		{
		%>
			<br />
			<br />
			<i>There are no locations in the system.</i>
		<%
		}
		else
		{
			for(int id : locationDatabase.keySet())
			{
				String idString = Integer.toString(id);
				Location location = locationDatabase.get(id);
			%>
				Location #<%= idString %>: 
				<a href="<c:url value="/locations">
				<c:param name="action" value="view" />
				<c:param name="locationId" value="<%= idString %>" />
				</c:url>"><%= location.getName() %></a> 
				<br />
				<p style="padding-left: 35px"> 
					<%=location.getTown() %>, 
					<%=location.getCounty() %> 
					(<%=location.getLatitude() %>, 
					<%=location.getLongitude() %>)
				</p>
				<br />
			<%
			}            
		}
		%>
		<a href="<c:url value="/locations">
			<c:param name="action" value="create" />
			</c:url>">
			<p align="right">Create Location</p>
		</a>
	</body>
</html>