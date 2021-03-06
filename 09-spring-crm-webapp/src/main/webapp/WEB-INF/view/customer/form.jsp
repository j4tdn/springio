<%@ include file="/WEB-INF/taglib/import.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save Customer</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
</head>
<body>
	
	<div class="container">
		<h3 class="h4 mt-4 mb-4 ">Save Employee</h3>
		
		<hr>

		<form:form action="save" modelAttribute="customer" method="POST">
			<form:hidden path="id" />

			<div class="form-group row">
				<label for="firstName" class="col-sm-2 col-form-label">First name:</label>
				<div class="col-sm-4">
					<form:input class="form-control" path="firstName" id="firstName" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="lastName" class="col-sm-2 col-form-label">Last name:</label>
				<div class="col-sm-4">
					<form:input class="form-control" path="lastName" id="lastName" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email:</label>
				<div class="col-sm-4">
					<form:input class="form-control" path="email" id="email" />
				</div>
			</div>
			
			<button type="submit" class="btn btn-info col-1">Save</button>
		</form:form>

		<hr>
		
		<a href="${contextPath}/customer">Back to Employees List</a>
		
		<footer class="bg-light fixed-bottom py-3 text-center">
			<div class="container-fluid">
				<span class="text-muted">CMA made with JAVA89  &#129392;  03.01.2022</span>
			</div>
		</footer>
	</div>
</body>
</html>