<%@page import="com.home.spring.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<div class = "col-6">
		<form action="./detail" method = "post">
			<h1>Product Detail Page</h1>
			<%
				ProductDTO productDTO= (ProductDTO)request.getAttribute("productDTO");
				request.setAttribute("productDTO", productDTO);
			%>
			<h3><%= productDTO.getPro_num() + ". " + productDTO.getPro_name() %></h3><br>
			<h3>Explain</h3>
			<h3><%= productDTO.getPro_introduce() %></h3>
		
			<hr>
			
			<h3>${requestScope.productDTO.pro_name}</h3>
			<h3>${requestScope.productDTO.pro_introduce}</h3>
			<h3>${productDTO.rating}</h3>

			<a href = "./list"><button type = "submit" class = "btn btn-danger" >상품 삭제</button></a>
			
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
		</form>
	</div>
</body>
</html>