<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
   <link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">  
</head>
<body>
<h1>Welcome ${user.firstName}</h1>
<a href="/logout">Logout</a>
<div class="container">
	<table class="table table-dark">
		<thead>Events in your state</thead>
		<tr>
			<td>Name</td>
			<td>Date</td>
			<td>Location</td>
			<td>Host</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${events}" var ="event">
		<tr>
			<c:if test = "${user.state == event.state}">
				<td><a href="/events/${event.id}"><c:out value="${event.eventName}"/></a></td>
				<td><c:out value="${event.eventDate}"/></td>
				<td><c:out value="${event.eventLocation}, ${event.state}"/></td>
				<td><c:out value="${event.host.firstName}"/></td>
				<td>
				<c:choose>
					<c:when test = "${user.id == event.host.id}">
						<a href="/delete/${event.id}">Delete</a> | <a href="/edit">Edit</a>
					</c:when>
					<c:when test = "${event.usersAttending.contains(user)}">
						<a href="/unRsvp/${event.id}">unRSVP</a>
					</c:when>
					<c:otherwise>
						<a href="/rsvp/${event.id}">RSVP</a>
					</c:otherwise>
				</c:choose>
				</td>
			</c:if>
		</tr>
		</c:forEach>
	</table>
		<table class="table table-dark">
		<thead>Events in other states</thead>
		<tr>
			<td>Name</td>
			<td>Date</td>
			<td>Location</td>
			<td>Host</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${events}" var ="event">
		<tr>
			<c:if test = "${user.state != event.state}">
				<td><a href="/events/${event.id}"><c:out value="${event.eventName}"/></a></td>
				<td><c:out value="${event.eventDate}"/></td>
				<td><c:out value="${event.eventLocation}, ${event.state}"/></td>
				<td><c:out value="${event.host.firstName}"/></td>
				<td>
				<c:choose>
					<c:when test = "${user.id == event.host.id}">
						<a href="/delete/${event.id}">Delete</a> | <a href="/edit">Edit</a>
					</c:when>
					<c:when test = "${event.usersAttending.contains(user)}">
						<a href="/unRsvp/${event.id}">unRSVP</a>
					</c:when>
					<c:otherwise>
						<a href="/rsvp/${event.id}">RSVP</a>
					</c:otherwise>
				</c:choose>
				</td>
			</c:if>
		</tr>
		</c:forEach>
	</table>
</div>
<div class="container">
	<form:form action="/createEvent" method="post" modelAttribute="event">
		<p>
		<form:label path="eventName">Name: </form:label>
		<form:input path="eventName"/>
		<form:errors path="eventName"/>
		</p>
		<p>
		<form:label path="eventDate">Date: </form:label>
		<form:input type="date" path="eventDate"/>
		<form:errors path="eventDate"/>
		</p>
		<p>
		<form:label path="eventLocation">Location: </form:label>
		<form:input path="eventLocation"/>
		<form:errors path="eventLocation"/>
		<form:select path="state">
			<c:forEach items="${states}" var="state">
				<form:option value="${state}">${state}</form:option>
			</c:forEach>
		</form:select>
		<p>
		<input type="submit" value="Submit"/>
		</p>
	</form:form>
</div>
</body>
</html>