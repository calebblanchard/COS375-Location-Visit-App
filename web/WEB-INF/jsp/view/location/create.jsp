<%--@elvariable id="locationForm" type="com.wrox.site.LocationController.Form"--%>

<template:basic htmlTitle="Create a Location" bodyTitle="Create a Location">
    <form:form method="post" enctype="multipart/form-data" modelAttribute="locationForm">
        
        <c:if test="${invalidLocation}">
			<b>You are missing some required information.
			Please enter a Name, a Town, and a County.</b>
			<br />
			<br />
		</c:if>
        
        <form:label path="name">Name</form:label><br />
        <form:input path="name" /><br /><br />
        
        <form:label path="town">Town</form:label><br />
        <form:input path="town" /><br /><br />
        
        <form:label path="county">County</form:label><br />
        <form:input path="county" /><br /><br />
        
        <form:label path="latitude">Latitude</form:label><br />
        <form:input path="latitude" /><br /><br />
        
        <form:label path="longitude">Longitude</form:label><br />
        <form:input path="longitude" /><br /><br />
        
        <input type="submit" value="Submit"/>
    </form:form>
</template:basic>
