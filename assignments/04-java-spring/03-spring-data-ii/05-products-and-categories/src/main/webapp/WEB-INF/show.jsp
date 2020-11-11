<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<title><c:out value="${product.name}" /></title>
</head>
<body>
	<h1>
		<c:out value="${product.name}" />
	</h1>
	<h3>Categories</h3>
	<ul>
		<c:forEach items="${pCategories}" var="category">
			<li>${category.name}</li>
		</c:forEach>
	</ul>
	<form:form action="/addCategory/${product.id}" method="post" modelAttribute="product">
		<form:label path="categories">Add Category</form:label>
		<form:select path="categories">
			<c:forEach items="${notCategories}" var="c">	
				<form:option value="${c.id}">${c.name}</form:option>
			</c:forEach>
		</form:select>
			<input type="submit" value= "Add"/>
	</form:form>
</body>
</html>