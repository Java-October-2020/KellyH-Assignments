<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Survey Results</title>
       <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
       <link rel="stylesheet" href="style.css">

</head>
<body>
	<div id="survey_body">
		<h1>Submitted Info</h1>
		<ul class="lBody">
			<li>Name: </li>
			<li>Location: </li>
			<li>Language: </li>
			<li>Comments: </li>
		</ul>
		<ul class="lBody">
			<li><c:out value="${sName}"/></li>
			<li><c:out value="${sLocation}"/></li>
			<li><c:out value="${sLanguage}"/></li>
			<li><c:out value="${sComment}"/></li>
		</ul>
		<button><a href="/">Go back</a></button>
	</div>
	
</body>
</html>