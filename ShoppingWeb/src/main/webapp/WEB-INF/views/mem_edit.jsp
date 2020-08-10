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

<title>회원 정보 수정 - Hye-Ram</title>

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

	<div id="sub_title">회원 정보 변경</div>

	<form id="upMemFrm" name="upMemFrm" action="updateMem">
		<div class="mem_table">
			<br>
			<table style="width: 100%;">
				<c:forEach var="row" items="${memInfo}">
					<tr>
						<th>아이디</th>
						<th>${row.userId}</th>
					</tr>
					<tr>
						<th>패스워드</th>
						<th><input type="password" id="userPw" name="userPw"
							class="userPw"></th>
					</tr>
					<tr>
						<th>패스워드 확인</th>
						<th><input type="password" id="userPw02" name="userPw02"
							class="userPw02"></th>
					</tr>
					<tr>
						<th>이름</th>
						<th>${row.userName}</th>
					</tr>
					<tr>
						<th>우편번호</th>
						<th><input class="form-control"
							style="width: 40%; display: inline;" placeholder="우편번호"
							name="userAddr01" id="userAddr01" type="text" readonly="readonly"
							value="${row.userAddr01}">
							<button type="button" class="btn btn-default"
								onclick="execDaumPostCode();">
								<i class="fa fa-search"></i> 우편번호 찾기
							</button> <input class="form-control" style="top: 5px;"
							placeholder="도로명 주소" name="userAddr02" id="userAddr02"
							type="text" readonly="readonly" value="${row.userAddr02}" /> <input
							class="form-control" placeholder="상세주소" name="userAddr03"
							id="userAddr03" type="text" value="${row.userAddr03}" /></th>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<th><select id="userCell01" name="userCell01">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="018">018</option>
								<option value="019">019</option>
						</select> - <input type="number" id="userCell02" value="${row.userCell02}"
							name="userCell02" style="width: 60px" maxlength="4"
							oninput="numberMaxLength(this);"> - <input type="number"
							id="userCell03" name="userCell03" value="${row.userCell03}"
							style="width: 60px" maxlength="4"
							oninput="numberMaxLength(this);"></th>
					</tr>
					<tr>
						<th>이메일</th>
						<th><input type="text" name="userEmail" id="userEmail"
							class="userEmail" value="${row.userEmail}"></th>
					</tr>
				</c:forEach>
			</table>
			<br>
			<div id="btnbox">
				<input type="button" id="updateMemer" value="수정하기">
				<input type="button" id="cancel" value="취소">
			</div>
		</div>
	</form>
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


</body>

</html>