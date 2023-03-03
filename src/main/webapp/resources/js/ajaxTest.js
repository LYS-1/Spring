const btn = document.getElementById('btn');

btn.addEventListener('click', function(){

    let xhttp = new XMLHttpRequest();

    xhttp.open('get', '/notice/list?page=1');

    xhttp.send();

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState == 4 && this.status==200){
            console.log('check');
            console.log(this.responseText);
        }
    })
});