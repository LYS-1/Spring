<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>remove test</h1>
	

	<div id="result">
		<c:forEach begin="0" end="4" var="i" varStatus="j">
			<div id="p${j.index}" class="items">
				<h3 class="h">${i}</h3>
				<button class="b" data-div-id="p${j.index}">DELETE</button>
			</div>
		</c:forEach>	
	</div>

	<button id="deleteAll">DELETE ALL</button>
	
	<script>
		const hList = document.getElementsByClassName('h');
		const bList = document.getElementsByClassName('b');

		const deleteAll = document.getElementById('deleteAll');
		const result = document.getElementById('result');
		
		deleteAll.addEventListener('click', function(){
			let items = document.getElementsByClassName('items');
			
			for(let i = 0; 0 !=items.length;i++){
				items[0].remove();
			}
		})

		function callbackBTN(text, num){
			console.log(num);
			text.remove();
		}

		for(let i = 0; i < bList.length; i ++){
			bList[i].addEventListener('click', function(){
				//document.getElementById('p' +i).remove();		
				console.log(this.getAttribute('data-div-id'));
				let id = this.getAttribute('data-div-id');
				document.getElementById(id).remove();	
			});
		}

		console.log(hList[0]);

	</script>
</body>
</html>