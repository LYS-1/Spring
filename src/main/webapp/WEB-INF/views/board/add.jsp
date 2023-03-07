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
			<h1 class="col-md-7 mx-auto text-center">${boardName} Add Page</h1>
		</div>
		<div class="row col-md-7 mx-auto">
			<form action="./add" method = "post" enctype="multipart/form-data">
				<div class="mb-1">
					<label for="writer" class="form-label ps-0">작성자</label>
					<input type="text" class="form-control" id="writer" name="writer" value="${member.id}" readonly="readonly"/>
				</div>
				<div class="mb-1">
					<label for="title" class="form-label ps-0">제목</label>
					<input type="text" class="form-control" id="title" name="title" placeholder="제목 입력"/>
				</div>
				<div class="mb-1">
					<label for="contents" class="form-label ps-0">내용</label>
					<textarea class="form-control" id="contents" name="contents" placeholder="상세 내용" rows=7></textarea>
				</div>
				<div id="summernote" class="mb-1">
				</div>
				<div id="fileList">
					<!-- <div class="mb-1">
						<label for="files" class="form-label ps-0">이미지</label>
						<input type="file" class="form-control" id="files" name="files" />
						<button type="button">X</button>
					</div> -->
					<button type="button" id="imgBTN" class="btn btn-primary">ADD</button>
					<button type="button" id="resetBTN" class="btn btn-primary">RESET</button>
				</div>

				
				<div class="float-end mt-3">
					<button type="submit" class="btn btn-primary">글쓰기</button>
				</div>

				
			</form>
		</div>
	</div>
	<script src="/resources/js/filemanager.js"></script>
	<script>
		setMax(5);
		setParam('files');
		$('#contents').summernote({
			//toolbar: []
		});
	</script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>