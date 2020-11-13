<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>Questions Dashboard</title>
</head>
<body>
<h1>Questions Dashboard</h1>
<table>
	<tr>
		<th>Question</th>
		<th>Tags</th>
	</tr>
	<c:forEach items="${questions}" var ="question">
	<tr>
		<td><c:out value="${question.text}"/></td>
		<c:forEach items="${question.tags}" var ="tag">
			<td><c:out value="${tag.subject}"/>
		</c:forEach>
	</tr>
	</c:forEach>
</table>
<a href="/questions/new">New Question</a>
</body>
</html>