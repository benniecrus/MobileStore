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
<title>Order Information</title>
</head>
<body>
	<%
	  int i = 1;
	%>
	<div class=" container">
		<div class="my-3 row">
			<div class="col-md-10">
				<h1>ORDER INFORMATION</h1>
			</div>
		</div>
		<div class="menu-button">
			<a href="<%=request.getContextPath()%>/product-list"
				class="btn btn-success float-right">Continue Shopping</a>
		</div>
		<hr>
		<div class="col-lg-12">
			<div>
				Name: <b>${customer.customerName}</b>
			</div>
			<div>
				Address: <b>${customer.address}</b>
			</div>
			<div>
				Phone: <b>${customer.phoneNumber}</b>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Product</th>
					<th>Quantity</th>
					<th>Unit Price</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listOfOrderDetail}" var="orderDetail">
					<tr>
						<td><%=i%></td>
						<td>${orderDetail.product.productName}</td>
						<td>${orderDetail.quantity}</td>
						<td>$${orderDetail.product.unitPrice}</td>
						<td>$${orderDetail.product.unitPrice * orderDetail.quantity}</td>
					</tr>
				</c:forEach>
			</tbody>
			<thead>
				<tr>
					<th>Total Price</th>
					<th></th>
					<th></th>
					<th></th>
					<th>$${totalPrice}</th>
				</tr>
			</thead>
		</table>
		<label>Thank you so much!</label>
	</div>
</body>
</html>