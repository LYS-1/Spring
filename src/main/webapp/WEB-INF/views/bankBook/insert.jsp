<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Product Insert Page</h1>
	
	<hr>
	<form action="./insert" method = "post">
	<table>
		<tbody>
			<tr>
				<td>상품 이름</td>
				<td><input type =text name = "bookName"/></td>
			</tr>
			<tr>
				<td>이자율</td>
				<td><input type =text name = "bookRate"/></td>
			</tr>
			<tr>
				<td>판매 여부</td>
				<td><input type =text name = "bookSale"/></td>
			</tr>
			<tr>
				<td>상세 정보</td>
				<td><input type =text name = "bookDetail"/></td>
			</tr>
		</tbody>
	</table>
	<button type="submit">제품 추가</button>
	</form>
</body>
</html>