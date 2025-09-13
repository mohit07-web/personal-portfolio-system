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

<title>Admin - Read Contacts</title>
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
					<h1 class="text-center mb-4 text-uppercase">Read All Contacts</h1>

					<div class="text-center mb-3">
						<a class="primary_btn mr-2"
							href="${pageContext.request.contextPath}/client/home">Client
							Home</a> <a class="primary_btn"
							href="${pageContext.request.contextPath}/admin/home">Admin
							Home</a>
					</div>

					<!-- Table for contacts -->
					<div class="table-responsive">
						<table class="table table-bordered table-striped">
							<thead class="bg-secondary">
								<tr class="text-dark">
									<th>ID</th>
									<th>Name</th>
									<th>Subject</th>
									<th>Message</th>
									<th>Date & Time</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="contact" items="${contactData}">
									<tr>
										<td>${contact.id}</td>
										<td>${contact.name}</td>
										<td>${contact.subject}</td>
										<td>${contact.message}</td>
										<td>${contact.datetime}</td>
										<td><a class="btn btn-sm btn-danger"
											href="${pageContext.request.contextPath}/admin/deleteContactById?id=${contact.id}">
												Delete </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
	</section>

</body>
</html>
