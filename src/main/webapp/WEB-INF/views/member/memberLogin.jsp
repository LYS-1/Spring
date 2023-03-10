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
		<div class="col-md-7 mx-auto">
			<h1 class="text-center">Member Login Page</h1>
		</div>
		<form action="./memberLogin" method = "post" class="col-md-7 mx-auto">
		  <!-- Email input -->
		  <div class="form-outline mb-4">
		  	<label class="form-label" for="id">ID</label>
		    <input type="text" id="id" class="form-control" name="id" value="${cookie.rememberID.value}"/>
		    
		  </div>
		
		  <!-- Password input -->
		  <div class="form-outline mb-4">
		  	<label class="form-label" for="pw">Password</label>
		    <input type="password" id="pw" class="form-control" name="pw"/>
		    
		  </div>
		
		  <!-- 2 column grid layout for inline styling -->
		  <div class="row mb-4">
		    <div class="col d-flex justify-content-center">
		      <!-- Checkbox -->
		      <div class="form-check">
		        <input class="form-check-input" name="remember" type="checkbox" value="remember" id="remember" checked />
		        <label class="form-check-label" for="remember"> Remember me </label>
		      </div>
		    </div>
		
		    <div class="col">
		      <!-- Simple link -->
		      <a href="#!">Forgot password?</a>
		    </div>
		  </div>
		
		  <!-- Submit button -->
		  <div class="row justify-content-center">
		  	<button type="submit" class="btn btn-primary btn-block">Sign in</button>
		  </div>
		</form>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
	
</body>
</html>