<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberJoin page</h1>
	
	<form action="./join" method = "post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type = "text" name = "member_id"></td>
			</tr>
			<tr>
				<td>PassWord</td>
				<td><input type = "password" name = "member_pw"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type = "text" name = "member_name"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type = "text" name = "member_address"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type = "text" name = "member_phone"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type = "text" name = "member_email"></td>
			</tr>			
		</table>
		<button type = "submit">SubmitButton</button>
	</form>
</body>
</html>