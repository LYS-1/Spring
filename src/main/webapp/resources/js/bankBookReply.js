const btnReply = document.getElementById('btnReply');
const replyContents = document.getElementById('replyContents');
//const pageLink = document.querySelectorAll(".page-link");
const commentListResult = document.getElementById('replyList');

let updateCheck = 0;
let page = 1;
btnReply.addEventListener('click', function(){
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', '../bankBookComment/add');
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send('contents=' + replyContents.value + "&bookNumber=" + btnReply.getAttribute('data-book-bookNumber'));
    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4 && this.status==200){
            if(this.responseText.trim()==1){
                alert('댓글이 등록되었습니다.');
                replyContents.value="";
            }else{
                alert('댓글 등록이 실패했습니다.')
            }
        }
    });
});

getList(page);

function getList(page){
    
    let count = 0;
    
    let xhttp2 = new XMLHttpRequest();
    xhttp2.open('GET', '/bankBookComment/list?bookNumber=' + btnReply.getAttribute('data-book-bookNumber') + '&page=' + page);
    xhttp2.send();
    xhttp2.addEventListener('readystatechange', function(){
        if(this.readyState == 4 && this.status==200){
            
            count ++;
            
            let ar = this.responseText.trim();
            
            commentListResult.innerHTML = ar;
        }
    })
    
    //출력 : 0 => 비동기 방식이기 때문에.
    console.log("count : ",count);
}

//paging
commentListResult.addEventListener('click', function(e){
    let pageLink = e.target;
    if(pageLink.classList.contains("page-link")){
        page = pageLink.getAttribute("data-board-page");
        getList(page);
    }
    e.preventDefault();
})

//delete
commentListResult.addEventListener('click', function(e){
    let btnDel = e.target;
    if(btnDel.classList.contains('deleteComment')){
        let idx = btnDel.getAttribute('data-btn-idx');
        let xhttp3 = new XMLHttpRequest();
        xhttp3.open('POST', '../bankBookComment/delete');
        xhttp3.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp3.send("num=" + idx);
        xhttp3.addEventListener('readystatechange', function(){
            if(this.readyState==4 && this.status==200){
                if(this.responseText.trim()==1){
                    alert('댓글이 삭제 되었습니다.');
                    getList(page);
                }else{
                    alert('댓글 삭제에 실패했습니다.')
                }
            }
        });
    }
})

//update
commentListResult.addEventListener('click', function(e){
    let btnUpdate = e.target;
    let idx = btnUpdate.getAttribute('data-btn-idx');
    let table = document.getElementById('table-contents-'+idx);
    let btn = document.getElementById('UpdateComment-'+idx);
    let text = btn.innerText;
    //테이블 밑에 모든 버튼받아서 수정완료라고 적힌 버튼 제외하고 다 비활?
    if(updateCheck == 0 && btnUpdate.classList.contains('updateComment')){
    	let text = table.innerText;
        table.innerHTML = '<textarea class="form-control" id="updateContents" cols="20">' + text + '</textarea>';
        btn.innerText="수정완료";
        updateCheck = 1;
        text = btn.innerText;
    }else if(updateCheck == 1 && btnUpdate.classList.contains('updateComment') && text == '수정완료'){
        text = document.getElementById('updateContents').value;
        table.innerHTML = text;
        let xhttp3 = new XMLHttpRequest();
        xhttp3.open('POST', '../bankBookComment/update');
        xhttp3.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp3.send("num=" + idx + "&contents=" + text);
        xhttp3.addEventListener('readystatechange', function(){
            if(this.readyState==4 && this.status==200){
                if(this.responseText.trim()==1){
                    alert('댓글이 수정 되었습니다.');
                    btn.innerText="수정하기";
                    getList(page);
                }else{
                    alert('댓글 수정에 실패했습니다.')
                }
            }
        });
        updateCheck = 0;
    }
})