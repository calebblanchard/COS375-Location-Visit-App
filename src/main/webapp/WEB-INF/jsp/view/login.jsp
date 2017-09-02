<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Location Management</title>
    </head>
    <body>
        <h2>Login</h2>
        You must log in to access the location management site.
        <br />
        <br />
        <%
        if(((Boolean) request.getAttribute("loginFailed")))
        {
        %>
        	<b>The field worker name and/or password you entered are not correct. Please try again.</b>
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
