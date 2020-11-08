<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Age</th>
	</tr>
	<c:forEach items="${ninjas}" var ="ninjas">
		<tr>
			<td><c:out value="${ninjas.firstName}"/></td>
			<td><c:out value="${ninjas.lastName}"/></td>
			<td><c:out value="${ninjas.age}"/></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>