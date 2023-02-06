<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join</h1>
	
	<div class = "col-6">
		<form action = "./memberJoin" method = "post">
			<table>
				<tr>
					<td>ID</td>
					<td><input type = "text" name = "id"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type = "password" name = "pw"></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type = "text" name = "name"></td>
				</tr>
				<tr>
					<td>ADDRESS</td>
					<td><input type = "text" name = "address"></td>
				</tr>
				<tr>
					<td>PHONE</td>
					<td><input type = "text" name = "phone"></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type = "text" name = "email"></td>
				</tr>
			</table>
			<button type = "submit">SubmitButton</button>
		</form>
	</div>	
	
</body>
</html>