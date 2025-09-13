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

<title>Admin - Upload Resume</title>
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
							<h1 class="text-uppercase mb-4">Upload Resume</h1>

							<!-- Navigation Buttons -->
							<div class="d-flex justify-content-center mb-4">
								<a class="primary_btn mr-2"
									href="${pageContext.request.contextPath}/client/home">Client
									Home</a>
								<a class="primary_btn"
									href="${pageContext.request.contextPath}/admin/home">Admin
									Home</a>
							</div>

							<!-- Backend message -->
							<c:if test="${not empty result}">
								<div class="alert alert-info text-center">${result}</div>
							</c:if>

							<!-- Card Form -->
							<div class="card p-4 shadow">
								<form action="${pageContext.request.contextPath}/admin/uploadResume" 
								      method="post" enctype="multipart/form-data">

									<!-- Resume Upload -->
									<div class="form-group">
										<label>Select Resume File</label>
										<input type="file" name="resume" class="form-control-file">
									</div>

									<!-- Submit -->
									<div class="text-center">
										<button type="submit" class="btn btn-success px-4">Upload</button>
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
