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
		<c:choose>
			<c:when test="${empty sessionScope.userId}">
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
			</c:when>
			<c:otherwise>
				<div class="brand_box"
					style="background-image: url('resources/images/sub-top.jpg');">
					<a class="navbar-brand" href="home"> <span> Hye-Ram </span>
					</a>
					<div class="icon-set">
						<ul class="top-set">
							<li class="top-set-li-id">${sessionScope.userId}님</li>
							<li><a class="top-set-li" href="mypage">mypage</a></li>
							<li><a class="top-set-li" href="logout">logout</a></li>
							<li><a class="top-set-li" href="cart"><i
									class="fas fa-shopping-cart"></i></a></li>
						</ul>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
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
							<ul class="navbar-nav">
								<li class="nav-item active"><input type="text"
									id="search_Term"> <input type="button" value="검색"
									id="search_btn"></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</section>


	<c:choose>

		<c:when test="${empty search_result}">
			<div id="search_fail" style="height: 500px;"> 검색어를 입력해 주세요! </div>
		</c:when>
		<c:otherwise>
			<div id="search_success" style="height: 500px;">
				<table id="product" border="1" width="500px;">
					<tr>
						<th>상품사진</th>
						<th>상품명</th>
						<th>가격</th>
						<th>설명</th>
						<th>담기</th>
					</tr>
					<c:forEach var="row" items="${search_result}">
						<tr align="center">
							<td><img src="resources/images/${row.picture_url}"
								width="100" height="100"></td>
							<td>${row.product_name }</td>
							<td><fmt:formatNumber value="${row.price}" pattern="#,###" /></td>
							<td>${row.description}</td>
							<!-- 상품 설명을 가져옴 -->

							<td>
								<form name="form1" method="post"
									action="${path}/shoppingweb/cart_insert">
									<input type="hidden" name="product_id"
										value="${row.product_id}"> <input type="hidden"
										name="product_name" value="${row.product_name}"> <input
										type="hidden" name="price" value="${row.price}">
									<!-- 상품코드를 히든타입으로 넘김 -->
									<select name="amount">
										<c:forEach begin="1" end="10" var="i">
											<option value="${i}">${i}</option>
											<!-- 장바구니에  10개 까지 담을수 있다.-->
										</c:forEach>
									</select>&nbsp;개 <input type="submit" value="장바구니에 담기">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
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
				window.location.href = url;
			});
			$('#search_Term').keypress(function(event) {
				if (event.which == 13) {
					$('#search_btn').click();
					return false;
				}
			});
		});
	</script>
</body>
</html>