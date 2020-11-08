<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person</title>
</head>
<body>
<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
<h4>State: <c:out value="${license.state}"/></h4>
<h4>License Number: <c:out value="${license.number}"/></h4>
<h4>Exp. Date: <c:out value="${license.expiration_date}"/></h4>

</body>
</html>