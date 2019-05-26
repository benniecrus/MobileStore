<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>Orders</title>
</head>
<body>
	<%
	  int i = 1;
	%>
	<div class="container">
		<div class="content-body">
			<div class="menu-button">
				<a href="<%=request.getContextPath()%>/product-list"
					class="btn btn-success float-right">Produc List</a>
			</div>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<td>#</td>
							<td>Order ID</td>
							<td>Order Date</td>
							<td>Status</td>
							<td>Customer</td>
							<td>Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listOfOrder}" var="order">
							<tr>
								<td><%=i++%></td>
								<td>${order.orderId}</td>
								<td><fmt:formatDate type="both" dateStyle="short"
										timeStyle="short" value="${order.orderDate}" /></td>
								<td>${order.status}</td>
								<td>${order.customer.customerName}</td>
								<c:if test="${order.deleteFlag == '0'}">
									<td><a
										href="<%=request.getContextPath()%>/remove-order/${order.orderId}">In-active</a></td>
								</c:if>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
