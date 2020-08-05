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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/smarteditor2/js/HuskyEZCreator.js"
	charset="utf-8"></script>

</head>

<body class="sub_page">
	<tr>
		<td><jsp:include page="top.jsp" flush="false" /></td>
	</tr>
	<h2>리뷰 글 보기</h2>

	<form name="form2" method="post">
		<input name="bno" type="hidden" value="${rdto.bno}" />

		<table border="1" style="width: 100%;">

			<tr>
				<td bgcolor="orange">제목</td>
				<td align="left">${rdto.title}</td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left">${rdto.writer}</td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left">${rdto.editor}</td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left">${rdto.regdate}</td>
			</tr>


			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnUpdate">수정</button>
					<button type="button" id="btnDelete">삭제</button>
				</td>
			</tr>
			<a href="review">글 목록</a>
		</table>
	</form>
	<div style="width: 650px; text-align: center;">
		<br>
		<!-- **로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
		<c:if test="${sessionScope.userId != null}">
			<textarea rows="5" cols="80" id="replytext" placeholder="댓글을 작성해주세요"></textarea>
			<br>
			<button type="button" id="btnReply">댓글 작성</button>
		</c:if>
	</div>

	<!-- **댓글 목록 출력할 위치 -->
	<div id="listReply"></div>

	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							listReply();

							$("#btnDelete")
									.click(
											function() {
												if (confirm("삭제하시겠습니까?")) {
													document.form2.action = "${path}/shoppingweb/review_delete";
													document.form2.submit();
												}
											});
							$("#btnUpdate")
							.click(
									function() {
									
											document.form2.action = "${path}/shoppingweb/review_updatego";
											document.form2.submit();
										}
									});

							$("#btnReply")
									.click(
											function() {
												var replytext = $("#replytext")
														.val();
												var bno = "${rdto.bno}"
												var param = "replytext="
														+ replytext + "&bno="
														+ bno;
												$
														.ajax({
															type : "post",
															url : "${path}/shoppingweb/reply_insert",
															data : param,
															success : function() {
																alert("댓글이 등록되었습니다.");
																listReply();
															},
															error : function() {
																alert("에러임");
															}
														});
											});

						});
		// Controller방식
		// **댓글 목록1
		function listReply() {
			$.ajax({
				type : "get",
				url : "${path}/shoppingweb/reply_list?bno=${rdto.bno}",
				success : function(result) {
					// responseText가 result에 저장됨.
					$("#listReply").html(result);
				},
				error : function() {
					alert("에러임");
				}
			});
		}
	</script>

</body>
</html>