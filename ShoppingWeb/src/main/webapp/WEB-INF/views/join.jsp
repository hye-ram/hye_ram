<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>회원가입 - Hye-Ram</title>

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

	<form id="joinFrm" name="joinFrm" action="goJoin">
		<div class="new">
			<div class="title">회원가입</div>
			<table>
				<tr>
					<th>아이디</th>
					<th><input type="text" id="userId" name="userId"
						class="userId"></th>
					<th><input type="button" id="check" value="중복체크">
				</tr>
				<tr>
					<td colspan=3 id="idCheck"></td>
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
					<th><input type="text" id="userName" name="userName"
						class="userName"></th>
				</tr>
				<tr>
					<th>우편번호</th>
					<th><input class="form-control"
						style="width: 40%; display: inline;" placeholder="우편번호"
						name="userAddr01" id="userAddr01" type="text" readonly="readonly">
						<button type="button" class="btn btn-default"
							onclick="execDaumPostCode();">
							<i class="fa fa-search"></i> 우편번호 찾기
						</button> <input class="form-control" style="top: 5px;"
						placeholder="도로명 주소" name="userAddr02" id="userAddr02" type="text"
						readonly="readonly" /> <input class="form-control"
						placeholder="상세주소" name="userAddr03" id="userAddr03" type="text" /></th>
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
					</select> - <input type="number" id="userCell02" name="userCell02"
						style="width: 60px" maxlength="4" oninput="numberMaxLength(this);">
						- <input type="number" id="userCell03" name="userCell03"
						style="width: 60px" maxlength="4" oninput="numberMaxLength(this);">
					</th>
				</tr>
				<tr>
					<th>이메일</th>
					<th><input type="text" name="userEmail" id="userEmail"
						class="userEmail"></th>
				</tr>
			</table>
			<input type="button" id="goJoin" value="회원가입"> <input
				type="button" id="cancel" value="취소">
		</div>
	</form>
	<tr>
		<td><jsp:include page="bottom.jsp" flush="false" /></td>
	</tr>
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		// 우편번호 찾기 화면을 넣을 element
		var element_layer = document.getElementById('layer');

		function closeDaumPostcode() {
			// iframe을 넣은 element를 안보이게 한다.
			element_layer.style.display = 'none';
		}

		function execDaumPostCode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var fullAddr = data.address; // 최종 주소 변수
							var extraAddr = ''; // 조합형 주소 변수

							// 기본 주소가 도로명 타입일때 조합한다.
							if (data.addressType === 'R') {
								//법정동명이 있을 경우 추가한다.
								if (data.bname !== '') {
									extraAddr += data.bname;
								}
								// 건물명이 있을 경우 추가한다.
								if (data.buildingName !== '') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
								fullAddr += (extraAddr !== '' ? ' ('
										+ extraAddr + ')' : '');
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('userAddr01').value = data.zonecode; //5자리 새우편번호 사용
							document.getElementById('userAddr02').value = fullAddr;

							document.getElementById('userAddr03').focus();

						},
						width : '100%',
						height : '100%'
					}).open();
		}
	</script>
	<script>
		// 전화번호 글자 수 제한 

		$(document)
				.ready(
						function(e) {
							var idx = false;

							$('#goJoin')
									.click(
											function() {
												if ($.trim($('#userId').val()) == '') {
													alert("아이디 입력.");
													$('#userId').focus();
													return;
												} else if ($.trim($('#userPw')
														.val()) == '') {
													alert($.trim($('#userPw')
															.val())); //왜 빈값..???
													alert("패스워드 입력.");
													$('#userPw').focus();
													return;
												} else if ($.trim($(
														'#userAddr01').val()) == '') {
													alert("주소를 입력하세요.");
													$('#userAddr01').focus();
													return;
												} else if ($.trim($(
														'#userAddr03').val()) == '') {
													alert("상세 주소를 입력하세요.");
													$('#userAddr03').focus();
													return;
												} else if ($.trim($(
														'#userCell02').val()) == ''
														|| $.trim($(
																'#userCell03')
																.val()) == '') {
													alert("전화번호를 입력하세요.");
													$('#userCell01').focus();
													return;
												} else if ($.trim($(
														'#userEmail').val()) == '') {
													alert("이메일을 입력하세요.");
													$('#userEmail').focus();
													return;
												}

												//패스워드 확인
												else if ($('#userPw').val() != $(
														'#userPw02').val()) {
													alert('패스워드가 일치하지 않습니다.');
													$('#userPw').focus();
													return;
												}

												if (idx == false) {
													alert("아이디 중복체크를 해주세요.");
													return;
												} else {
													$('#joinFrm').submit();
												}
											});

							$('#check')
									.click(
											function() {
												$
														.ajax({
															url : "${pageContext.request.contextPath}/idCheck",
															type : "GET",
															data : {
																"userId" : $(
																		'#userId')
																		.val()
															},
															success : function(
																	data) {
																if (data == 0
																		&& $
																				.trim($(
																						'#userId')
																						.val()) != '') {
																	idx = true;
																	$('#userId')
																			.attr(
																					"readonly",
																					true);
																	var html = "<tr><td colspan='3' style='color: green'>사용가능</td></tr>";
																	$(
																			'#idCheck')
																			.empty();
																	$(
																			'#idCheck')
																			.append(
																					html);
																} else {
																	var html = "<tr><td colspan='3' style='color: red'>사용불가능한 아이디 입니다.</td></tr>";
																	$(
																			'#idCheck')
																			.empty();
																	$(
																			'#idCheck')
																			.append(
																					html);
																}
															},
															error : function() {
																alert("서버에러");
															}
														});
											});

						});

		function numberMaxLength(e) {
			if (e.value.length > e.maxLength) {
				e.value = e.value.slice(0, e.maxLength);
			}
		}
	</script>

</body>

</html>