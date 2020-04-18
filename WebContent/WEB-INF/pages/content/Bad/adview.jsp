
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
 
  <!-- Link Swiper's CSS -->
 
  <link rel="stylesheet" href="${ctx}/swiper/swiper.min.css">
  <!-- Demo styles -->
   <!-- Demo styles -->
  <style>
    body {
      background: #fff;
      font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
      font-size: 14px;
      color:#000;
      margin: 0;
      padding: 0;
    }
    .swiper-container {
      width: 100%;
      padding-top: 50px;
      padding-bottom: 50px;
    }
    .swiper-slide {
      background-position: center;
      background-size: cover;
      width: 300px;
      height: 300px;

    }
  </style>
</head>
<body>
	 <!-- Swiper -->
  <div class="swiper-container">
    <div class="swiper-wrapper">
      <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath }/image/${list.path})"></div>
      <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath }/image/${list.path2})"></div>
      <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath }/image/${list.path3})"></div>
      <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath }/image/${list.path4})"></div>
      <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath }/image/${list.path5})"></div>
      <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath }/image/${list.path})"></div>
      <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath }/image/${list.path2})"></div>
      <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath }/image/${list.path3})"></div>
      <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath }/image/${list.path4})"></div>
      <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath }/image/${list.path5})"></div>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
  </div>

  <!-- Swiper JS -->
  <script src="${ctx}/swiper/swiper.min.js"></script>

  <!-- Initialize Swiper -->
  <script>
    var swiper = new Swiper('.swiper-container', {
      effect: 'coverflow',
      grabCursor: true,
      centeredSlides: true,
      slidesPerView: 'auto',
      coverflowEffect: {
        rotate: 50,
        stretch: 0,
        depth: 100,
        modifier: 1,
        slideShadows : true,
      },
      pagination: {
        el: '.swiper-pagination',
      },
    });
  </script>
</body>
</html>

