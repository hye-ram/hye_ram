<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>

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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<title>로그인 - Hye-Ram</title>

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
	<div class="hero_area">
		<!-- header section strats -->
		<div class="brand_box"
			style="background-image: url('resources/images/sub-top.jpg');">
			<a class="navbar-brand" href="home"> <span> Hye-Ram </span>
			</a>
			<div class="icon-set">
				<ul class="top-set">
					<li><a class="top-set-li" href="login">login</a></li>
					<li><a class="top-set-li" href="join">join</a></li>
					<li><a class="top-set-li" href="cart"><i
							class="fas fa-shopping-cart"></i></a></li>
				</ul>
			</div>
		</div>
		<!-- end header section -->
	</div>

	<!-- nav section -->

	<section class="nav_section">
		<div class="container">
			<div class="custom_nav2">
				<nav class="navbar navbar-expand custom_nav-container ">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<div class="d-flex  flex-column flex-lg-row align-items-center">
							<ul class="navbar-nav  ">
								<li class="nav-item active"><a class="nav-link" href="home">Home
										<span class="sr-only">(current)</span>
								</a></li>
								<li class="nav-item"><a class="nav-link" href="clothes">Clothes
								</a></li>
								<li class="nav-item"><a class="nav-link" href="review">Review
								</a></li>
								<li class="nav-item"><a class="nav-link" href="notice">Notice</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="qna">QnA</a>
								</li>
							</ul>
							<form class="form-inline my-2 my-lg-0 ml-0 ml-lg-4 mb-3 mb-lg-0">
								<button class="btn  my-2 my-sm-0 nav_search-btn" type="submit"></button>
							</form>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</section>

	<!-- end nav section -->
	<h1>로그인 페이지</h1>
	<hr />
	<c:choose>
		<c:when test="${empty sessionScope.userId}">
			<!-- 로그인이 안되어 있으면 -->
			<form id="loginFrm" name="loginFrm" action="loginCheck" href="home">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userId" id="userId"
							placeholder="10글자" maxlength="10"></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input type="password" name="userPw" id="userPw"
							maxlength="20"></td>
					</tr>
					<c:if test="${msg == '실패'}">
						<tr>
							<td colspan=2>아이디 또는 패스워드가 틀렸습니다.
							   
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan=2><input type="button" id="login" value="로그인" />
						</td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<h3>${sessionScope.userId}님환영합니다.</h3>
			<a href="logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	<!-- info section -->

	<section class="info_section layout_padding">
		<div class="container">
			<div class="info_logo">
				<h2>NiNom</h2>
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
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(e) {
			$('#login').click(function() {
				// 입력 값 체크
				if ($.trim($('#userId').val()) == '') {
					alert("아이디를 입력해 주세요.");
					$('#userId').focus();
					return;
				} else if ($.trim($('#userPw').val()) == '') {
					ㅣ
					alert("패스워드를 입력해 주세요.");
					$('#userPw').focus();
					return;
				}
				//전송
				$('#loginFrm').submit();
				//화면 이동
			});
		});
	</script>

</body>

</html>