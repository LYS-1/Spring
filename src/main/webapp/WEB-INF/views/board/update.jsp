<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
	
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container-fluid">
		<div class="row my-4">
			<h1 class="col-md-7 mx-auto text-center">${boardName} Update Page</h1>
		</div>
		<div class="row col-md-7 mx-auto">
			<form action="./update" method = "post" enctype="multipart/form-data">
				<input type="hidden" name="num" value="${dto.num}">
				<div class="mb-1">
					<label for="writer" class="form-label ps-0">작성자</label>
					<input type="text" class="form-control" id="writer" name="writer" value="${dto.writer}" readonly="readonly"/>
				</div>
				<div class="mb-1">
					<label for="title" class="form-label ps-0">제목</label>
					<input type="text" class="form-control" id="title" name="title" placeholder="제목 입력" value="${dto.title}"/>
				</div>
				<div class="mb-1">
					<label for="contents" class="form-label ps-0">내용</label>
					<textarea class="form-control" id="contents" name="contents" placeholder="상세 내용" rows=7 >${dto.contents}</textarea>
				</div>
				<div id="fileList">
					<button type="button" id="imgBTN" class="btn btn-primary">ADD</button>
					<button type="button" id="resetBTN" class="btn btn-primary">RESET</button>
					<c:forEach items="${dto.boardFileDTOs}" var="fileDTO" varStatus="i">
						<div class="input-group mb-3">
							<div class="input-group-text">
								<input class="form-check-input mt-0 deleteCheck" type="checkbox" value="${fileDTO.fileNum}" name="fileNum" aria-label="Checkbox for following text input">
							</div>
							<input type="text" disabled value="${fileDTO.oriName}" class="form-control" aria-label="Text input with checkbox">
						  </div>
					</c:forEach>
					
				</div>

				
				<div class="float-end mt-3">
					<button type="submit" class="btn btn-primary">수정하기</button>
				</div>

				
			</form>
		</div>
	</div>
	<script src="/resources/js/filemanager.js"></script>
	<script>
		setMax(5);
		setParam('addFiles');
		setUpdate(${dto.boardFileDTOs.size()});
		$('#contents').summernote({
			//toolbar: []
		});
	</script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>