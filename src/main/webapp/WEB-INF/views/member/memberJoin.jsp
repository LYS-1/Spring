<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.redResult{
		color : red;
	}
	.blueResult{
		color : blue;
	}
</style>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid">
		<div class="row col-md-7 mx-auto border-bottom border-dark">
			<h1 class="text-center mt-4">Member Join</h1>
		</div>
		<div class="row col-md-7 mx-auto mt-4">
			<form action="./memberJoin" method = "post">
			<!-- ID input -->
				<div class="form-outline mb-4" id="divId">
			    	<label class="form-label redResult" for="id" id="idL">ID</label>
			    	<input type="text" id="id" class="form-control" name="id" placeholder="ID를 입력하세요."/>
			    	<label id="idLabel">ID를 입력하세요.</label>
			  	</div>
			<!-- Password input -->
				<div class="form-outline mb-4">
					<label class="form-label redResult" for="pw1" id="pw1L">Password</label>
					<input type="password" id="pw1" class="form-control" name="pw" placeholder="Password를 입력하세요."/>
					<label id="pw1Label">Password를 입력하세요.</label>
				</div>
				<div class="form-outline mb-4">
					<label class="form-label redResult" for="pw2" id="pw2L">Password</label>
					<input type="password" id="pw2" class="form-control" name="pw" placeholder="Password를 입력하세요."/>
					<label id="pw2Label">Password를 입력하세요.</label>
				</div>
			<!-- Name input -->
			  	<div class="form-outline mb-4">
			 		<label class="form-label redResult" for="name" id="nameL">Name</label>
			 		<input type="text" id="name" class="form-control" name="name" placeholder="Name을 입력하세요."/>
			 		<label id="nameLabel">Name을 입력하세요.</label>
			  	</div>
			<!-- Email input -->
			  	<div class="form-outline mb-4">
			 		<label class="form-label redResult" for="email" id="emailL">Email</label>
			 		<input type="text" id="email" class="form-control" name="email" placeholder="Email을 입력하세요."/>
			 		<label id="emailLabel">Email을 입력하세요.</label>
			  	</div>
			<!-- address input -->
			  	<div class="form-outline mb-4">
			 		<label class="form-label redResult" for="address" id="addressL">Address</label>
			 		<input type="text" id="address" class="form-control" name="address" placeholder="Address를 입력하세요."/>
			 		<label id="addressLabel">Address를 입력하세요.</label>
			  	</div>
			<!-- Phone input -->
			  	<div class="form-outline mb-4">
					<label class="form-label redResult" for="phone" id="phoneL">Phone</label>
			 		<input type="text" id="phone" class="form-control" name="phone" placeholder="Phone을 입력하세요."/>
			 		<label id="phoneLabel">Phone을 입력하세요.</label>
			  	</div>  
			<!-- Submit button -->
				<div class="row col-md-7 mx-auto">
					<button type="button" id="btn" class="btn btn-primary">Sign up</button>
				</div>
			</form>
		</div>
	</div>
	<script src="/resources/js/memberJoin.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>