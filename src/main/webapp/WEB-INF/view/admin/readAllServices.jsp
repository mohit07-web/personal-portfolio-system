<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon"
	href="${pageContext.request.contextPath}/img/favicon.png"
	type="image/png">

<title>Admin - Read Services</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/vendors/linericon/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/vendors/owl-carousel/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/magnific-popup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/vendors/nice-select/css/nice-select.css">
<!-- main css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<section class="home_banner_area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="text-center mb-4 text-uppercase">Read All Services</h1>

					<div class="text-center mb-3">
						<a class="primary_btn mr-2"
							href="${pageContext.request.contextPath}/client/home">Client
							Home</a>
						<a class="primary_btn"
							href="${pageContext.request.contextPath}/admin/home">Admin
							Home</a>
					</div>

					<div class="row">
						<c:forEach var="service" items="${listOfServices}">
							<div class="col-md-4 mb-4">
								<div class="card h-100 shadow-sm">
									<img class="card-img-top"
										src="${pageContext.request.contextPath}/img/services/${service.filename}"
										alt="${service.title}">
									<div class="card-body">
										<h5 class="card-title text-uppercase">${service.title}</h5>
										<p class="card-text">${service.description}</p>
									</div>
									<div class="card-footer text-center">
										<a href="${pageContext.request.contextPath}/admin/updateService?id=${service.id}"
											class="btn btn-sm btn-primary mr-2">Update</a>
										<a href="${pageContext.request.contextPath}/admin/deleteService?id=${service.id}&filename=${service.filename}"
											class="btn btn-sm btn-danger">Delete</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>

				</div>
			</div>
		</div>
	</section>

</body>
</html>
