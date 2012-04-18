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

	<c:if test="${fn:length(issueTypeList) > 0}">
		<table cellpadding="5">
			<tr class="even">
				<th>Id</th>
				<th>Short Code</th>
				<th>Name</th>
			</tr>
			<c:forEach items="${issueTypeList}" var="issueType" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td>${issueType.id}</td>
					<td>${issueType.shortCode}</td>
					<td>${issueType.name}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>