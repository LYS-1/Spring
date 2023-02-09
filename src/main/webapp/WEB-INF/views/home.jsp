<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Main Page  
	</h1>
	<a href = "/product/list"> Product List </a><br>
	<a href = "/member/memberPage"> Member List </a><br>
	<a href = "/bankBook/list"> BankBookProduct List </a>
	
	
	<P>${serverTime}</P>
</body>
</html>
