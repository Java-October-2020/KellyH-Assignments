<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
Hello

<c:out value="${langs.name}"/>
<c:out value="${langs.creator}"/>
<c:out value="${langs.version}"/>

<a href="/languages">Dashboard</a>
<a href="/languages/edit/${langs.id}">Edit</a>
<a href="/languages/delete/${langs.id}">Delete</a>