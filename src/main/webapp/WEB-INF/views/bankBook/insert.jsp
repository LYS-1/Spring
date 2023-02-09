<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<h1>BankBook Product Insert Page</h1>
	</fieldset>
	<form action="./insert" method = "post">
		<fieldset>
			<legend>상품 이름</legend>
			<input type =text name = "bookName"/>
		</fieldset>
		<fieldset>
			<legend>이자율</legend>
			<input type =text name = "bookRate"/>
		</fieldset>

		<fieldset>
			<legend>상세 설명</legend>
			<textarea rows = 10 cols = 30 name = "bookDetail"></textarea>
		</fieldset>
		<!-- <fieldset>
			<legend>판매 여부</legend>
			<input type = text name = "bookSale"/>
		</fieldset>-->

		<fieldset>
			<label>판매 여부</label>
			<select name = "bookSale">
				<option value = "1">판매 중</option>
				<option value = "0" >판매 중단</option>
			</select>
		</fieldset>
		<fieldset>	
			<label for="bs1">판매</label>
			<input id="bs1" type ="radio" checked name="bookSale" value = "1"/>
			<label for="bs2">판매 중단</label>
			<input id="bs2" type ="radio" name="bookSale" value = "0"/>
		</fieldset>
		
	<button type="submit">제품 추가</button>
	</form>
</body>
</html>