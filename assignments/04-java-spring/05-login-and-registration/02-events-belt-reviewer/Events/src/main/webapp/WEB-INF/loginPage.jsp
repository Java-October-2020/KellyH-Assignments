<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <h1>Register!</h1>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="firstName">First name:</form:label>
            <form:input path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last name:</form:label>
            <form:input path="lastName"/>
        </p>
        <p>
            <form:label path="location">Location:</form:label>
            <form:input path="location"/>
            
            <form:label path="state">State:</form:label>
            <form:select path="state">
            	<c:forEach items="${states}" var ="state">
            		<form:option value="${state}">${state}</form:option>
            </c:forEach>
            </form:select>            
        </p>
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="confirmPw">Password Confirmation:</form:label>
            <form:password path="confirmPw"/>
        </p>
        
        <input type="submit" value="Register!"/>
    </form:form>
    
    <h1>Login</h1>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login">
        <p>
            <label type="email" for="email">Email</label>
            <input type="text" id="email" name="lEmail"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="lPassword"/>
        </p>
        <input type="submit" value="Login!"/>
    </form>    
</body>
</html>