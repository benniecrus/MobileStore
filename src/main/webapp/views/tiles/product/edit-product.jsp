<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#form-row{
  	width: 80%;
  }
  #form-title{
  	float: left;
  }
</style>
</head>
<body>

	<div class="container">
		<div class="my-3 row">
			<div class="col-md-10">
				<h3>Edit Product</h3>
			</div>
			<div class="col-md-2" style="margin-top: 10px">
				<a href="<%=request.getContextPath()%>/product-list"><button
						type="button" class="btn btn-primary">Log Out</button></a>
			</div>
		</div>
		<hr>
		<div class="content-body">
			<form action="editProduct" id="form-add-product"
				enctype="multipart/form-data" method="post">
				<input type="hidden" name="productId" value="${product.productId}">
				<div class="form-group d-inline-flex" id="form-row">
					<label class="col-sm-3 text-right">Product Name</label> <input
						class="form-control col-sm-6" id="productName"
						placeholder="Enter product name" name="productName" value="${product.productName}">
				</div>
				<br>																	
				<div class="form-group d-inline-flex" id="form-row">
					<label class="col-sm-3 text-right">Unit Price</label> <input
						class="form-control col-sm-6" id="unitPrice"
						placeholder="Enter product name" name="unitPrice" value="${product.unitPrice}">
				</div>
				<br>
				<div class="form-group d-inline-flex" id="form-row">
					<label class="col-sm-3 text-right">Unit In Stock</label> <input
						class="form-control col-sm-6" id="unitInStock"
						placeholder="Enter product name" name="unitInStock" value="${product.unitInStock}">
				</div>
				<br>
				<div class="form-group d-inline-flex" id="form-row">
					<label class="col-sm-3 text-right">Description</label>
					<textarea class="form-control col-sm-6" id="productDescription"
						placeholder="Enter product description" name="productDescription">${product.productDescription}</textarea>
				</div>
				<br>
				<div class="form-group d-inline-flex" id="form-row">
					<label class="col-sm-3 text-right">Manufacture</label> <select
						class="form-control col-sm-6" name="manufactureId"
						id="manufactureId">
						<c:forEach items="${manufactures}" var="manufacture">
							<c:set var="manufactureId" value="${product.manufacture.manufactureId}"/>
							<c:choose>
								<c:when test="${manufacture.manufactureId == manufactureId}">
									<option value="${manufacture.manufactureId}" selected="selected">${manufacture.manufactureName}</option>
								</c:when>
								<c:otherwise>
									<option value="${manufacture.manufactureId}">${manufacture.manufactureName}</option>
								</c:otherwise>
								</c:choose>
						</c:forEach>
					</select>
				</div>
				<br>
				<div class="form-group d-inline-flex" id="form-row">
					<label class="col-sm-3 text-right">Category</label> <select
						class="form-control col-sm-6" name="categoryId" id="categoryId">
						<c:forEach items="${categories}" var="category">
							<c:set var="categoryId" value="${product.category.categoryId}"/>
							<c:choose>
								<c:when test="${category.categoryId == categoryId}">
									<option value="${category.categoryId}" selected="selected">${category.categoryName}</option>
								</c:when>
								<c:otherwise>
									<option value="${category.categoryId}">${category.categoryName}</option>
								</c:otherwise>
								</c:choose>
						</c:forEach>
						
					</select>
				</div>
				<br>
				<div class="form-group d-inline-flex" id="form-row">
					<label class="col-sm-3 text-right">Condition</label>
					<div class="col-sm-6 d-inline-flex">
						<div class="radio">
							<label style="margin: 0px 5px;"><input type="radio"
								name="condition" checked value="1">New</label>
						</div>
						<div class="radio">
							<label style="margin: 0px 5px;"><input type="radio"
								name="condition" value="2">Old</label>
						</div>
						<div class="radio">
							<label style="margin: 0px 5px;"><input type="radio"
								name="condition" value="3">Refurbished</label>
						</div>
					</div>
				</div>
				<br>
				<div class="form-group d-inline-flex" id="form-row">
					<label class="col-sm-3 text-right"></label> <img
								src="data:image/png;base64,${product.base64Image}"
								alt="Image not found" width="70" height="70">
				</div>
				<div class="form-group d-inline-flex" id="form-row">
					<label class="col-sm-3 text-right">Product Image File</label> <input
						type="file" class="form-control-file col-sm-6" name="file">
				</div>
				<br>
				<div class="text-center col-sm-9">
					<button type="submit" class="btn btn-primary text-center"
						id="btn-add-product">Edit Product</button>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#form-add-product").validate({
			rules:{
				productName:{
					required: true
				},
				unitPrice:{
					required: true
				},
				unitInStock:{
					required: true
				},
				description:{
					required: true
				}
			},
			message:{
				productName:{
					required: "Product Name can not empty"
				},
				unitPrice:{
					required: "unitPrice can not empty"
				},
				unitInStock:{
					required: "unit in stock can not empty"
				},
				description:{
					required: "description can not empty"
				}
			}
			
		}),
		
		$("#btn-add-product").click(function(){
			if($("#form-add-product").valid()){
				$("#form-add-product").submit();
			}
		});
		
	});
</script>

</html>