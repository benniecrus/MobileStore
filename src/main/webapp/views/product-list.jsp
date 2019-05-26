<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Product</title>
</head>
<body>
	<div class=" container">
		<div class="my-3 row">
			<div class="col-md-10">
				<h1>PRODUCTS</h1>
			</div>
			<div class="col-md-2" style="margin-top: 10px">
				<div class="d-inline-flex">
					<sec:authorize var="loggedInAdmin" ifAnyGranted="ROLE_ADMIN" />
					<sec:authorize var="loggedInStaff" ifAnyGranted="ROLE_STAFF" />
					<a href="<%=request.getContextPath()%>/cart/0"
						class="dropdown-item">View Cart(${cartSize})</a>
					<div class="dropdown">
						<c:choose>
							<c:when test="${loggedInAdmin}">
								<button type="button" class="btn btn-primary dropdown-toggle"
									data-toggle="dropdown">Menu</button>
							</c:when>
							<c:otherwise>
								<a href="<%=request.getContextPath()%>/login"
									class="dropdown-item">Login</a>
							</c:otherwise>
						</c:choose>
						<div class="dropdown-menu">
							<c:if test="${loggedInAdmin}">
								<h5 class="dropdown-header">Permision Admin</h5>
								<a href="<%=request.getContextPath()%>/order-list"
									class="dropdown-item">Manager Order</a>
								<a href="<%=request.getContextPath()%>/initProducManagement"
									class="dropdown-item">Manager Product</a>
								<a href="<%=request.getContextPath()%>/initAddProduct"
									class="dropdown-item">Create Product</a>
							</c:if>
							<c:choose>
								<c:when test="${loggedInAdmin || loggedInStaff}">
									<a href="<%=request.getContextPath()%>/logout"
										class="dropdown-item">Logout</a>
								</c:when>
								<c:otherwise>
									<a href="<%=request.getContextPath()%>/login"
										class="dropdown-item">Login</a>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="col-lg-12">
			<div class="row">
				<c:forEach items="${productPageDto.productList}" var="product">
					<div class="col-lg-3 col-md-6 mb-4">
						<div class="card h-100">
							<div>
								<a
									href="<%=request.getContextPath()%>/product/${product.productId}"><img
									class="card-img-top"
									src="data:image/png;base64,${product.base64Image}"
									alt="Image not found" width="200" height="300"></a>
							</div>
							<div style="padding-auto: 5px">
								<h4 class="card-title">
									<a href="#">${product.productName}</a>
								</h4>
								<h5>$${product.unitPrice}</h5>
								<div class="card-body">
									<h6 class="card-text">${product.productDescription}</h6>
								</div>
								<div class="card-footer">
									<a
										href="<%=request.getContextPath()%>/product/${product.productId}"><button
											type="button" class="btn btn-primary">Details</button></a> <a
										href="<%=request.getContextPath()%>/cart/${product.productId}"><button
											type="button" class="btn btn-warning">Order Now</button></a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- /.row -->
			<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:forEach items="${productPageDto.pageDto.listPage}" var="number">
					<li class="page-item"><a class="page-link"
						href="product-list?currentPage=${number}">${number}</a></li>
				</c:forEach>
			</ul>
			</nav>
		</div>
		<!-- /.col-lg-9 -->
	</div>
</body>
</html>