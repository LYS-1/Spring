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
			<div class="row">
				<nav aria-label="Page navigation example">
				  <div class="row">
					  <div class="col-md-10">
						  <ul class="pagination">
						  	<c:if test="${pager.page != 1}">
						    	<li class="page-item">
						      		<a class="page-link" href="./list?page=1&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
						        		<span aria-hidden="true">&laquo;</span>
						      		</a>
						    	</li>
						    </c:if>
						    <c:if test="${pager.page != 1}">
						    	<li class="page-item">
						      		<a class="page-link" href="./list?page=${pager.page - 1}" aria-label="Previous">
						        		<span aria-hidden="true">&lsaquo;</span>
						      		</a>
						    	</li>
						    </c:if>
						    
						    <c:forEach begin="${pager.startNum}" end="${pager.endNum}" var="i">
							    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
							</c:forEach> 
						    
						    <c:if test="${pager.page != pager.totalPage }">
						    	<li class="page-item">
						      		<a class="page-link" href="./list?page=${pager.page + 1}" aria-label="Next">
						        		<span aria-hidden="true">&rsaquo;</span>
						      		</a>
						    	</li>
						    </c:if>
						    <c:if test="${pager.after == false }">
						    	<li class="page-item">
						      		<a class="page-link" href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
						        		<span aria-hidden="true">&raquo;</span>
						      		</a>
						    	</li>
						    </c:if>
						  </ul>
					  </div>
					  <div class="col-md-2">
					  	<p class="fw-bold">${pager.page}/${pager.totalPage} 페이지</p>
					  </div>
				  </div>
				</nav>
			</div>
			<div class="row">
				<form class="row g-3" action="./list" method="get">
					<div class="col-auto">
				  		<label for="kind" class="visually-hidden">Kind</label>
				    	<select class="form-select" name="kind" id="kind" aria-label="Default select example">
							<option value="name">상품명</option>
						  	<option value="detail">상품내용</option>
						</select>
				  	</div>
				  	<div class="col-auto">
				    	<label for="search" class="visually-hidden">Search</label>
				    	<input type="text" class="form-control" name="search" id="search" placeholder="inputText">
				  	</div>
				  	<div class="col-auto">
				    	<button type="submit" class="btn btn-primary mb-3">검색</button>
				  	</div>
				</form>
			</div>
		</div>	
		
		<div class="row col-md-7 mx-auto">
			<a href = "./productAdd"><button class ="btn btn-primary "> 상품 등록 </button></a>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>