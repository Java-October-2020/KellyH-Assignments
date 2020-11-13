<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>New Question</title>
</head>
<body>
<h1>What is your question?</h1>
<form:form action="/questions/new" method="post" modelAttribute="question">
	<p>
	<form:label path="text">Question: </form:label>
	<form:input type="textarea" path="text"/>
	<form:errors path="text"/>
	</p>
	<p>
	<form:label path="stringTags">Tags: </form:label>
	<form:input type="textarea" path="stringTags"/>
	<form:errors path="stringTags"/>
	</p>
	<input type="submit" value="Submit"/>
</form:form>
</body>
</html>