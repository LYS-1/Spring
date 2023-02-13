<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container-fluid">
		
		<div class="row my-4">
			<h1 class="col-md-7 mx-auto text-center">Product Add</h1>
		</div>
		
		<form action = "./productAdd" method = "post">
			<!-- Product Name input -->
			<div class="row col-md-7 mx-auto mb-4">
			  
				<label class="form-label ps-0" for="productName">상품명(Product Name)</label>
				<input type="text" id="productName" class="form-control" name = "productName"/>
			  
			</div>
			
			<!-- Product Introduce input -->
			<div class="row col-md-7 mx-auto mb-4">
			
				<label class="form-label ps-0" for="productDetail">상품 설명(Product Introduce)</label>
				<textarea id="productDetail" class="form-control" name="productDetail" ></textarea>
			  
			</div>
			<!-- Submit button -->
			<div class="row col-md-7 mx-auto">
				<button type="submit" class="btn btn-primary">상품 등록</button>
			</div>
		</form>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>