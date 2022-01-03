<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName"/>
		
		<br> <br>
		
		Last name: <form:input path="lastName"/>
		
		<br> <br>
		
		Country: 
		<form:select path="country">
			<c:forEach var="countryValue" items="${countries}">
				<form:option value="${countryValue}" label="${countryValue}" />
			</c:forEach>
		</form:select>
		
		<br> <br>
		
		Favorite Language:
		<c:forEach var="language" items="${languages}">
			${language}: <form:radiobutton path="favoriteLanguage" value="${language}"/>
		</c:forEach>
		
		<br> <br>
		
		Operating Systems:
		<c:forEach var="operatingSystem" items="${operatingSystems}">
			${operatingSystem} <form:checkbox path="operatingSystems" value="${operatingSystem}"/>
		</c:forEach>
		
		<br> <br>
		
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>