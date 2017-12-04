<%--@elvariable id="locationId" type="java.lang.Long"--%>
<%--@elvariable id="location" type="edu.usm.cos375.model.Location"--%>

<template:basic htmlTitle="${location.name}" bodyTitle="Location #${locationId}: ${location.name}">
    <i>Location Name: <c:out value="${location.name}" /><br />
    <i>Town: <c:out value="${location.town}" /><br />
    <i>County: <c:out value="${location.county}" /><br />
    <i>Latitude: <c:out value="${location.latitude}" /><br />
    <i>Longitude: <c:out value="${location.longitude}" /><br />
    <i>FieldWorker: <c:out value="${location.fieldWorkerName}" /><br />
</template:basic>
