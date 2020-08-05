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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

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
	<h1>로그인 페이지</h1>
	<hr />
	<c:choose>
		<c:when test="${empty sessionScope.userId}">
			<!-- 로그인이 안되어 있으면 -->
			<form id="loginFrm" name="loginFrm" action="loginCheck">
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
							<td colspan=2>아이디 또는 패스워드가 틀렸습니다.</td>
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
		$(document).ready(function(e) {
			$('#login').click(function() {
				// 입력 값 체크
				if ($.trim($('#userId').val()) == '') {
					alert("아이디를 입력해 주세요.");
					$('#userId').focus();
					return;
				} else if ($.trim($('#userPw').val()) == '') {
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