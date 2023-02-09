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
	
	<c:choose>
		<c:when test = "${dto.bookNumber == null}">
			<h1>없는 제품입니다.</h1>
		</c:when>
		<c:when test="${dto.bookNumber != null}">

			<h1>BankBook Product Detail Page</h1>
			<hr>
			<h3>${dto.bookNumber}. ${dto.bookName}</h3>
			<br>
			<h3>이자율 : ${dto.bookRate}</h3>
			<c:choose>
				<c:when test="${dto.bookSale == 1}"><h3>판매 여부 : 판매중</h3></c:when>
				<c:when test="${dto.bookSale == 0}"><h3>판매 여부 : 판매 종료</h3></c:when>
			</c:choose>
				
			<h3>상세 정보 : ${dto.bookDetail}</h3>
				
			<a href="./delete?bookNumber=${dto.bookNumber}">삭제</a>
			<a href="./update?bookNumber=${dto.bookNumber}">수정</a>
		</c:when>
	</c:choose>
	
	<a href = "./list">목록으로</a>
	
	
	<%-- <hr> --%>
	<%-- <div class = "col-6">
	<table class = "table table-hover">
		<thead>
			<tr>
				<th>상품 번호</th>
				<th>상품 이름</th>
				<th>이자율</th>
				<th>판매 여부</th>
				<th>상세 정보</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dto.bookNumber}</td>
				<td>${dto.bookName}</td>
				<td>${dto.bookRate}</td>
				<td>
				<c:choose>
					<c:when test="${dto.bookSale == 1}">판매중</c:when>
					<c:when test="${dto.bookSale == 0}">판매 종료</c:when>
				</c:choose></td>
				<td>${dto.bookDetail}</td>
			</tr>
		</tbody>
	</table>
	</div> --%>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>