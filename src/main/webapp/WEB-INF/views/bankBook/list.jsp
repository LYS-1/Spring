<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<h1>BankBook Product List Page</h1>
	
	<hr>
	
	<div class = "col-6">
	<table class = "table table-hover">
		<thead>
			<tr>
				<th> 상품명 </th>
				<th> 이자율 </th>
				<th> 판매여부 </th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href = "./detail?bookNumber=${dto.bookNumber}"> ${dto.bookName} </a></td>
					<td> ${dto.bookRate} </td>
					<c:choose>
						<c:when test="${dto.bookSale == 1}"><td>판매중</td></c:when>
						<c:when test="${dto.bookSale == 0}"><td>판매 종료</td></c:when>
					</c:choose>
				</tr>
			</c:forEach>			
			
			
		</tbody>
	</table>
	</div>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>	
	<hr>
	<a href = "./insert">상품 추가</a>
</body>
</html>