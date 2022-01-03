<%@ include file="/WEB-INF/taglib/import.jsp" %>
<html>
<head>
	<title>Spring Home Page</title>
	<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<body>
	<h2>Spring Home Page - Welcome</h2>
	
	<hr>
	
	<p>Welcome to Spring Home Page</p>
	<p>I wish You all the best</p>
	
	<hr>
	
	<p> User: <security:authentication property="principal.username"/> </p>
	<p> Role(s): <security:authentication property="principal.authorities"/> </p>
	
	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${contextPath}/leaders">Leadership meeting</a> (Only for Manager)
		</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${contextPath}/systems">IT Systems meeting</a> (Only for Admin)
		</p>
	</security:authorize>	
	
	<form:form method="POST" action="${contextPath}/logout">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>
