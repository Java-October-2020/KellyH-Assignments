<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Songs</title>
</head>
<body>
<a href="/songs/new">Add New</a>
<a href="/search/topTen">Top Songs</a>
<form action="/search" method="get">
	<input type="text" name="artist">
	<input type="submit" value="search">
</form>
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Artist</th>
			<th>Rating</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${songs}" var="song">
		<tr>
			<td><c:out value="${song.title}"/></td>
			<td><c:out value="${song.artist}"/></td>
			<td><c:out value="${song.rating}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>