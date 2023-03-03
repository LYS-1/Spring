const btnReply = document.getElementById('btnReply');
const replyContents = document.getElementById('replyContents');

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

getList();

function getList(){
    let xhttp2 = new XMLHttpRequest();
    xhttp2.open('GET', '/bankBookComment/list?bookNumber=' + btnReply.getAttribute('data-book-bookNumber'));
    xhttp2.send();
    xhttp2.addEventListener('readystatechange', function(){
    if(this.readyState == 4 && this.status==200){
        let ar = this.responseText.trim();
        
        document.getElementById('replyList').innerHTML = ar;
    }
})
}

const linkpage = document.getElementsByClassName('page-link');