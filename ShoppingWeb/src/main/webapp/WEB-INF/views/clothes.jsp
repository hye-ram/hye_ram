<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<!-- Basic -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Site Metas -->
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />

<title>카테고리 - Hye-Ram</title>

<!-- slider stylesheet -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />

<!-- bootstrap core css -->
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css" />

<!-- fonts style -->
<link
	href="https://fonts.googleapis.com/css?family=Baloo+Chettan|Dosis:400,600,700|Poppins:400,600,700&display=swap"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="resources/css/style.css" rel="stylesheet" />
<!-- responsive style -->
<link href="resources/css/responsive.css" rel="stylesheet" />

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
</head>

<body class="sub_page">
	<tr>
		<td><jsp:include page="top.jsp" flush="false" /></td>
	</tr>

	<!-- fruit section -->

	<section class="fruit_section layout_padding">
		<div class="container">
			<div class="heading_container">
				<hr>
				<h2>Shop by clothes</h2>
			</div>
		</div>
		<div class="container-fluid">

			<div class="fruit_container">
				<div class="box">
					<img src="resources/images/top.jfif" alt="">
					<div class="link_box">
						<h5>Tops</h5>
						<a href="product_list?cate01=001"> View </a>
					</div>
				</div>
				<div class="box">
					<img src="resources/images/outer.jfif" alt="">
					<div class="link_box">
						<h5>Outers</h5>
						<a href="product_list?cate01=002"> View </a>
					</div>
				</div>
				<div class="box">
					<img src="resources/images/dress.jfif" alt="">
					<div class="link_box">
						<h5>Dresses</h5>
						<a href="product_list?cate01=003"> View </a>
					</div>
				</div>
				<div class="box">
					<img src="resources/images/bottom.jfif" alt="">
					<div class="link_box">
						<h5>Bottoms</h5>
						<a href="product_list?cate01=004"> View </a>
					</div>
				</div>
				<div class="box">
					<img src="resources/images/dress.jfif" alt="">
					<div class="link_box">
						<h5>Inner wear</h5>
						<a href="product_list?cate01=005"> View </a>
					</div>
				</div>
				<div class="box">
					<img src="resources/images/acc.jfif" alt="">
					<div class="link_box">
						<h5>etc.</h5>
						<a href="product_list?cate01=006"> View </a>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- end fruit section -->


	<!-- info section -->

	<section class="info_section layout_padding">
		<div class="container">
			<div class="info_logo">
				<h2>Hye-Ram</h2>
			</div>
			<div class="info_contact">
				<div class="row">
					<div class="col-md-4">
						<a href=""> <img src="resources/images/location.png" alt="">
							<span> Passages of Lorem Ipsum available </span>
						</a>
					</div>
					<div class="col-md-4">
						<a href=""> <img src="resources/images/call.png" alt="">
							<span> Call : +012334567890 </span>
						</a>
					</div>
					<div class="col-md-4">
						<a href=""> <img src="resources/images/mail.png" alt="">
							<span> demo@gmail.com </span>
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 col-lg-9">
					<div class="info_form">
						<form action="">
							<input type="text" placeholder="Enter your email">
							<button>subscribe</button>
						</form>
					</div>
				</div>
				<div class="col-md-4 col-lg-3">
					<div class="info_social">
						<div>
							<a href=""> <img
								src="resources/images/facebook-logo-button.png" alt="">
							</a>
						</div>
						<div>
							<a href=""> <img
								src="resources/images/twitter-logo-button.png" alt="">
							</a>
						</div>
						<div>
							<a href=""> <img src="resources/images/linkedin.png" alt="">
							</a>
						</div>
						<div>
							<a href=""> <img src="resources/images/instagram.png" alt="">
							</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>

	<!-- end info section -->


	<!-- footer section -->
	<section class="container-fluid footer_section">
		<p>
			&copy; <span id="displayYear"></span> All Rights Reserved By <a
				href="https://html.design/">Free Html Templates</a>
		</p>
	</section>
	<!-- footer section -->


	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>

</body>

</html>