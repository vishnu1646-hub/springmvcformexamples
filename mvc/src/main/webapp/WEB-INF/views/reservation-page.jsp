<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Form</title>
</head>
<h2>Railway Reservation Form</h2>
<body>
	<form:form action="submitForm" modelAttribute="reservation">
        First name: <form:input path="firstName" />
		<br>
		<br>  
        Last name: <form:input path="lastName" />
		<br>
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>