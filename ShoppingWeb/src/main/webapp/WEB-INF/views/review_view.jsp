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
<script type="text/javascript" src="<%=request.getContextPath() %>/smarteditor2/js/HuskyEZCreator.js"
	charset="utf-8"></script>

</head>

<body class="sub_page">
	<tr>
		<td><jsp:include page="top.jsp" flush="false" /></td>
	</tr>
	<h2>리뷰 글 보기</h2>

	<form name="form2" method="post">
		<input name="bno" type="hidden" value="${rdto.bno}" />
		<table border="1" style="width: 1000px;">
			<tr>
				<td bgcolor="orange">제목</td>
				<td align="left"><input name="title" type="text"
					value="${rdto.title}" placeholder="제목을 입력해주세요" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left"><input name="writer" id="writer"
					value="${rdto.writer}" placeholder="이름을 입력해주세요"></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea rows="10" cols="100" name="ir1"
						id="ir1">${rdto.editor}</textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left"><fmt:formatDate value="${rdto.regdate}"
						pattern="yyyy-MM-dd" /></td>
			</tr>

		
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnUpdete">수정</button>
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
			var oEditors = [];
			$(function() {
				nhn.husky.EZCreator.createInIFrame({
					oAppRef : oEditors,
					elPlaceHolder : "ir1",
					//SmartEditor2Skin.html 파일이 존재하는 경로
					sSkinURI : "smarteditor2/SmartEditor2Skin.html",
					htParams : {
						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseToolbar : true,
						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : false,
						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : false,
						fOnBeforeUnload : function() {
						}
					},
					fOnAppLoad : function() {
						//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
						oEditors.getById["ir1"].exec("PASTE_HTML", [""]);
					},
					fCreator : "createSEditor2"
				});
			}); 
			$("#btnDelete").click(function() {
				if (confirm("삭제하시겠습니까?")) {
					document.form2.action = "${path}/shoppingweb/review_delete";
					document.form2.submit();
				}
			});
			
			$("#btnUpdete").click(function() {

				var title = $("#title").val();
				var ir1 = oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
				var writer = $("#writer").val();
				if (title == "") {
					alert("제목을 입력하세요");
					document.form2.title.focus();
					return;
				}
				if (writer == "") {
					alert("이름을 입력하세요");
					document.form2.writer.focus();
					return;
				}
				document.form2.action = "${path}/shoppingweb/review_update"
				// 폼에 입력한 데이터를 서버로 전송
				document.form2.submit();
			});
		});
	</script>

</body>
</html>