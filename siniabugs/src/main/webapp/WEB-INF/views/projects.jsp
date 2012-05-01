<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.even {
	background-color: silver;
}
</style>
<title>Projects</title>
</head>
<body>

	<c:if test="${fn:length(projects) > 0}">
		<table>
			<tr class="even">
				<th>Name</th>
				<th>Short Code</th>
				<th>Created by</th>
				<th>Last edited at</th>
				<th>Last edited by</th>
			</tr>
			<c:forEach items="${projects}" var="project" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td><a href="project?id=${project.id}">${project.name}</a></td>
					<td>${project.shortCode}</td>
					<td><a href="user?id=${project.createdBy.id}">${project.createdBy.firstName}
							${project.createdBy.surname}</a></td>
					<td>${project.versionStart}</td>
					<td><a href="user?id=${project.editedBy.id}">${project.editedBy.firstName}
							${project.editedBy.surname}</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>