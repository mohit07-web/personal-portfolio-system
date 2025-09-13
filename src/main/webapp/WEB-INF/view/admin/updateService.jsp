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

<title>Admin - Update Service</title>
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
		<div class="banner_inner">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-8">
						<div class="banner_content text-center">
							<h1 class="text-uppercase mb-4">Update Service</h1>

							<!-- Navigation Buttons -->
							<div class="d-flex justify-content-center mb-4">
								<a class="primary_btn mr-2"
									href="${pageContext.request.contextPath}/client/home">Client
									Home</a>
								<a class="primary_btn"
									href="${pageContext.request.contextPath}/admin/home">Admin
									Home</a>
							</div>

							<!-- Form Card -->
							<div class="card p-4 shadow">
								<form action="${pageContext.request.contextPath}/admin/updateService"
								      method="post" enctype="multipart/form-data">

									<!-- Hidden Fields -->
									<input type="hidden" name="id" value="${serviceData.id}">
									<input type="hidden" name="oldFileName" value="${serviceData.filename}">

									<!-- Title -->
									<div class="form-group">
										<label>Title</label>
										<input type="text" name="title" class="form-control"
											value="${serviceData.title}" placeholder="Enter service title">
									</div>

									<!-- Description -->
									<div class="form-group">
										<label>Description</label>
										<textarea name="description" rows="4" class="form-control"
											placeholder="Enter service description">${serviceData.description}</textarea>
									</div>

									<!-- File Upload -->
									<div class="form-group">
										<small class="d-block mb-2">Current: 
											<img src="${pageContext.request.contextPath}/img/services/${serviceData.filename}" 
											     alt="Service Image" style="width:80px; height:auto; border:1px solid #ddd; padding:2px;">
										</small>
										<input type="file" name="serviceFile" class="form-control-file">
									</div>

									<!-- Submit -->
									<div class="text-center">
										<button type="submit" class="btn btn-primary px-4">Save Changes</button>
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>
