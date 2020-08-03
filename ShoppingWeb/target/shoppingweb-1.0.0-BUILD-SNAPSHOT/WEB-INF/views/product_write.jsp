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

<title>[admin] 상품등록 - Hye-Ram</title>

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
<script scr="//cdn.ckeditor.com/4.8.0/standard/ckeditor.js"></script>

</head>
<body class="sub_page">
	<tr>
		<td><jsp:include page="top.jsp" flush="false" /></td>
	</tr>

	<h2>상품 등록</h2>
	<form id="form1" name="form1" enctype="multipart/form-data"
		method="post">
		<table border="1" style="width: 500px">
			<tr>
				<td>분류</td>
				<td class="col-3">대분류 <select name="cate01" id="cate01">
						<option value="">전체</option>
						<c:forEach items="${cate01List}" var="row" varStatus="status">
							<option value="${row.cate01Id}">${row.cate01Name}</option>
						</c:forEach>
				</select> 중분류<select name="cate02" id="cate02" disabled>
				<option value=''>선택</option>
				</select></td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="productName" id="productName"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" name="productPrice" id="productPrice"></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><textarea rows="5" cols="60" name="productDesc"
						id="productDesc"></textarea></td>
			</tr>
			<tr>
				<td>상품이미지</td>
				<td><input type="file" name="file1" id="file1"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="등록"
					id="addBtn"> <input type="button" value="목록" id="listBtn">
				</td>
			</tr>
		</table>
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
	<script>
		$(document).ready(function() {
			// 상품 등록 유효성검사
			
			// 상품 목록이동
			$("#listBtn").click(function() {
				location.href = '${path}/shoppingweb/product_list';
			});

			//ajax 통신해 해당 값을 가져온다.
			$('#cate01').change(function() {
				$('#cate02').attr('disabled', false);
				
				$.ajax({
					url : "${pageContext.request.contextPath}/cateCheck",
					type : "GET",
					dataType : "JSON",
					data : {
						"cate01Id" : $('#cate01').val()
						},
					success : function(data) {
						   if (data.cate02List.length > 0) {
				                 $('#cate02').find('option').remove(); // select box 의 ID 기존의  option항목을 삭제
				                 $('#cate02').append ( "<option value=''>선택</option>" );
				                 for(var i = 0 ; i < data.cate02List.length; i++ ) {
				                   $('#cate02').append("<option value='"+data.cate02List[i].cate02Id+"'>" + data.cate02List[i].cate02Name + '</option>' );
				                 }
				           }else{
				            $ ('#cate02').find('option').remove ();
				            $ ('#cate02').append ( "<option value=''>선택</option>" );
				           }
					},
					error : function() {
						alert("서버에러");
					}
				});
			});
			
			$("#addBtn").click(function() {
				var productName = $("#productName").val();
				var productPrice = $("#productPrice").val();
				var productDesc = $("#productDesc").val();
				var productPhoto = $("#productPhoto").val();
				alert($("#productPhoto").val());
				if (productName == "") {
					alert("상품명을 입력해주세요");
					productName.foucs();
				} else if (productPrice == "") {
					alert("상품 가격을 입력해주세요");
					productPrice.focus();
				} else if (productDesc == "") {
					alert("상품 설명을 입력해주세요");
					productDesc.focus();
				} else if (productPhoto == "") {
					alert("상품 사진을 입력해주세요");
					productPhoto.focus();
				}
				// 상품 정보 전송
				document.form1.action = "${path}/shoppingweb/product_insert";
				document.form1.submit();
			});
		});
	</script>
</body>
</html>
