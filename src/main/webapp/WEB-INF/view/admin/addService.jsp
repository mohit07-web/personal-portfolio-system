<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon"
	href="${pageContext.request.contextPath}/img/favicon.png"
	type="image/png">

<title>Admin - Add Service</title>
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
				<div class="col-lg-8 offset-lg-2">
					<h1 class="text-center mb-4 text-uppercase">Add Service</h1>

					<div class="text-center mb-3">
						<a class="primary_btn mr-2"
							href="${pageContext.request.contextPath}/client/home">Client
							Home</a>
						<a class="primary_btn"
							href="${pageContext.request.contextPath}/admin/home">Admin
							Home</a>
					</div>

					<!-- result messages -->
					<c:if test="${not empty result}">
						<div class="alert alert-info text-center">${result}</div>
					</c:if>

					<div class="card p-4 shadow">
						<form action="${pageContext.request.contextPath}/admin/addService" 
						      method="post" enctype="multipart/form-data">

							<!-- Title -->
							<div class="form-group">
								<label>Title</label>
								<input type="text" name="title" class="form-control"
									placeholder="Enter service title">
								<small class="text-danger">
									<c:forEach var="err" items="${errors}">
										<c:if test="${err.field=='title'}">${err.defaultMessage}</c:if>
									</c:forEach>
								</small>
							</div>

							<!-- Description -->
							<div class="form-group">
								<label>Description</label>
								<textarea name="description" rows="4" class="form-control"
									placeholder="Enter service description"></textarea>
								<small class="text-danger">
									<c:forEach var="err" items="${errors}">
										<c:if test="${err.field=='description'}">${err.defaultMessage}</c:if>
									</c:forEach>
								</small>
							</div>

							<!-- File Upload -->
							<div class="form-group">
								<label>Upload Service Image</label>
								<input type="file" name="serviceFile" class="form-control-file">
								<c:if test="${not empty fileError}">
									<small class="text-danger">${fileError}</small>
								</c:if>
							</div>

							<!-- Submit -->
							<div class="text-center">
								<button type="submit" class="btn btn-success px-4">Save</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</section>

</body>
</html>
