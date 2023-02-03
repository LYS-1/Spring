<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberList page</h1>
	
	<div class = "col-6">
		<table class = "table table-hover">
			<thead>
			<tr>
				<th> 아이디 </th><th> 이름 </th>
			</tr>
			<tr>
				<c:forEach items="${list}" var = "DTO">
					<tr>
						<td>${pageScope.DTO.member_id}</td>
						<td>${pageScope.DTO.member_name}</td>
					</tr>
				</c:forEach>
			</tr>
		</thead>
		</table>
		<a class = "btn btn-danger" href = "./join"> 상품 등록 </a>
	</div>
</body>
</html>