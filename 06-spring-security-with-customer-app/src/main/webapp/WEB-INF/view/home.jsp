<%@ include file="/WEB-INF/taglib/import.jsp"%>
<html>
<head>
<title>Spring Home Page</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
	
	<style>
		body {
			padding: 10px;
		}
	</style>

</head>
<body>
	<h2>Spring Home Page - Welcome</h2>

	<hr>

	<p>Welcome to Spring Home Page</p>
	<p>I wish You all the best</p>
	
	<security:authorize access="isAuthenticated()">
		<hr>
		<p>
			Visit our great customer 
			<a href="${contextPath}/customer">page</a>
		</p>
	</security:authorize>
	
	<hr>

	<security:authorize access="isAuthenticated()">
		<p>
			User:
			<security:authentication property="principal.username" />
		</p>
		<p>
			Role(s):
			<security:authentication property="principal.authorities" />
		</p>
		<p>FirstName: ${user.firstName}, LastName: ${user.lastName}</p>
		<hr>
	</security:authorize>



	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${contextPath}/leaders">Leadership meeting</a> (Only for
			Manager)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${contextPath}/systems">IT Systems meeting</a> (Only for
			Admin)
		</p>
	</security:authorize>

	<security:authorize access="!isAuthenticated()">
		<a href="${contextPath}/login">Login</a>

		<a href="${contextPath}/signup" class="btn btn-primary" role="button"
			aria-pressed="true"> Sign up </a>
	</security:authorize>
	<security:authorize access="isAuthenticated()">
		<form:form method="POST" action="${contextPath}/logout">
			<input type="submit" value="Logout">
		</form:form>
	</security:authorize>

</body>
</html>
