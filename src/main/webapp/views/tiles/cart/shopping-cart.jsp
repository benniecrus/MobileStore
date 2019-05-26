<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
	  int i = 1;
	%>
	<div class="container">
		<div class="content-body">
			<div class="menu-button">
				<a href="<%=request.getContextPath()%>/clear-cart"
					class="btn btn-danger">Clear Cart</a>
				<button type="button" class="btn btn-success float-right"
					data-toggle="modal" data-target="#myModal">Checkout</button>
			</div>
			<form action="<%=request.getContextPath()%>/cart/update"
				method="post" id="form-cart">
				<div class="table-responsive">
					<c:choose>
						<c:when test="${listOfOrderDetail != null}">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>Product</th>
										<th>Image</th>
										<th>Quantity</th>
										<th>Unit Price</th>
										<th>Price</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${listOfOrderDetail}" var="orderDetail">
										<tr>
											<td><%=i%></td>
											<td>${orderDetail.product.productName}</td>
											<td><img
												src="data:image/png;base64,${orderDetail.product.base64Image}"
												alt="Image not found" width="150" height="150"></td>
											<td><input type="number"
												name="product[${orderDetail.product.productId}]"
												value="${orderDetail.quantity}"></input></td>
											<td>$${orderDetail.product.unitPrice}</td>
											<td>$${orderDetail.product.unitPrice *
												orderDetail.quantity}</td>
											<td><a
												href="<%=request.getContextPath()%>/remove-product-cart/<%=i++%>"
												class="btn btn-danger">Remove</a></td>
										</tr>
									</c:forEach>
								</tbody>

								<thead>
									<tr>
										<th>Total Price</th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
										<th>$${totalPrice}</th>
									</tr>

								</thead>
							</table>
						</c:when>
						<c:otherwise>
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>Product</th>
										<th>Image</th>
										<th>Quantity</th>
										<th>Unit Price</th>
										<th>Price</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>NO ITEM SELECTED.</th>
									</tr>
								</tbody>
							</table>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="d-inline-flex">
					<div class="bottom-button" style="margin-right: 10px">
						<a href="<%=request.getContextPath()%>/product-list"
							class="btn btn-success">Continue shopping</a>
					</div>
					<div></div>
					<div class="bottom-button">
						<button type="submit" class="btn btn-success">Update
							product</button>
					</div>
				</div>
			</form>
		</div>


		<!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Customer information</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<form action="<%=request.getContextPath()%>/check-out"
						method="post">
						<!-- Modal body -->
						<div class="form-group d-inline-flex" id="form-row">
							<label class="col-sm-3 text-right">Customer name</label> <input
								class="form-control col-sm-6" id="customerName"
								name="customerName">
						</div>
						<!-- Modal body -->
						<div class="form-group d-inline-flex" id="form-row">
							<label class="col-sm-3 text-right">Address</label> <input
								class="form-control col-sm-6" id="address" name="address">
						</div>
						<div class="form-group d-inline-flex" id="form-row">
							<label class="col-sm-3 text-right">Phone Number</label> <input
								class="form-control col-sm-6" id="phoneNumber"
								name="phoneNumber">
						</div>

						<!-- Modal footer -->

						<div class="modal-footer">
							<button class="btn btn-success" type="submit">Save</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#form-cart").validate({
				rules : {
					customerName : {
						required : true
					},
					address : {
						required : true
					},
					phoneNumber : {
						required : true
					}
				},
				message : {
					customerName : {
						required : "Product Name can not empty"
					},
					address : {
						required : "unitPrice can not empty"
					},
					phoneNumber : {
						required : "unit in stock can not empty"
					}
				}

			})
		});
	</script>
</body>
</html>