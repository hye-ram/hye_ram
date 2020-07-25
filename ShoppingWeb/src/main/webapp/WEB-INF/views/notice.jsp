
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>로그인  - Hye-Ram</title>

  <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Baloo+Chettan|Dosis:400,600,700|Poppins:400,600,700&display=swap" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="resources/css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="resources/css/responsive.css" rel="stylesheet" />
  
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">

  
  <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="resources/js/bootstrap.js"></script>
  <script type="text/javascript" src="resources/js/custom.js"></script>
  
  <script>
    $(document).ready(function(){
        $("#btnWrite").click(function(){
            // ���댁� 二쇱�� 蹂�寃�(�대��)
            location.href = "write";
        });
    });
</script>

</head>

<body class="sub_page">
  <div class="hero_area">
    <!-- header section strats -->
    <div class="brand_box" style="background-image: url('resources/images/sub-top.jpg');">
      <a class="navbar-brand" href="home">
        <span>
         	공지사항 - Hye-Ram
        </span>
      </a>
      <div class="icon-set">
	      <ul class="top-set">
	      	<li><a class="top-set-li" href="login">login</a></li>
	      	<li><a class="top-set-li" href="join">join</a></li>
	      	<li><a class="top-set-li" href="cart"><i class="fas fa-shopping-cart"></i></a></li>
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
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="d-flex  flex-column flex-lg-row align-items-center">
              <ul class="navbar-nav  ">
                <li class="nav-item active">
                  <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="clothes">Clothes </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="review">Review </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="notice">Notice</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="qna">QnA</a>
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
	
<h2>게시글 목록</h2>
<button type="button" id="btnWrite">글쓰기</button>
<table border="1" width="600px">
    <tr>
        <th>번   호</th>
        <th>제       목</th>
        <th>글 쓴 이</th>
        <th>작 성 일</th>
    </tr>
    <c:forEach var="row" items="${list}">
    <tr>
        <td>${row.bno}</td>
        <td><a href="${path}/shoppingweb/view?bno=${row.bno}">${row.title} ${path}</a></td>
        <td>${row.writer}</td>
        <td>${row.regdate}</td>
        
    </tr>    
    </c:forEach>
</table>

</body>
</html>