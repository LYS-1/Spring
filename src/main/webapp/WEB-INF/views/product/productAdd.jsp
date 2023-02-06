<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Add</h1>
	
	<div class = "col-6">
		<form action = "./productAdd" method = "post">
			<table>
				<tr>
					<td>상품명(Product Name)</td>
					<td><input type = "text" name = "productName"></td>
				</tr>
				<tr>
					<td>상품 설명(Product Introduce)</td>
					<td><textarea rows = 30 cols = 30 name = "productDetail"></textarea></td>
				</tr>
			</table>
			<button type = "submit">SubmitButton</button>
		</form>
	</div>	
</body>
</html>