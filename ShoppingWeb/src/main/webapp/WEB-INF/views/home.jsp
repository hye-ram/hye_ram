<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

<title>Hye-Ram</title>

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
<script scr="//cdn.ckeditor.com/4.8.0/standard/ckeditor.js"></script>
</head>

<body class="main_page">
	<div class="hero_area">
		<!-- header section strats -->
		<div class="brand_box">
			<a class="navbar-brand" href="home"> <span> <!-- 사이트 제목 -->
					Hye-Ram
			</span>
			</a>
			<div class="icon-set">
				<ul class="top-set">
					<c:choose>
						<c:when test="${empty sessionScope.userId}">
							<li><a class="top-set-li" href="login">login</a></li>
							<li><a class="top-set-li" href="join">join</a></li>
							<li><a class="top-set-li" href="cart"><i
									class="fas fa-shopping-cart"></i></a></li>
						</c:when>
						<c:otherwise>
							<li class="top-set-li-id">${sessionScope.userId}님</li>
							<li><a class="top-set-li" href="${path}/shoppingweb/mypage">mypage</a></li>
							<li><a class="top-set-li" href="logout">logout</a></li>
							<li><a class="top-set-li" href="cart"><i
									class="fas fa-shopping-cart"></i></a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>

	<!-- slider section -->
	<section class=" slider_section position-relative">
		<div id="carouselExampleControls" class="carousel slide "
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="img-box">
						<img src="resources/images/new-slider-img.jpg" alt="">
					</div>
				</div>
				<div class="carousel-item">
					<div class="img-box">
						<img src="resources/images/new-slider-img.jpg" alt="">
					</div>
				</div>
				<div class="carousel-item">
					<div class="img-box">
						<img src="resources/images/new-slider-img.jpg" alt="">
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev"> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span class="sr-only">Next</span>
			</a>

			<!-- end slider section -->
		</div>
		<!-- nav section -->

		<section class="nav_section">
			<div class="container">
				<div class="custom_nav2">
					<nav class="navbar navbar-expand custom_nav-container ">
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>

						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<div class="d-flex  flex-column flex-lg-row align-items-center">
								<ul class="navbar-nav  ">
									<li class="nav-item active"><a class="nav-link"
										href="home">Home <span class="sr-only">(current)</span>
									</a></li>
									<li class="nav-item"><a class="nav-link" href="clothes">Clothes
									</a></li>
									<li class="nav-item"><a class="nav-link" href="review">Review
									</a></li>
									<li class="nav-item"><a class="nav-link" href="notice">Notice</a>
									</li>
									<li class="nav-item"><a class="nav-link" href="qna">QnA</a>
									</li>
									<li class="nav-item"><a class="nav-link" href="search"><i
											class="fas fa-search"> _________</i></a></li>
								</ul>
							</div>
						</div>
					</nav>
				</div>
			</div>
		</section>

		<!-- end nav section -->

		<!-- shop section -->
		<section class="shop_section layout_padding">
			<div class="container">
				<div class="box">
					<div class="detail-box">
						<h2>NEW ARRIVAL</h2>
						<p>365일 매일매일 신상을 만나보세요!</p>
					</div>
					<div class="img-box">
						<img src="resources/images/testproduct.jpg" alt=""> <img
							src="resources/images/testproduct.jpg" alt=""> <img
							src="resources/images/testproduct.jpg" alt="">
					</div>
					<div class="btn-box">
						<a href="clothes"> VIEW MORE </a>
					</div>

				</div>
			</div>
		</section>


		<!-- end shop section -->
		<!-- about section -->

		<section class="about_section">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6 px-0">
						<div class="img-box">
							<img src="resources/images/summersale.jpg" alt="">
						</div>
					</div>
					<div class="col-md-5">
						<div class="detail-box">
							<div class="heading_container">
								<hr>
								<h2>OUR SPECIAL BENEFITS</h2>
							</div>
							<p>오직 hye-ram만의 특별한 혜택 <br>놓치지 마세요</p>
							<a href="notice"> Read More </a>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- end about section -->

		<!-- cate section -->

		<section class="fruit_section layout_padding">
			<div class="container">
				<div class="heading_container">
					<hr>
					<h2>CATEGORY</h2>
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
						<img src="resources/images/innerwear.jpg" alt="">
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



		<!-- review section -->

		<section class="client_section layout_padding-bottom">
			<div class="container ">
				<div class="heading_container">
					<h2>NEW REVIEW!</h2>
					<hr>
				</div>
				<div id="carouselExample2Controls" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<c:forEach var="row" items="${review}" begin="0" end="0">
							<div class="carousel-item active">
								<div class="client_container layout_padding-top">
									<div class="img-box">
										<img src="resources/images/${row.picture_url}" alt="">
									</div>
									<div class="detail-box">
										<h5>${row.writer}</h5>
										<p>
											<img src="resources/images/left-quote.png" alt=""> <span>
												${row.product_name} </span> <img
												src="resources/images/right-quote.png" alt=""> <br>
											${row.editor}
										</p>
									</div>
								</div>
							</div>
						</c:forEach>

						<c:forEach var="row" items="${review}" begin="1" end="4">
							<div class="carousel-item">
								<div class="client_container layout_padding-top">
									<div class="img-box">
										<img src="resources/images/${row.picture_url}" alt="">
									</div>
									<div class="detail-box">
										<h5>${row.writer}</h5>
										<p>
											<img src="resources/images/left-quote.png" alt=""> <span>
												${row.product_name} </span> <img
												src="resources/images/right-quote.png" alt=""> <br>
											${row.editor}
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>

					<a class="carousel-control-prev" href="#carouselExample2Controls"
						role="button" data-slide="prev"> <span class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExample2Controls"
						role="button" data-slide="next"> <span class="sr-only">Next</span>
					</a>
				</div>

			</div>
		</section>



		<tr>
			<td><jsp:include page="bottom.jsp" flush="false" /></td>
		</tr>

		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="resources/js/bootstrap.js"></script>
		<script type="text/javascript" src="resources/js/custom.js"></script>
		<script src="https://code.jquery.com/jquery-3.5.1.js"
			integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
			crossorigin="anonymous"></script>
</body>

</html>