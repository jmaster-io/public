<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Shop Homepage</title>
<!-- Bootstrap core CSS -->
<link href="/finalweb10/style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/finalweb10/style/client/shop-homepage.css" rel="stylesheet">
</head>
<body>
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="list-group">
					<jsp:include page="/views/client/common/menu.jsp"></jsp:include>
				</div>
			</div>
			<!-- /.col-lg-3 -->
			<div class="col-lg-9">
				<h1>DANH SACH SAN PHAM</h1>
				<div class="row">
					<c:forEach items="${pList}" var="p">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="/finalweb10/client/product/detail?id=${p.id}"> <img class="card-img-top" src="/finalweb10/download?image=${p.image}" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="/finalweb10/client/product/detail?id=${p.id}">${p.name}</a>
									</h4>
									<h5>${p.price}</h5>
									<p class="card-text">${p.description}</p>
								</div>
								<div class="card-footer">
									<a href="/finalweb10/add-to-cart?pid=${p.id }" class="btn btn-danger">Add to cart</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->
	<jsp:include page="/views/client/common/footer.jsp"></jsp:include>
</body>
</html>
