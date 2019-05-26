<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron" style="margin-bottom: 0px;">
		<div class="container">
			<a href="product-list" class="btn btn-primary">Back to home page</a>
			<div class="d-inline-flex float-right align-text-top">
				<sec:authorize var="loggedInAdmin" ifAnyGranted="ROLE_ADMIN" />
				<sec:authorize var="loggedInStaff" ifAnyGranted="ROLE_STAFF" />
				<a href="<%=request.getContextPath()%>/cart/0"
					class="btn btn-primary" style="margin-right: 10px">View Cart (<c:choose>
						<c:when test="${sessionScope.cart.size() != null}">
						${sessionScope.cart.size()}
						</c:when>
						<c:otherwise>0</c:otherwise>
					</c:choose>)
				</a>
				<div class="dropdown">
					<c:choose>
						<c:when test="${loggedInAdmin}">
							<button type="button" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown">Menu</button>
						</c:when>
						<c:otherwise>
							<a href="<%=request.getContextPath()%>/login"
								class="btn btn-primary">Login</a>
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
			<div>
				<h1>Mobile Store</h1>
			</div>
		</div>
	</div>
</body>
</html>