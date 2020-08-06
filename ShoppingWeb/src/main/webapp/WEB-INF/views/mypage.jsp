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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<title>마이페이지 - Hye-Ram</title>

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

	<div id="sub_title">MY PAGE</div>
	<div id="mypage_box">
		<div id="shopping_info">
			shopping info
			<ul>
				<li><a href="order_list">주문내역</a></li>
				<li><a href="cart">장바구니</a></li>
				<li><a href="review">리뷰목록</a></li>
				<li><a href="qna">문의내역</a></li>
			</ul>
		</div>
		<div id="customer_info">
			customer info
			<ul>
				<li><a href="mem_edit">회원정보변경</a></li>
				<li><a href="secession">회원탈퇴신청</a></li>
			</ul>
		</div>
	</div>
	<br><br>
	<div id="mypage_infobox">
		<c:forEach var="row" items="${memInfo}">
		<div><i class="far fa-user-circle fa_5x"></i></div>
		<div>
			<div><span class="info_title">${row.userName}</span> <span>[${row.userId}] 님</span>
			<input type="button" id="mem_edit_btn" value="edit"></div>
			<div><span class="info_title">전화번호</span> <span class="info_con">${row.userCell01}-${row.userCell02}-${row.userCell03}</span> </div> 
			<div><span class="info_title">이메일</span> <span class="info_con">${row.userEmail}</span></div>
			<div><span class="info_title">주소</span> <span class="info_con">${row.userAddr02}${row.userAddr03}</span></div>
		 </div>
		<div>총 주문 금액</div>
		</c:forEach>
	</div>
	<div id="mypage_latestorder">
	최근 주문 정보<br>
	date/product/cost/detail
	</div>
	<div id="mypage_latestsubject">
	최근 등록 게시글<br>
	date/subject/board
	</div>
	<br>
	<tr>
		<td><jsp:include page="bottom.jsp" flush="false" /></td>
	</tr>
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		
		$("#mem_edit_btn").click(function() {
			location.href = '${path}/shoppingweb/mem_edit';
		});
	});
	</script>


</body>

</html>