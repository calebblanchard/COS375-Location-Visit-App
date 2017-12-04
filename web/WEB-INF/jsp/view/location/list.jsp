<%--@elvariable id="locationDatabase" type="java.util.Map<Integer, edu.usm.cos375.model.Location>"--%>

<template:basic htmlTitle="Locations" bodyTitle="Locations">
    <c:choose>
        <c:when test="${fn:length(locationDatabase) == 0}">
            <i>There are no locations in the system.</i>
        </c:when>
        <c:otherwise>
            <c:forEach items="${locationDatabase}" var="entry">
               <a href="<c:url value="/location/view/${entry.key}" />">
               		Location ${entry.key}
               </a>
               <br />
            </c:forEach>
        </c:otherwise>
    </c:choose>
</template:basic>
