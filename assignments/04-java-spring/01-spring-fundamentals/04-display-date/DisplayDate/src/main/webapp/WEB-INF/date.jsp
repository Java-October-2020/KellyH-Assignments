<!DOCTYPE html>
<html>
<head>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <title>Time template</title>
    	<link rel="stylesheet" type="text/css" href="style.css">
        <script type="text/javascript" src="main.js"></script>
        <body onload="dateAlert()">
</head>
<body>
        <h1 class="date">The date is <c:out value="${ddate}"/></h1>
        
</body>
</html>