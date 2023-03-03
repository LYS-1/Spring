
    let xhttp = new XMLHttpRequest();

    xhttp.open('get', '/notice/listTop');

    xhttp.send();

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState == 4 && this.status==200){
            let ar = this.responseText.trim()
            document.getElementById('noticeList').innerHTML = ar;
        }
    })
