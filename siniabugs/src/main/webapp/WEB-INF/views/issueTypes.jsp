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
<title>Issue Types</title>
</head>
<body>

	<c:if test="${fn:length(issueTypes) > 0}">
		<table>
			<tr class="even">
				<th>Name</th>
				<th>Short Code</th>
				<th>Created by</th>
				<th>Last edited at</th>
				<th>Last edited by</th>
			</tr>
			<c:forEach items="${issueTypes}" var="issueType" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td><a href="issueType?id=${issueType.id}">${issueType.name}</a></td>
					<td>${issueType.shortCode}</td>
					<td><a href="user?id=${issueType.createdBy.id}">${issueType.createdBy.firstName}
							${issueType.createdBy.surname}</a></td>
					<td>${issueType.versionStart}</td>
					<td><a href="user?id=${issueType.editedBy.id}">${issueType.editedBy.firstName}
							${issueType.editedBy.surname}</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>