<%@page import="com.home.spring.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Detail Page</h1>
	<%
		ProductDTO productDTO= (ProductDTO)request.getAttribute("productDTO");
	%>
	<h3><%= productDTO.getPro_num() + ". " + productDTO.getPro_name() %></h3><br>
	<h3>Explain</h3>
	<h3><%= productDTO.getPro_introduce() %></h3>
	
	<hr>
	<h3>${requestScope.productDTO.pro_name}</h3>
	<h3>${requestScope.productDTO.pro_introduce}</h3>
	<h3>${productDTO.rating * productDTO.pro_num}</h3>
	
	
</body>
</html>