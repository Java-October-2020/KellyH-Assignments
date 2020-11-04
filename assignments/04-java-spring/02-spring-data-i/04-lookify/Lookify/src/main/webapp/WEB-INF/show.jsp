<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<td>Title: </td>
				<td><c:out value="${song.title}"/></td>
			</tr>
			<tr>
				<td>Artist: </td>
				<td><c:out value="${song.artist}"/></td>
			</tr>
			<tr>
				<td>Rating(1-10)</td>
				<td><c:out value="${song.rating}"/></td>
			</tr>
		</tbody>
	</table> 
	<a href="/delete/${song.id}">Delete</a>
</body>
</html>