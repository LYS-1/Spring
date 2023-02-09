<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Product Update Page</h1>
	<hr>
	<form action="./update" method = "post">
	<table>
		<tbody>
			<tr>
				<td>상품 번호</td>
				<td><input type = text name = "bookNumber" value = "${dto.bookNumber}" readonly/></td>
			</tr>
			<tr>
				<td>상품 이름</td>
				<td><input type =text name = "bookName" value = "${dto.bookName}" /></td>
			</tr>
			<tr>
				<td>이자율</td>
				<td><input type =text name = "bookRate" value = "${dto.bookRate}" /></td>
			</tr>
			<tr>
				<td>판매 여부</td>
				<td><input type =text name = "bookSale" value = "${dto.bookSale}" /></td>
			</tr>
			<tr>
				<td>상세 정보</td>
				<td><input type =text name = "bookDetail" value = "${dto.bookDetail}" /></td>
			</tr>
		</tbody>
	</table>
	<button type="submit">제품 수정</button>
	</form>
</body>
</html>