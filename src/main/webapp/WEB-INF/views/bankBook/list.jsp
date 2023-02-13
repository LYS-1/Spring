<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	
	<h1 class="title">BankBookList Page</h1>
	<div class = "col-6">
		<img class="img_cen" alt="image" src="../resources/images/imageTest.jpg"/>
		<table class = "tb2">
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
						<td class="cen_td"> ${dto.bookRate} </td>
						<td class="cen_td">
						<c:choose>
							<c:when test="${dto.bookSale == 1}">판매중</c:when>
							<c:when test="${dto.bookSale == 0}">판매 종료</c:when>
						</c:choose>
						</td>
					</tr>
				</c:forEach>			
			</tbody>
		</table>

	
	<hr>
	<a href = "./insert">상품 추가</a>
	</div>
</body>
</html>
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>	 -->