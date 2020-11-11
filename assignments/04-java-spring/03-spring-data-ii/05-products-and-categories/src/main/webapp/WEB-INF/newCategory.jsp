<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
<h1>New Category</h1>
<form:form action="/categories/new" method="post" modelAttribute="category">
	<p>
	<form:label path="name">Name: </form:label>
	<form:input path="name"/>
	<form:errors path="name"/>
	</p>
	<input type="submit" value="Submit Product"/>
</form:form>
</body>
</html>