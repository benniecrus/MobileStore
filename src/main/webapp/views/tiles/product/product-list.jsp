<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
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
							<h4 class="card-title text-center">
								<a href="#">${product.productName}</a>
							</h4>
							<h5 class="text-center">$${product.unitPrice}</h5>
							<div class="card-body text-center">
								<h6 class="card-text">${product.productDescription}</h6>
							</div>
							<div class="card-footer">
								<a
									href="<%=request.getContextPath()%>/product/${product.productId}"><button
										type="button" class="btn btn-primary">Details</button></a> <a
									href="<%=request.getContextPath()%>/cart/${product.productId}"><button
										type="button" class="btn btn-warning">Add to cart</button></a>
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
</body>
</html>