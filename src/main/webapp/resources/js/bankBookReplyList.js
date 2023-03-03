let xhttp2 = new XMLHttpRequest();
xhttp2.open('POST', '/bankBookComment/list');
xhttp2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhttp2.send("bookNumber=" + btnReply.getAttribute('data-book-bookNumber'));
xhttp2.addEventListener('readystatechange', function(){
    if(this.readyState == 4 && this.status==200){
        let ar = this.responseText.trim();
        
        document.getElementById('replyList').innerHTML = ar;
    }
})