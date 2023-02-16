<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저축상품</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">
<link rel="stylesheet" href="../resources/css/buttons.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container-fluid">
		<div class="my-4 ">
			<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">BankBookList Page</h1>
		</div>	
		<div class = "col-md-7 mx-auto">
			<table class="table table-hover">
				<thead>
					<tr>
						<th> 상품명 </th>
						<th> 이자율 </th>
						<th> 판매여부 </th>
					</tr>
				</thead>
				<tbody class="table-group-divider mb-1">
					<c:forEach items="${list}" var="dto">
						<tr>
							<td><a href = "./detail?bookNumber=${dto.bookNumber}"> ${dto.bookName} </a></td>
							<td> ${dto.bookRate} </td>
							<td>
							<c:choose>
								<c:when test="${dto.bookSale == 1}">판매중</c:when>
								<c:when test="${dto.bookSale == 0}">판매 종료</c:when>
							</c:choose>
							</td>
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
							<option value="title">상품명</option>
						  	<option value="contents">상품내용</option>
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
			
			
			<div class="px-0">
				<a href = "./insert"><button type="button" class="btn btn-primary float-end">상품 추가</button></a>
			</div>
		</div>
		
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>	 -->