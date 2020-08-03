<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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

<style>
/* 첨부파일을 드래그할 영역의 스타일 */
.fileDrop {
	width: 600px;
	height: 70px;
	border: 2px dotted gray;
	background-color: gray;
}
</style>
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/custom.js"></script>
<script type="text/javascript" src="resources/js/common.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/smarteditor2/js/HuskyEZCreator.js"
	charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
</head>

<body class="sub_page">

	<tr>
		<td><jsp:include page="top.jsp" flush="false" /></td>
	</tr>

	<h2>리뷰 글 작성</h2>

	<form id="form2" name="form2"
		action="${path}/shoppingweb/review_insert" method="post">
		<table border="1" width="100%">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input type="text" id="title" name="title" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left"><input type="text" id="writer" name="writer"
					size="10" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">내 용</td>
				<td align="left"><textarea rows="10" cols="100" name="ir1"
						id="ir1"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnSave">확인</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="review">리뷰 목록 가기</a>
	<br>
	<br>
	<br>
	<tr>
		<td><jsp:include page="bottom.jsp" flush="false" /></td>
	</tr>


	<script type="text/javascript">
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
					oEditors.getById["ir1"].exec("PASTE_HTML", [ "" ]);
				},
				fCreator : "createSEditor2"
			});
		});

		$(function() {
			$("#btnSave").click(function() {
				var title = $("#title").val();
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

				oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
				alert("값넣는다?");

				var ir1 = $("#ir1").val();
				alert($("#ir1").val());
				if (ir1 == null) {
					alert("내용을 입력하세요.");
					oEditors.getById["ir1"].exec("FOCUS"); //포커싱
					return;
				}

				//id가 smarteditor인 textarea에 에디터에서 대입
				// 폼에 입력한 데이터를 서버로 전송 */

				$("#form2").submit();

			});

		});
	</script>

</body>
</html>