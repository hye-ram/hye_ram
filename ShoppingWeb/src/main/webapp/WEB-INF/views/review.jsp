<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<title>리뷰게시판 - Hye-Ram</title>

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
	<div id="sub_title">
		<hr>
		<h2>리뷰 게시판</h2>
	</div>
	<table id="board_table">
		<tr>
			<th>번 호</th>
			<th>제 목</th>
			<th>글 쓴 이</th>
			<th>작 성 일</th>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.bno}</td>
				<td><a id="board_tbl_title"
					href="${path}/shoppingweb/review_view?bno=${row.bno}">${row.title}</a></td>
				<td>${row.writer}</td>
				<td>${row.regdate}</td>
			</tr>
		</c:forEach>
	</table>
	<br>

	<br>
	<br>
	<tr>
		<td><jsp:include page="bottom.jsp" flush="false" /></td>
	</tr>
	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>

</body>
</html>