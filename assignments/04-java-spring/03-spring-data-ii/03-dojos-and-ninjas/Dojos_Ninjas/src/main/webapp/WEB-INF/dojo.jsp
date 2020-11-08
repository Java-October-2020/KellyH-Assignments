<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Dojo</h1>
<form:form action="/dojos/new" method="post" modelAttribute="dojo">
	<p>
		<form:label path="name">Name: </form:label>
		<form:input path="name"/>
		<form:errors path = "name"/>
	</p>
	<input type="submit" value="Create"/>
</form:form>
</body>
</html>