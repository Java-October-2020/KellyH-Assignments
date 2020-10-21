<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Code</title>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

</head>
	<body>
		<div id="wrapper">
			<form method="POST" action="/code">
				<label>Enter the code! <input type="text" name="code"></label>
			</form>
			<div id="err" style="color: red"><c:out value="${error}"/></div>
		</div>		
	</body>
</html>