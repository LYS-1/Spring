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
		<div class="row col-md-7 mx-auto border-bottom border-dark">
			<h1 class="text-center mt-4">Member Join</h1>
		</div>
		<div class="row col-md-7 mx-auto mt-4">
			<form action="./memberJoin" method = "post">
			<!-- ID input -->
				<div class="form-outline mb-4">
			    	<label class="form-label" for="name">ID</label>
			    	<input type="text" id="name" class="form-control" name="id" placeholder="ID를 입력하세요."/>
			  	</div>
			<!-- Password input -->
				<div class="form-outline mb-4">
					<label class="form-label" for="pw">Password</label>
					<input type="password" id="pw" class="form-control" name="pw" placeholder="Password를 입력하세요."/>
				</div>
			<!-- Name input -->
			  	<div class="form-outline mb-4">
			 		<label class="form-label" for="name">Name</label>
			 		<input type="text" id="name" class="form-control" name="name" placeholder="Name을 입력하세요."/>
			  	</div>
			<!-- Email input -->
			  	<div class="form-outline mb-4">
			 		<label class="form-label" for="email">Email</label>
			 		<input type="text" id="email" class="form-control" name="email" placeholder="Email을 입력하세요."/>
			  	</div>
			<!-- address input -->
			  	<div class="form-outline mb-4">
			 		<label class="form-label" for="address">Address</label>
			 		<input type="text" id="address" class="form-control" name="address" placeholder="Address를 입력하세요."/>
			  	</div>
			<!-- Phone input -->
			  	<div class="form-outline mb-4">
					<label class="form-label" for="phone">Phone</label>
			 		<input type="text" id="phone" class="form-control" name="phone" placeholder="Eamil을 입력하세요."/>
			  	</div>  
			<!-- Submit button -->
				<div class="row col-md-7 mx-auto">
					<button type="submit" class="btn btn-primary">Sign up</button>
				</div>
			</form>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>