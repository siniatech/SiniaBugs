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
<title>${action} user</title>
</head>
<body>

	<form:form action="${action}" commandName="user">
		<form:hidden path="uid" />
		<table>
			<tr>
				<td>First name :</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Surname :</td>
				<td><form:input path="surname" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="${action}"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>