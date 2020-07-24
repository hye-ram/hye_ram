<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	<div class="hero_area">
		<!-- header section strats -->
		<div class="brand_box"
			style="background-image: url('resources/images/sub-top.jpg');">
			<a class="navbar-brand" href="home"> <span> Hye-Ram </span>
			</a>
			<div class="icon-set">
				<ul class="top-set">
					<li><a class="top-set-li" href="login">login</a></li>
					<li><a class="top-set-li" href="join">join</a></li>
					<li><a class="top-set-li" href="cart"><i
							class="fas fa-shopping-cart"></i></a></li>
				</ul>
			</div>
		</div>
		<!-- end header section -->
	</div>

	<!-- nav section -->

	<section class="nav_section">
		<div class="container">
			<div class="custom_nav2">
				<nav class="navbar navbar-expand custom_nav-container ">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<div class="d-flex  flex-column flex-lg-row align-items-center">
							<ul class="navbar-nav  ">
								<li class="nav-item active"><a class="nav-link" href="home">Home
										<span class="sr-only">(current)</span>
								</a></li>
								<li class="nav-item"><a class="nav-link" href="clothes">Clothes
								</a></li>
								<li class="nav-item"><a class="nav-link" href="review">Review
								</a></li>
								<li class="nav-item"><a class="nav-link" href="notice">Notice</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="qna">QnA</a>
								</li>
							</ul>
							<form class="form-inline my-2 my-lg-0 ml-0 ml-lg-4 mb-3 mb-lg-0">
								<button class="btn  my-2 my-sm-0 nav_search-btn" type="submit"></button>
							</form>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</section>

	<!-- end nav section -->
	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>
	<script>
		$(document).ready(function() {
			$("#btnDelete").click(function() {
				if (confirm("삭제하시겠습니까?")) {
					document.form1.action = "${path}/shoppingweb/delete";
					document.form1.submit();
				}
			});

			$("#btnUpdete").click(function() {
				//var title = document.form1.title.value; ==> name속성으로 처리할 경우
				//var content = document.form1.content.value;
				//var writer = document.form1.writer.value;
				var title = $("#title").val();
				var content = $("#content").val();
				var writer = $("#writer").val();
				if (title == "") {
					alert("제목을 입력하세요");
					document.form1.title.focus();
					return;
				}
				if (content == "") {
					alert("내용을 입력하세요");
					document.form1.content.focus();
					return;
				}
				if (writer == "") {
					alert("이름을 입력하세요");
					document.form1.writer.focus();
					return;
				}
				document.form1.action = "${path}/shoppingweb/update"
				// 폼에 입력한 데이터를 서버로 전송
				document.form1.submit();
			});
		});
	</script>
</head>
<body>

	<h2>게시글 보기</h2>
	<form name="form1" method="post">
		<div>
			<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
			작성일자 :
			<fmt:formatDate value="${dto.regdate}"
				pattern="yyyy-MM-dd a HH:mm:ss" />
			<!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
		</div>
		<div>조회수 : ${dto.viewcnt}</div>
		<div>
			제목 <input name="title" id="title" size="80" value="${dto.title}"
				placeholder="제목을 입력해주세요">
		</div>
		<div>
			내용
			<textarea name="content" id="content" rows="4" cols="80"
				placeholder="내용을 입력해주세요">${dto.content}</textarea>
		</div>
		<div>
			이름 <input name="writer" id="writer" value="${dto.writer}"
				placeholder="이름을 입력해주세요">
		</div>
		<div style="width: 650px; text-align: center;">
			<!-- 게시물번호를 hidden으로 처리 -->
			<input type="hidden" name="bno" value="${dto.bno}">
			<button type="button" id="btnUpdete">수정</button>
			<button type="button" id="btnDelete">삭제</button>
		</div>
	</form>

</body>
</html>