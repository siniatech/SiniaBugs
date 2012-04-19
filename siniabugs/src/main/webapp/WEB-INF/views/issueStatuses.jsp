<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Status" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.even {
	background-color: silver;
}
</style>
<title>Issue Statuses</title>
</head>
<body>

	<c:if test="${fn:length(issueStatuses) > 0}">
		<table cellpadding="5">
			<tr class="even">
				<th>Name</th>
				<th>Created by</th>
				<th>Last edited at</th>
				<th>Last edited by</th>
			</tr>
			<c:forEach items="${issueStatuses}" var="issueStatus" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td><a href="issueStatus?id=${issueStatus.id}">${issueStatus.name}</a></td>
					<td><a href="user?id=${issueStatus.createdBy.id}">${issueStatus.createdBy.firstName}
							${issueStatus.createdBy.surname}</a></td>
					<td>${issueStatus.start}</td>
					<td><a href="user?id=${issueStatus.editedBy.id}">${issueStatus.editedBy.firstName}
							${issueStatus.editedBy.surname}</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>