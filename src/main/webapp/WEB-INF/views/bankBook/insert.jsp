<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>

</head>
<body>
	
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container-fluid">
		<div class="row my-4">
			<h1 class="col-md-7 mx-auto text-center">BankBook Product Insert Page</h1>
		</div>
		<div class="row col-md-7 mx-auto">
			<form action="./insert" method = "post">
				<div class="mb-1">
					<label for="bookName" class="form-label ps-0">상품 이름</label>
					<input type="text" class="form-control" id="bookName" name="bookName" placeholder="상품 이름 입력"/>
					<div id="passwordHelpBlock" class="form-text ps-0">
	  					상품 이름은 10자를 넘어가선 안됩니다.
					</div>
				</div>
				<div class="mb-1">
					<label for="bookRate" class="form-label ps-0">이자율</label>
					<input type="text" class="form-control" id="bookRate" name="bookRate" placeholder="이자율 입력"/>
					<div id="passwordHelpBlock" class="form-text ps-0">
	  					이자율은 10이하의 소숫점 두자릿수까지 적용됩니다.
					</div>
				</div>
				<div class="mb-1">
					<label for="bookDetail" class="form-label ps-0">상세 설명</label>
					<textarea class="form-control" id="bookDetail" name="bookDetail" placeholder="상세 설명" rows=7></textarea>
				</div>
				<!-- <div class="row col-md-7 mx-auto mb3">
					<label class="form-label">판매 여부</label>
					<div class="form-check">
		  				<input class="form-check-input" checked type="radio" name="bookSale" id="bookSale1" value="1">
		  				<label class="form-check-label" for="bookSale1">
		    				판매 중
		  				</label>
		  			</div>
		  			<div class="form-check">
		  				<input class="form-check-input" type="radio" name="bookSale" id="bookSale2" value="0">
		  				<label class="form-check-label" for="bookSale2">
		    				판매 중단
		  				</label>
					</div>
				</div> -->
				<div class="mb-1">
					<label class="form-label ps-0">판매 여부</label>
					<div class="form-check form-switch">
	  					<input class="form-check-input" type="checkbox" role="switch" id="bookSale1" name="bookSale" checked value="1">
	  					<label class="form-check-label" for="bookSale1">판매 중</label>
					</div>
				</div>
				<div class="float-end">
					<button type="submit" class="btn btn-primary">제품 추가</button>
				</div>
				
				<!-- <div class="mb3">	
					<label class="row">판매 여부</label>
					<select name = "bookSale">
						<option value = "1" class="text-center">판매 중</option>
						<option value = "0" class="text-center">판매 중단</option>
					</select>	
				</div> -->
				<!-- 라디오버튼 판매여부 -->
	<!-- 			<fieldset class="row col-md-7 mx-auto mb-2">
	
					<input id="bs1" type ="radio" checked name="bookSale" value = "1"/>
					<label for="bs1">판매</label>
						
					<input id="bs2" type ="radio" name="bookSale" value = "0"/>
					<label for="bs2">판매 중단</label>
	
				</fieldset> -->
				
			</form>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>