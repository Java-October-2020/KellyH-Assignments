<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title><c:out value="${category.name}" /></title>
</head>
<body>
	<h1>
		<c:out value="${category.name}" />
	</h1>
	<h3>Products</h3>
	<ul>
		<c:forEach items="${cProducts}" var="product">
			<li>${product.name}</li>
		</c:forEach>
	</ul>
	<form:form action="/addProduct/${category.id}" method="post" modelAttribute="category">
		<form:label path="products">Add Product</form:label>
		<form:select path="products">
			<c:forEach items="${notProducts}" var="p">	
				<form:option value="${p.id}">${p.name}</form:option>
			</c:forEach>
		</form:select>
			<input type="submit" value= "Add"/>
	</form:form>
</body>
</html>