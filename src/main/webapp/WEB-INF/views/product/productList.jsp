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
	<c:import url="../template/common_css.jsp"></c:import>
	<link rel="stylesheet" href="../resources/css/table.css">
	<link rel="stylesheet" href="../resources/css/buttons.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1 class="title">ProductList Page</h1>
	<div>
	<table class = "tb2">
		<thead>
			<tr>
				<th> 상품명 </th><th> 평점 </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${productList}" var = "DTO"><!-- DTO는 page영역에 담김(현재 jsp page) -->
				<tr>
				<td><a href = "./detail?productNum=${pageScope.DTO.productNum}" >${pageScope.DTO.productName}</a></td>
				<td><h3>${DTO.productJumsu}</h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href = "./productAdd"><button class ="submitBTN"> 상품 등록 </button></a>
	</div>	
	
	<hr>	
</body>
</html>