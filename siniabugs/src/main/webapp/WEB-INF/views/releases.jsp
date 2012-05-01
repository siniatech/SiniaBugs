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
<title>Releases</title>
</head>
<body>

	<c:if test="${fn:length(releases) > 0}">
		<table>
			<tr class="even">
				<th>Name</th>
				<th>Release start</th>
				<th>Release end</th>
				<th>Created by</th>
				<th>Last edited at</th>
				<th>Last edited by</th>
			</tr>
			<c:forEach items="${releases}" var="release" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td><a href="release?id=${release.id}">${release.name}</a></td>
					<td>${release.releaseStart}</td>
					<td>${release.releaseEnd}</td>
					<td><a href="user?id=${release.createdBy.id}">${release.createdBy.firstName}
							${release.createdBy.surname}</a></td>
					<td>${release.versionStart}</td>
					<td><a href="user?id=${release.editedBy.id}">${release.editedBy.firstName}
							${release.editedBy.surname}</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>