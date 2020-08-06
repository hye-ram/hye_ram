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

<title>검색 - Hye-Ram</title>

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
							<ul class="navbar-nav">
								<li class="nav-item active"><input type="text"
									id="search_Term"> <input type="button" value="검색"
									id="search_btn"></li>
							</ul>
						</div>
					</div>
					<div id="endSearch"><i class="fas fa-times"></i></div>
				</nav>
			</div>
		</div>
	</section>


	<c:choose>
		<c:when test="${empty search_result}">
			<div id="search_fail" style="height: 500px;">검색어를 입력해 주세요!</div>
		</c:when>
		<c:otherwise>
			<div id="product_list">
				<c:forEach var="row" items="${search_result}">
					<div id="product_box">
						<div id="goDetail">
							<img src="resources/images/${row.picture_url}">
						</div>
						<div>${row.product_name}</div>
						<div>
							<fmt:formatNumber value="${row.price}" pattern="#,###" />
						</div>
						<input type="hidden" id="product_id" name="product_id"
							value="${row.product_id}">
					</div>
				</c:forEach>
			</div>

		</c:otherwise>
	</c:choose>

	<tr>
		<td><jsp:include page="bottom.jsp" flush="false" /></td>
	</tr>

	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(e) {
			$('#search_btn').click(function() {
				var url = "goSearch?search_Term=" + $('#search_Term').val();
				window.location.replace(url);
			});
			$('#search_Term').keypress(function(event) {
				if (event.which == 13) {
					$('#search_btn').click();
					return false;
				}
			});
			$('#endSearch').click(function() {
				window.history.back();
			});
			
		});
	</script>
</body>
</html>