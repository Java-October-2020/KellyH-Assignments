<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<form:form action="/languages/edit/${lang.id}" method="post" modelAttribute="lang">
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