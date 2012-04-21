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
<title>Users</title>
</head>
<body>

	<c:if test="${fn:length(users) > 0}">
		<table>
			<tr class="even">
				<th>Name</th>
				<th>Created by</th>
				<th>Last edited at</th>
				<th>Last edited by</th>
			</tr>
			<c:forEach items="${users}" var="user" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td><a href="user?id=${user.id}">${user.firstName}
							${user.surname}</a></td>
					<td><a href="user?id=${user.createdBy.id}">${user.createdBy.firstName}
							${user.createdBy.surname}</a></td>
					<td>${user.start}</td>
					<td><a href="user?id=${user.editedBy.id}">${user.editedBy.firstName}
							${user.editedBy.surname}</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>