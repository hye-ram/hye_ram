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
<body class="sub_page">
	<tr>
		<td><jsp:include page="top.jsp" flush="false" /></td>
	</tr>

	<h2>상품목록</h2>
	<button type="button" id="btnAdd">상품등록</button>
	<table border="1" width="80%">
		<tr>
			<th>상품사진</th>
			<th>상품명</th>
			<th>가격</th>
			<th>설명</th>
			<th>담기</th>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr align="center">
				<td><img src="resources/images/${row.picture_url}" width="100"
					height="100"></td>
				<td>${row.product_name }</td>
				<td><fmt:formatNumber value="${row.price}" pattern="#,###" /></td>
				<td>${row.description}</td>
				<!-- 상품 설명을 가져옴 -->

				<td>
					<form name="form1" method="post"
						action="${path}/shoppingweb/cart_insert">
						<input type="hidden" name="product_id" value="${row.product_id}">
						<input type="hidden" name="product_name"
							value="${row.product_name}"> <input type="hidden"
							name="price" value="${row.price}">
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

	<a href="${path}/shoppingweb/product_list">상품목록</a>

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
			//자바스크립트 태그안쪽에 
			$('#btnAdd').click(function() {
				location.href = "${path}/shoppingweb/product_write";
			});
		});
	</script>
</body>
</html>
