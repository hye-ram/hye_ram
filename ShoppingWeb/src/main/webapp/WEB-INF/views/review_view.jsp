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
	<tr>
		<td><jsp:include page="top.jsp" flush="false" /></td>
	</tr>
	<h2>게시판 글 보기</h2>

	<form name="form2" method="post">
		<input name="bno" type="hidden" value="${rdto.bno}" />
		<table border="1">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left">${rdto.title}</td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left">${rdto.writer}</td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left">${rdto.content}</td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left">${rdto.regdate}</td>
		
				<td colspan="2" align="center">
					<button type="button" id="btnUpdete" onclick="location.href='review_update'">수정</button>
					<button type="button" id="btnDelete">삭제</button>
				</td>
			</tr>
			<a href="review">글 목록</a>
		</table>
	</form>

	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>
	<script>
		$(document).ready(function() {
			$("#btnDelete").click(function() {
				if (confirm("삭제하시겠습니까?")) {
					document.form2.action = "${path}/shoppingweb/notice_delete";
					document.form2.submit();
				}
			});

			/* $("#btnUpdete").click(function() {
				
				document.form2.action = "${path}/shoppingweb/notice_update"
				// 폼에 입력한 데이터를 서버로 전송
				document.form2.submit();
			}); */
		});
	</script>

</body>
</html>