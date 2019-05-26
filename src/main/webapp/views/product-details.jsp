<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Details</title>
</head>
<body>
	<div class="container" style="padding-top: 50px">
		<div class="my-3 col-md-11">
			<h1>PRODUCTS</h1>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-5">
				<a href="#"><img class="card-img-top"
					src="data:image/png;base64,${product.base64Image}"
					alt="Image not found"></a>
			</div>
			<div class="col-md-7">
				<h5 class="card-title">${product.productName}</h5>
				<p class="card-text">${product.productDescription}</p>
				<ul>
					<li>Item Code: <span>${product.productId}</span></li>
					<li>Manufacture: <span>${manufacture.manufactureName}</span></li>
					<li>Category: <span>${category.categoryName}</span></li>
					<li>Available units in stock: <span>${product.unitInStock}</span></li>
				</ul>
				<h5>$${product.unitPrice}</h5>
				<a href="<%=request.getContextPath()%>/product-list"><button
						type="button" class="btn btn-primary")" >Back</button></a> <a
					href="<%=request.getContextPath()%>/cart/${product.productId}"><button
						type="button" class="btn btn-warning">Order Now</button></a>
			</div>
		</div>

	</div>

</body>
</html>