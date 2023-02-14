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
		<form class="col-md-7 mx-auto mt-4" action="./memberUpdate" method="post">

		  <h1 class="text-center">정보 수정</h1>

		  <!-- Text input -->
		  
		  
		  <!-- Email input -->
		  <div class="form-outline mb-4">
		  	<label class="form-label" for="name">Name</label>
		    <input type="text" name="name" id="name" class="form-control" value="${member.name}" />
		  </div>
		  <!-- Number input -->
		  <div class="form-outline mb-4">
		    <label class="form-label" for="Phone">Phone</label>
		    <input type="text" name="phone" id="Phone" class="form-control" value="${member.phone}" />  
		  </div>
		  <div class="form-outline mb-4">
		    <label class="form-label" for="Email">Email</label>
		    <input type="text" name="email" id="Email" class="form-control" value="${member.email}" />
		  </div>
		  <div class="form-outline mb-4">
		    <label class="form-label" for="Address">Address</label>
		    <input type="text" name="address" id="Address" class="form-control" value="${member.address}" /> 
		  </div>
		  <!-- Submit button -->
		  <button type="submit" class="btn btn-primary btn-block mb-4 float-end">수정하기</button>
		</form>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>