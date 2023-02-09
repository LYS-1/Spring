<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<h1>BankBook Product Update Page</h1>
	<hr>
	<form action="./update" method = "post">
		<fieldset>
			<legend>상품 번호</legend>
			<input type = text name = "bookNumber" value = "${dto.bookNumber}" readonly/>
		</fieldset>
		
		<fieldset>
			<legend>상품 이름</legend>
			<input type =text name = "bookName" value = "${dto.bookName}" />
		</fieldset>
		
		<fieldset>
			<legend>이자율</legend>
			<input type =text name = "bookRate" value = "${dto.bookRate}" />
		</fieldset>
		
		<fieldset>
			<legend>판매 여부</legend>
			<select name = "bookSale">
				<option ${dto.bookSale eq '1' ? 'selected':' '} value = "1">판매 중</option>
				<option ${dto.bookSale eq '0' ? 'selected':' '} value = "0">판매 중단</option>
			</select>
		</fieldset>
		
		<fieldset>	
			<label for="bs1">판매</label>
			<input id="bs1" type ="radio" ${dto.bookSale eq '1' ? 'checked':' '} name="bookSale" value = "1"/>
			<label for="bs2">판매 중단</label>
			<input id="bs2" type ="radio" ${dto.bookSale eq '0' ? 'checked':' '} name="bookSale" value = "0"/>
		</fieldset>
		
		<fieldset>
			<legend>상세 정보</legend>
			<input type =text name = "bookDetail" value = "${dto.bookDetail}" />
		</fieldset>
	<button type="submit">제품 수정</button>
	</form>
</body>
</html>