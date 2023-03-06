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
		<c:choose>
			<c:when test = "${dto.bookNumber == null}">
				<h1>없는 제품입니다.</h1>
			</c:when>
			<c:when test="${dto.bookNumber != null}">
				<hr>
				<h1>BankBook Product Detail Page</h1>
				<hr>
				<h3>${dto.bookNumber}. ${dto.bookName}</h3>
				<br>
				<h3>이자율 : ${dto.bookRate}</h3>
				<c:choose>
					<c:when test="${dto.bookSale == 1}"><h3>판매 여부 : 판매중</h3></c:when>
					<c:when test="${dto.bookSale == 0}"><h3>판매 여부 : 판매 종료</h3></c:when>
				</c:choose>
				
				<div>
					<c:if test="${not empty dto.bankBookImgDTO}">
						<img alt="img" src="../resources/upload/bankBook/${dto.bankBookImgDTO.fileName}">
					</c:if>
				</div>
				<h3>상세 정보 : ${dto.bookDetail}</h3>
								
				<a href="./delete?bookNumber=${dto.bookNumber}" class="btn btn-danger">삭제</a>
				<a href="./update?bookNumber=${dto.bookNumber}" class="btn btn-primary">수정</a>
							
			</c:when>
		</c:choose>
		<a href = "./list">목록으로</a>
		
		<div class="my-5 mx-auto col-md-10" id="replyList" >
			
		</div>
		
		<div class="my-5">
			<textarea class="form-control" id="replyContents" rows="3" name="contents"></textarea>
			<button type="button" class="btn btn-primary" id="btnReply" data-book-bookNumber="${dto.bookNumber}">댓글 등록</button>
		</div>
		
		<!-- update form modal -->
		<!-- Button trigger modal -->

		  
		  <!-- Modal -->
		<div class="modal fade" id="contentsModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="form-floating">
							<textarea class="form-control" placeholder="Leave a comment here" id="contents"></textarea>
							<label for="contents">Comments</label>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="closeModal">Cancel</button>
						<button type="button" class="btn btn-primary" id="contentsConfirm">확인</button>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		
		
		
		
		
		
		
		<%-- <hr> --%>
		<%-- <div class = "col-6">
		<table class = "table table-hover">
			<thead>
				<tr>
					<th>상품 번호</th>
					<th>상품 이름</th>
					<th>이자율</th>
					<th>판매 여부</th>
					<th>상세 정보</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.bookNumber}</td>
					<td>${dto.bookName}</td>
					<td>${dto.bookRate}</td>
					<td>
					<c:choose>
						<c:when test="${dto.bookSale == 1}">판매중</c:when>
						<c:when test="${dto.bookSale == 0}">판매 종료</c:when>
					</c:choose></td>
					<td>${dto.bookDetail}</td>
				</tr>
			</tbody>
		</table>
		</div> --%>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
	<script src="/resources/js/bankBookReply.js"></script>
	
</body>
</html>