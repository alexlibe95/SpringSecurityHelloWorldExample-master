<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
    <%@ page session="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Requested Appointments</title>
</head>
<body>
<h1>
	Requested Appointments 
</h1>
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
	<c:forEach items="${appoints}" var="appoint"> 
  <tr>
    <td>${appoint.amka}</td>
    <td>${appoint.name}</td>
    <td>${appoint.surname}</td>
    <td>${appoint.tameio}</td>
    <td>${appoint.ejetash}</td>
    <td>${appoint.emergency}</td>
    <td>${appoint.date}</td>
    <td>${appoint.time}</td>
   
    
    <td> <a href="/Appointment/edit/${appoint.amka}">Edit </a></td>
    <td><a href="<c:url value='/Appointment/remove/${appoint.amka}'/> " > Delete </a></td>

  </tr>
</c:forEach>
</table>
</section>
<ul>
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