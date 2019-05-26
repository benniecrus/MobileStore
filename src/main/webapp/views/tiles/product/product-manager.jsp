<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="content-body">
			<div class="menu-button">
				<a href="initAddProduct" class="btn btn-success float-right">Add
					New Product</a>
			</div>
			<div class="menu-button">
				<a href="<%=request.getContextPath()%>/product-list"
					class="btn btn-success float-right" style="margin-right: 10px">Home</a>
			</div>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Product Name</th>
							<th>Unit In Stock</th>
							<th>Unit Price</th>
							<th>Manufacture</th>
							<th>Category</th>
							<th>Status</th>
							<th>Options</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productList}" var="product" varStatus="loop">
							<tr>
								<td>${loop.index+1}</td>
								<td>${product.productName}</td>
								<td>${product.unitInStock}</td>
								<td>${product.unitPrice}</td>
								<td>${product.manufacture.manufactureName}</td>
								<td>${product.category.categoryName}</td>
								<c:choose>
									<c:when test="${product.deleteFlag == true}">
										<td>In-active</td>
										<td><a
											href="initEditProduct?productId=${product.productId}">Edit</a>
											| <a
											href="activeProduct?productId=${product.productId}&deleteFlag=false"
											onclick="return confirm('Are you sure active this product?')">Active</a></td>
									</c:when>
									<c:when test="${product.deleteFlag == false}">
										<td>Active</td>
										<td><a
											href="initEditProduct?productId=${product.productId}">Edit</a>
											| <a
											href="activeProduct?productId=${product.productId}&deleteFlag=true"
											onclick="return confirm('Are you sure in-active this product?')">In-active</a></td>
									</c:when>
									<c:otherwise>
										<td>N/A</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>