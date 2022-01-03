<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student - Index - Page</title>

<link rel="stylesheet" href="<c:url value='/resources/css/style.css' />" >

</head>
<body>
	<h1>Customer - Confirmation</h1>
	
	First Name: ${customer.firstName}
	
	<hr>
	
	Last Name: ${customer.lastName}
	
	<hr>
	
	Free Passes: ${customer.freePasses} 
	
	<hr>
	
	Postal Code: ${customer.postalCode}
	
	<hr>
	
	Postal Code: ${customer.courseCode}
	
</body>
</html>