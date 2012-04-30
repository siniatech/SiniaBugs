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
<title>Issue Type - ${issueType.name}</title>
</head>
<body>

	${issueType.name}
	<br /> ${issueType.shortCode}
	<br /> ${issueType.createdBy.firstName}
	<br /> ${issueType.createdBy.surname}
	<br /> ${issueType.versionStart}
	<br /> ${issueType.editedBy.firstName}
	<br /> ${issueType.editedBy.surname}
	<br />

</body>
</html>