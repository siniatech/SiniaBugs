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
<title>Priority - ${priority.name}</title>
</head>
<body>

	${priority.name}
	<br /> ${priority.createdBy.firstName}
	<br /> ${priority.createdBy.surname}
	<br /> ${priority.versionStart}
	<br /> ${priority.editedBy.firstName}
	<br /> ${priority.editedBy.surname}
	<br />

</body>
</html>