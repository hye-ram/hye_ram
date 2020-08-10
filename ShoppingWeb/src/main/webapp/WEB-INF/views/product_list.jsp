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

<title>상품목록 - Hye-Ram</title>

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
	<div id="sub_title">
		<hr>
		<h2>product list</h2>
	</div>
	<div id="cate_list">
		<c:forEach var="caterow" items="${catelist}">
			<a href="product_list_gourp?cate02=${caterow.cate02Id}">${caterow.cate02Name}</a>
		</c:forEach>
	</div>
	<div id="product_list">
		<c:forEach var="row" items="${list}">
			<div id="product_box">
				<div onclick="detailView(${row.product_id})">
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


	<a href="${path}/shoppingweb/product_list">상품목록</a>
	<c:if test="${sessionScope.userId eq 'admin'}">
		<button type="button" id="btnAdd">상품등록</button>
	</c:if>

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
		function detailView(id) {
			location.href = "${path}/shoppingweb/product_detail?product_id="+ id;
		}
	</script>
</body>
</html>
