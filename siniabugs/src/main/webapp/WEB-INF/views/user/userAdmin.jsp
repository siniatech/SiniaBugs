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
	<P>Logged in as: ${users[0].currentUserName}</P>

	<c:if test="${fn:length(users) > 0}">
		<table>
			<tr class="even">
				<th>Name</th>
				<th>Created by</th>
				<th>Last edited at</th>
				<th>Last edited by</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${users}" var="user" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td><a href="View?id=${user.id}">${user.firstName}
							${user.surname}</a></td>
					<td><a href="View?id=${user.creator.id}">${user.creator.firstName}
							${user.creator.surname}</a></td>
					<td>${user.versionStart}</td>
					<td><a href="View?id=${user.lastEditor.id}">${user.lastEditor.firstName}
							${user.lastEditor.surname}</a></td>
					<td><a href="Edit?id=${user.id}">Edit</a> <a href="Delete?id=${user.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<a href="Create">Create new user</a>
</body>
</html>