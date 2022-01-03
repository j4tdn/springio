<%@ include file="/WEB-INF/taglib/import.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer - Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css" />
	<style>
		td {
			padding: 8px;
		}
		th {
			text-align: center;
		}
	</style>


</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<form:form action="${contextPath}/customer/search" method="GET">
				Search Customer: <input type="text" name="param" value="${param.param}"/>
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
				<input type="button" value="Add Customer" class="add-button"
					onclick="window.location.href='${contextPath}/customer/add'; return false;" />
			</security:authorize>

			<table class="table table-bordered table-striped">
				<tr class="thead-dark">
					<c:url var="orderByFirstName" value="/customer/orderByFirstName" />
					<c:url var="orderByLastName" value="/customer/orderByLastName" />
					<c:url var="orderByEmail" value="/customer/orderByEmail" />
					<th><a href="${orderByFirstName}">First name</a></th>
					<th><a href="${orderByLastName}">Last name</a></th>
					<th><a href="${orderByEmail}">Email name</a></th>
					<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						<th>Action</th>
					</security:authorize>
				</tr>

				<c:forEach var="customer" items="${customers}">
					<!-- create updateLink with customer id-->
					<c:url var="updateLink" value="/customer/update">
						<c:param name="id" value="${customer.id}"></c:param>
					</c:url>

					<!-- create deleteLink with customer id >> @RequestParam-->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="id" value="${customer.id}"></c:param>
					</c:url>

					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						
						<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						<td>
							<a href="${updateLink}" class="btn btn-info btn-sm">Update</a>
							
							<security:authorize access="hasAnyRole('ADMIN')">	
								<a href="${deleteLink}" class="btn btn-danger btn-sm"
									onclick="if(!confirm('Are you sure you want to delete this customer ?')) return false">Delete</a>
							</security:authorize>
						</td>
						</security:authorize>
							
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<!-- Pagination  -->
	<div style='float:left'>
		<a href="${contextPath}">Back to home page</a>
	</div>
	<div style='float:right'>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>