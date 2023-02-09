<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Main Page  
	</h1>
	<a href = "/product/list"> Product List </a><br>
	<a href = "/member/memberPage"> Member List </a><br>
	<a href = "/bankBook/list"> BankBookProduct List </a><br>
	
	<img alt="image1" src="/resources/images/imageTest2.jpg" style="width:700px; height:700px;">
	<img alt="image2" src="./resources/images/imageTest.jpg" style="width:700px; height:700px;">
	<iframe width="560" height="315" src="https://www.youtube.com/embed/2MkS9Kha6lk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
	<P>${serverTime}</P>
</body>
</html>
