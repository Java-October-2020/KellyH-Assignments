<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form path="/licenses/new" method="POST" modelAttribute="license">
	<p>
	<form:label path="person">person: </form:label>
	<form:select path="person">
		<c:forEach items="${persons}" var ="person">
		<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
		</c:forEach>
	</form:select>
	<form:errors path="person"/>
	</p>
	<p>
		<form:label path="state">state: </form:label>
		<form:input path="state"/>
		<form:errors path="state"/>
	</p>
	<p>
	<form:label path="expiration_date">Expiration Date: </form:label>
	<form:input type="date" path="expiration_date"/>
	<form:errors path="expiration_date"/>
	</p>
	<input type="submit" value="Add License"/>
</form:form>
</body>
</html>