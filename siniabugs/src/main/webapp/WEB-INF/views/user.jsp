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
<title>User - ${user.firstName} ${user.surname}</title>
</head>
<body>

	<br /> ${user.firstName}
	<br /> ${user.surname}
	<br /> ${user.createdBy.firstName}
	<br /> ${user.createdBy.surname}
	<br /> ${user.start}
	<br /> ${user.editedBy.firstName}
	<br /> ${user.editedBy.surname}
	<br />

</body>
</html>