<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
    <%@ page session="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Appointments</title>
</head>
<body>
<section>
<table>
	<tr>
	<th> Amka </th>
	<th> Name </th>
	<th> Surname </th>
	<th> Tameio </th>
	<th> Examination </th>
	<th> Emergency </th>
	<th> Date </th>
	<th> Time </th>
	
	</tr>
	<c:forEach items="${appointments}" var="appointment"> 
  <tr>
    <td>${appointment.amka}</td>
    <td>${appointment.name}</td>
    <td>${appointment.surname}</td>
    <td>${appointment.tameio}</td>
    <td>${appointment.ejetash}</td>
    <td>${appointment.emergency}</td>
    <td>${appointment.date}</td>
    <td>${appointment.time}</td>
    <td> <a href="/SpringSecurityHelloWorlExample/edit/${appointment.amka}">Edit </a></td>
    <td><a href="<c:url value='/remove/${appointment.amka}'/> " > Delete </a></td>
    
  </tr>
</c:forEach>
</table>
</section>

<ul>
<li>
<a href="<c:url value='/Appointment'/>">Add Appointment</a>
</li>
<li>
<a href="<c:url value='/admin'/>">Admin's Protected Page</a>
</li>
<li>
<a href="<c:url value='/supermoderator'/>">Moderator's Protected Page</a>
</li>
<li>
<a href="<c:url value='/moderator'/>">SuperModerator's Protected Page</a>
</li>
</ul>
</body>
</html>