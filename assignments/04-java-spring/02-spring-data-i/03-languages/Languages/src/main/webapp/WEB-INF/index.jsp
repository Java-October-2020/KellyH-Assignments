<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1>Languages</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach items="${langs}" var="langs" varStatus="loop">
		<tr>    
		    <td><c:out value="${langs.name}"/></td>
		    <td><c:out value="${langs.creator}"/></td>
		    <td><c:out value="${langs.version}"/></td>
		    <td><a href="/languages/edit/${langs.id}">Edit</a></td>
		    <td><a href="/languages/delete/${langs.id}">Delete</a></td>
		</tr>
        </c:forEach>
    </tbody>
</table>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<form:form action="/languages/new" method="POST" modelAttribute="lang">
	<p>
		<form:label path="name">Name</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
	</p>
	<p>
		<form:label path="creator">Creator</form:label>
		<form:errors path="creator"/>
		<form:input path="creator"/>
	</p>
	<p>
		<form:label path="version">Version</form:label>
		<form:errors path="version"/>
		<form:input path="version"/>
	</p>
	<input type="submit" value="Submit"></input>
</form:form>