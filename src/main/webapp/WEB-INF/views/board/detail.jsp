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
	<div class = "container-fluid">
		<h1>${boardName} Detail Page</h1>
		
		<div class="row">
			<h3>${dto.title}</h3>
			<h3>${dto.writer}</h3>
			<h3>${dto.contents}</h3>
			<c:forEach items ="${dto.boardFileDTOs}" var="fileDTO">
				<a href="./fileDown?fileNum=${fileDTO.fileNum}">${fileDTO.oriName}</a>
			</c:forEach>
			
			
			<%-- <c:if test="${member.id == dto.writer}"> --%>			
				<div class="my-5">
					
					<form action="./update" id="frm">
						<c:if test="${boardName ne 'NOTICE'}">
							<a href="./reply?num=${dto.num}" class="btn btn-primary">답글</a>			
						</c:if>
						<input type="hidden" name="num" value="${dto.num}">
						<button id="update" type="submit" class="btn btn-primary">UPDATE</button>
						<button id="delete" type="button" class="btn btn-danger">DELETE</button>
					</form>
				</div>
			<%-- </c:if> --%>
			
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
	<script type="text/javascript" src="../resources/js/boardForm.js"></script>
</body>
</html>