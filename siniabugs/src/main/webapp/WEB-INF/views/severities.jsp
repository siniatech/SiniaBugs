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
<title>Severities</title>
</head>
<body>

	<c:if test="${fn:length(severities) > 0}">
		<table>
			<tr class="even">
				<th>Name</th>
				<th>Created by</th>
				<th>Last edited at</th>
				<th>Last edited by</th>
			</tr>
			<c:forEach items="${severities}" var="severity" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td><a href="severity?id=${severity.id}">${severity.name}</a></td>
					<td><a href="user?id=${severity.createdBy.id}">${severity.createdBy.firstName}
							${severity.createdBy.surname}</a></td>
					<td>${severity.versionStart}</td>
					<td><a href="user?id=${severity.editedBy.id}">${severity.editedBy.firstName}
							${severity.editedBy.surname}</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>