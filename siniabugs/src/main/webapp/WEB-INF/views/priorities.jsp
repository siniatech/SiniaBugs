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

	<c:if test="${fn:length(priorities) > 0}">
		<table>
			<tr class="even">
				<th>Name</th>
				<th>Created by</th>
				<th>Last edited at</th>
				<th>Last edited by</th>
			</tr>
			<c:forEach items="${priorities}" var="priority" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td><a href="priority?id=${priority.id}">${priority.name}</a></td>
					<td><a href="user?id=${priority.createdBy.id}">${priority.createdBy.firstName}
							${priority.createdBy.surname}</a></td>
					<td>${priority.versionStart}</td>
					<td><a href="user?id=${priority.editedBy.id}">${priority.editedBy.firstName}
							${priority.editedBy.surname}</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>