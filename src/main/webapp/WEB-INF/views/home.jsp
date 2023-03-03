<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Home</title>
	<c:import url="./template/common_css.jsp"></c:import>
</head>
<body>
	<!-- 서버 내부 주소 / 상대경로 -->
	<c:import url="./template/header.jsp"></c:import>
	
	<!-- <section class="container border border-danger">
		<article class="row">
			<div class="col border border-danger">1</div>
			<div class="col border border-priamary">2</div>
			<div class="col border border-danger">3</div>
		</article>
		
	</section>
	<section class="container-fluid border border-primary-subtle">
		<article class="row">
			<div class="col-2 border border-danger">1</div>
			<div class="col-7 border border-priamary">2</div>
			<div class="col-3 border border-danger">3</div>
		</article>
	</section>
	<section class="container-md border border-danger">
		<article class="row">
			<div class="col-md-3 col-lg-6 border border-danger">1</div>
			<div class="col-md-3 col-lg-6 border border-priamary">2</div>
			<div class="col-md-6 col-lg-12 border border-danger">3</div>
		</article>
	</section> -->
	
	<div class="container-fluid my-5">
		<div class="row col-md-6 offset-md-3">
			<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img src="/resources/images/test1.jpg" class="d-block w-100" alt="...">
			    </div>
			    <div class="carousel-item">
			      <img src="/resources/images/test2.jpg" class="d-block w-100" alt="...">
			    </div>
			    <div class="carousel-item">
			      <img src="/resources/images/testimg2.jpg" class="d-block w-100" alt="...">
			    </div>
			  </div>
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
		</div>
		<div class="container-fluid col-md-3 offset-md-3 my-5" id="noticeList">
			
		</div>
	</div>
	
	
	<c:import url="./template/common_js.jsp"></c:import>
	<script src="/resources/js/noticeTop5.js"></script>
</body>
</html>
