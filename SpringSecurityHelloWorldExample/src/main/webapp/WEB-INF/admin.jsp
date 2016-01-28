<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin's Protected Page</title>
</head>
<body>
<p>
Admin's Protected Page
</p>
<ul>
<li>
<a href="<c:url value='/req_user'/>">User's Request</a>
</li>
<li>
<a href="<c:url value='/req_appointment'/>">Appointment's Request</a>
</li>
<li>
<a href="<c:url value='/events'/>">Events's List</a>
</li>
<li>
<a href="<c:url value='/emails'/>">Newsletter's E-mails</a>
</li>
<li>
<a href="<c:url value='/AppointmentList'/>">Appointment's List</a>
</li>
<li>
<a href="<c:url value='/Appointment'/>">Add Appointment</a>
</li>
</ul>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<a href="${logoutUrl}">Log Out</a>
</body>
</html>