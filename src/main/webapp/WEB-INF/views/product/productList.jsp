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
	<div class="container-fluid">
		<div class="row my-4 ">
			<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">ProductList Page</h1>
		</div>
		<div class = "row col-md-7 mx-auto">
			<table class = "table table-hover">
				<thead>
					<tr>
						<th> 상품명 </th><th> 평점 </th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<c:forEach items = "${productList}" var = "DTO"><!-- DTO는 page영역에 담김(현재 jsp page) -->
						<tr>
						<td><a href = "./detail?productNum=${pageScope.DTO.productNum}" >${pageScope.DTO.productName}</a></td>
						<td><h3>${DTO.productJumsu}</h3></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>	
		<div class="row col-md-7 mx-auto">
			<a href = "./productAdd"><button class ="btn btn-primary "> 상품 등록 </button></a>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>