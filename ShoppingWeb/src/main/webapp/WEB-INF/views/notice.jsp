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

<<<<<<< HEAD
<title>Hye-Ram</title>
=======
  <title>공지사항 - Hye-Ram</title>
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git

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


<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/custom.js"></script>

<script>
	$(document).ready(function() {
		$("#btnWrite").click(function() {
			// ���댁� 二쇱�� 蹂�寃�(�대��)
			location.href = "write";
		});
	});
</script>

</head>

<body class="sub_page">
<<<<<<< HEAD
	<tr>
		<td><jsp:include page="top.jsp" flush="false" /></td>
	</tr>
=======
  <div class="hero_area">
    <!-- header section strats -->
    <div class="brand_box" style="background-image: url('resources/images/sub-top.jpg');">
      <a class="navbar-brand" href="home">
        <span>
         	Hye-Ram
        </span>
      </a>
      <div class="icon-set">
	      <ul class="top-set">
	      	<li><a class="top-set-li" href="login">login</a></li>
	      	<li><a class="top-set-li" href="join">join</a></li>
	      	<li><a class="top-set-li" href="cart"><i class="fas fa-shopping-cart"></i></a></li>
	      </ul>
      </div>
    </div>
    <!-- end header section -->
  </div>
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git

	<!-- end nav section -->

	<h2>게시글 목록</h2>
	<button type="button" id="btnWrite">글쓰기</button>
	<table border="1" width="600px">
		<tr>
			<th>번 호</th>
			<th>제 목</th>
			<th>글 쓴 이</th>
			<th>작 성 일</th>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.bno}</td>
				<td><a href="${path}/shoppingweb/view?bno=${row.bno}">${row.title}
						${path}</a></td>
				<td>${row.writer}</td>
				<td>${row.regdate}</td>

<<<<<<< HEAD
			</tr>
		</c:forEach>
	</table>
=======
  <!-- end nav section -->
	
<h2>게시글 목록</h2>
<button type="button" id="btnWrite">글쓰기</button>
<table border="1" width="600px">
    <tr>
        <th>번     호</th>
        <th>제       목</th>
        <th>글 쓴 이</th>
        <th>작 성 일</th>
    </tr>
    <c:forEach var="row" items="${list}">
    <tr>
        <td>${row.bno}</td>
        <td><a href="${path}/shoppingweb/view?bno=${row.bno}">${row.title}</a></td>
        <td>${row.writer}</td>
        <td>${row.regdate}</td>
        
    </tr>    
    </c:forEach>
</table>
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git

</body>
</html>