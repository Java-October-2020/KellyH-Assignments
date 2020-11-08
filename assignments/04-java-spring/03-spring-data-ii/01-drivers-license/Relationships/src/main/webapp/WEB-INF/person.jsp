<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
</head>
<body>
<h1>New Person</h1>
<form:form action="/persons/new" method="post" modelAttribute="person">
	<p>
		<form:label path="firstName">First Name: </form:label>
		<form:input path="firstName"/>
		<form:errors path="firstName"/>
	</p>
	<p>
		<form:label path="lastName">Last Name: </form:label>
		<form:input path="lastName"/>
		<form:errors path="lastName"/>
	</p>
	<input type="submit" value="Create"/>
</form:form>
</body>
</html>