<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<title>${question.text}</title>
</head>
<body>
<h1>${question.text}</h1>
<h3>Tags</h3>
<c:forEach items="${question.tags}" var="tag">
	<p>${tag.subject}</p>
</c:forEach>

<form:form action="/questions/${question.id}" method="post" modelAttribute="answer">
	<form:label path="text">Answer this question: </form:label>
	<form:input path="text"/>
	<form:errors path="text"/>
	<!--<form:hidden path="question" value="${question}"/>
	<form:errors path="question"/>
    pull question id from question model attribute --> 
	<input type="submit" value="Submit"/>
</form:form>

<h3>Answers:</h3>
<c:forEach items="${question.answers}" var="answer">
	<c:out value="${answer.text}"/>
</c:forEach>
</body>
</html>