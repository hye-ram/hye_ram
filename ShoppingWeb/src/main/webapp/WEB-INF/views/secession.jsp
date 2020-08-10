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

<title>회원탈퇴 - Hye-Ram</title>

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
	<!-- 탈퇴화면 -->
	<tr>
		<td><jsp:include page="top.jsp" flush="false" /></td>
	</tr>

	<form action="secessionProc" name="delFrm" id="delFrm" method="post">
		<input type="hidden" name="userId" value="${sessionScope.userId}">
		<table border=1>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="userPw" id="userPw"></td>
			</tr>
			<tr>
				<td>패스워드 확인</td>
				<td><input type="password" name="userPw02" id="userPw02"></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><a href="#" id="secession">탈퇴하기</a></td>
			</tr>
		</table>
	</form>
	<hr>
	<input type="button" href="mypage" value="취소">
	</a>

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
			$('#secession').click(function() {

				//패스워드 입력 확인
				if ($('#userPw').val() == '') {
					alert("패스워드를 입력해 주세요.");
					$('#userPw').focus();
					return;
				} else if ($('#userPw02').val() == '') {
					alert("패스워드를 입력해 주세요.");
					$('#userPw02').focus();
					return;
				}

				//입력한 패스워드가 같인지 체크
				if ($('#userPw02').val() != $('#userPw').val()) {
					alert("패스워드가 일치하지 않습니다.");
					$('#userPw02').focus();
					return;
				}

				//패스워드 맞는지 확인
				$.ajax({
					url : "${pageContext.request.contextPath}/pwCheck",
					type : "POST",
					data : $('#delFrm').serializeArray(),
					success : function(data) {
						if (data == 0) {
							alert("패스워드가 틀렸습니다.");
							return;
						} else {
							//탈퇴
							var result = confirm('정말 탈퇴 하시겠습니까?');
							if (result) {
								$('#delFrm').submit();
							}
						}
					},
					error : function() {
						alert("서버 에러.");
					}
				});
			});
		});
		
	</script>

</body>

</html>