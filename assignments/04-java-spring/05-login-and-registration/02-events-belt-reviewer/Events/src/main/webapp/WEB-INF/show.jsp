<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
</head>
<body>
<h1>${event.eventName}</h1>
<h2>${event.eventLocation}</h2>
<h3>${event.host.firstName} ${event.host.lastName}</h3>
<c:if test="${user.id == event.host.id}">
	<div class="container">
	<form:form action="/editEvent/${event.id}" method="post" modelAttribute="event">
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
</c:if>
<div class="container">
<H2>Message Wall</H2>
<table>
<c:forEach items ="${messages}" var="message">
<tr>
	<td><c:out value ="${message.msgPoster.firstName} ${message.msgPoster.lastName} says ${message.msg}"/></td>
</tr>
</c:forEach>
</table>
<form:form action ="/message/${event.id}" method="post" modelAttribute="message">
<form:label path="msg"/>
<form:input path="msg"/>
<form:errors path="msg"/>
<input type="submit" value="Post"/>
</form:form>
</div>
</body>
</html>