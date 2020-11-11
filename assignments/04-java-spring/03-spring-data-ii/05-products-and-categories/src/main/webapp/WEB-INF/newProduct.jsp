<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
<h1>New Product</h1>
<form:form action="/products/new" method="post" modelAttribute="product">
	<p>
	<form:label path="name">Name: </form:label>
	<form:input path="name"/>
	<form:errors path="name"/>
	</p>
	<p>
	<form:label path="description">Description: </form:label>
	<form:input type="textarea" path="description"/>
	<form:errors path="description"/>
	</p>
	<p>
	<form:label path="price">Price: </form:label>
	<form:input path="price"/>
	<form:errors path="price"/>
	</p>
	<input type="submit" value="Submit Product"/>
</form:form>
</body>
</html>