<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">    
<title>Songs by artist</title>
</head>
<body>
<h1>Songs By: ${artist}</h1>
<h3>New Search</h3>
<form action="/search" method="get">
	<input type="text" name="artist">
	<input type="submit" value="Search Artists">
</form>
<a href="/">Dashboard</a>
<table>
	<thead>
		<tr>
			<th>Song</th>
			<th>Rating</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${songsByArtist}" var="song">
		<tr>	
			<td><c:out value="${song.title}"/></td>
			<td><c:out value="${song.rating}"/></td>
			<td><a href="/delete/${song.id}">Delete</a>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>