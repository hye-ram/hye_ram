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
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/custom.js"></script>
</head>

<body class="sub_page">

   <tr>
      <td><jsp:include page="top.jsp" flush="false" /></td>
   </tr>

   <form name="form1" form action="${path}/shoppingweb/notice_insert"
      method="post" enctype="multipart/form-data">
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
            <td align="left"><textarea rows="10" cols="30" name="content"
                  id="content"></textarea></td>
         </tr>
         <tr>
            <td bgcolor="orange" width="70">업로드</td>
            <td align="left">
               <div id="preview"></div><input type="file" name="uploadFile" />
            </td>
         </tr>
         <tr>
            <td colspan="2" align="center">
               <button type="button" id="btnSave">확인</button>
               <button type="reset">취소</button>
            </td>
         </tr>
      </table>
   </form>

   <script>
      $(document).ready(function() {
         $("#btnSave").click(function() {
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
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();
         });
      });
   </script>
</body>
</html>