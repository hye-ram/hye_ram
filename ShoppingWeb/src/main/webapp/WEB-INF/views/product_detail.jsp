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
<body class="sub_page" style="background-color: rgba(0, 0, 0, 0.01);">
	<tr>
		<td><jsp:include page="top.jsp" flush="false" /></td>
	</tr>
	<div id="detail_box">
		<c:forEach var="row" items="${list}">
			<div id="detail_top">
				<div id="detail_img">
					<img src="resources/images/${row.picture_url}">
				</div>
				<div id="detail_info">
					<div>${row.product_name}</div>
					<div>
						판매가격
						<fmt:formatNumber value="${row.price}" pattern="#,###" />
						원
					</div>
					<hr>
					<div>${row.product_name}</div>
					<div>
						<form id="cartForm" name="form1" method="post"
							action="${path}/shoppingweb/cart_insert">
							<input type="hidden" name="product_id" value="${row.product_id}">
							<input type="hidden" name="product_name"
								value="${row.product_name}"> <input type="hidden"
								name="price" id="price" value="${row.price}">
							<!-- 상품코드를 히든타입으로 넘김 -->
							<select id="amount" name="amount">
								<c:forEach begin="1" end="10" var="i">
									<option value="${i}">${i}</option>
								</c:forEach>
							</select>&nbsp;개 <span class="pricexamount"><fmt:formatNumber value="${row.price}" pattern="#,###" /> 원</span>
						</form>
					</div>
					<hr>
					<div>총 상품 금액 <span class="pricexamount"><fmt:formatNumber value="${row.price}" pattern="#,###" /> 원</span></div>
					<div id="orderBtn">BUY IT NOW</div>
					<div id="addCart">ADD TO CART</div>
				</div>
			</div>
			<div id="detail_description">${row.description}</div>
			<div id="detail_review">리뷰 게시판 연결</div>
			<div id="detail_qna">qna 연결</div>

		</c:forEach>
	</div>

	<a href="${path}/shoppingweb/product_list">상품목록</a>

	<button type="button" id="btnAdd">상품등록</button>

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
		function addComma(num) {
			var regexp = /\B(?=(\d{3})+(?!\d))/g;
			return num.toString().replace(regexp, ',');
		}
		
		$(document)
				.ready(

						function(e) {							
							$('#addCart').click(function() {
								$('#cartForm').submit();
							});
							$('#amount').change(
									function() {
										var amount = $('#amount').val();
										var price = $('#price').val();
										var pricexamount = amount * price;
										$('.pricexamount').empty();
										$('.pricexamount').append(
												"<span>" + pricexamount.toLocaleString()
														+ " 원</span>");
									});
						});
	</script>
</body>
</html>
