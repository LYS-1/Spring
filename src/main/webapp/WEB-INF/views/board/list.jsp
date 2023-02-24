<%@page import="com.home.spring.board.BbsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="row my-5">
		<h1 class="text-center">${boardName} List</h1>
	</div>
	<div class="container-fluid">
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Num</th><th>Title</th><th>Date</th><th>Hit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.num}</td>
							<td>
								<c:catch>
									<!-- notice에 depth가 없어서 Exception 발생 -->
									<c:forEach begin="1" end="${dto.depth}" varStatus="i">
										<c:if test="${i.last}">
											↳
										</c:if>
										<c:if test="${!i.last}">
											&nbsp &nbsp
										</c:if>
									</c:forEach>
								</c:catch>
								<a href="./detail?num=${dto.num}">${dto.title}</a>
							</td>
							<td>${dto.regDate}</td>
							<td>${dto.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
				<nav aria-label="Page navigation example">
					<div class="row">
						<div class="col-md-10">
							<ul class="pagination">
								<c:if test="${pager.page != 1}">
									<li class="page-item">
										<a class="page-link" href="#" aria-label="Previous" data-board-page="1">
											<span aria-hidden="true">&laquo;</span>
					      				</a>
					    			</li>
					    		</c:if>
					    		<c:if test="${pager.page != 1 && pager.startNum-1 > 0}">
					    			<li class="page-item">
					      				<a class="page-link" href="#" aria-label="Previous" data-board-page="${pager.startNum-1}">
					        				<span aria-hidden="true">&lsaquo;</span>
					      				</a>
					    			</li>
					    		</c:if>
					    
					    		<c:forEach begin="${pager.startNum}" end="${pager.endNum}" var="i">
						    		<li class="page-item"><a class="page-link" href="#" data-board-page="${i}">${i}</a></li>
								</c:forEach> 
					    
					    		<c:if test="${pager.page != pager.totalPage && pager.endNum + 1 <= pager.totalPage}">
					    			<li class="page-item">
					      				<a class="page-link" href="#" aria-label="Next" data-board-page="${pager.endNum + 1}">
					        				<span aria-hidden="true">&rsaquo;</span>
					      				</a>
					    			</li>
					   			</c:if>
					    		<c:if test="${pager.after == false }">
					    			<li class="page-item">
					      				<a class="page-link" href="#" aria-label="Next" data-board-page="${pager.totalPage}">
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
				<form class="row g-3" action="./list" method="get" id="searchForm">
					<input type="hidden" name="page" value="1" id="page">
					<div class="col-auto">
				  		<label for="kind" class="visually-hidden">Kind</label>
				    	<select class="form-select" name="kind" id="kind" aria-label="Default select example">
							<option value="title" ${pager.kind eq 'title'?'selected':''}>title</option>
						  	<option value="contents" ${pager.kind eq 'contents'?'selected':''}>contents</option>
						  	<option value="writer" ${pager.kind eq 'writer'?'selected':''}>writer</option>
						</select>
				  	</div>
				  	<div class="col-auto">
				    	<label for="search" class="visually-hidden">Search</label>
				    	<input type="text" class="form-control" name="search" id="search" placeholder="inputText" value = "${pager.search}">
				  	</div>
				  	<div class="col-auto">
				    	<button type="submit" class="btn btn-primary mb-3">검색</button>
				  	</div>
				</form>
				<div class="">
					<a href="./add" class="btn btn-primary float-end">글 작성</a>
				</div>
			</div>
			
			
	</div>
	
	
	<c:import url="../template/common_js.jsp"></c:import>
	<script src="../resources/js/paging.js"></script>
</body>
</html>