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
<title>Issue Page</title>
</head>
<body>

	<form:form action="issue" commandName="issue">
		<table>
			<tr>
				<td>Title :</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form:form>
	<c:if test="${fn:length(issueList) > 0}">
		<table>
			<tr class="even">
				<th>Id</th>
				<th>Title</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${issueList}" var="issue" varStatus="status">
				<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
					<td>${issue.id}</td>
					<td>${issue.title}</td>
					<td>${issue.description}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>