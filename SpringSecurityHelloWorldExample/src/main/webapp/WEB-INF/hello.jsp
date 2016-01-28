<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
    <%@ page session="false" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
${message}
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
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<a href="${logoutUrl}">Log Out</a>
 
</body>
</html>

