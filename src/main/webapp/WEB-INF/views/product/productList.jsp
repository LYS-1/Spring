<%@page import="com.home.spring.product.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
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
	


	<h1>Product List Page</h1>
		
	<hr>
	
	<div class = "col-6">
	<table class = "table table-hover">
		<thead>
			<tr>
				<th> 상품명 </th><th> 평점 </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${productList}" var = "DTO"><!-- DTO는 page영역에 담김(현재 jsp page) -->
				<tr>
				<td style = "font-size:15px"><a href = "./detail?pro_num=${pageScope.DTO.pro_num}" >${pageScope.DTO.pro_name}</a></td>
				<td><h3>${DTO.rating}</h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class = "btn btn-danger" href = "./productAdd"> 상품 등록 </a>
	</div>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>	
	<hr>	
</body>
</html>