
const divId = document.getElementById('divId');
const inputId = document.getElementById('id');
const idLabel = document.getElementById('idLabel');
const idL = document.getElementById('idL');


const inputPw1 = document.getElementById('pw1'); 
const pw1Label = document.getElementById('pw1Label');
const pw1L = document.getElementById('pw1L');

const inputPw2 = document.getElementById('pw2');
const pw2Label = document.getElementById('pw2Label');
const pw2L = document.getElementById('pw2L');

const inputName = document.getElementById('name');
const nameLabel = document.getElementById('nameLabel');
const nameL = document.getElementById('nameL');

const inputEmail = document.getElementById('email');
const emailLabel = document.getElementById('emailLabel');
const emailL = document.getElementById('emailL');

const inputAddress = document.getElementById('address');
const addressLabel = document.getElementById('addressLabel');
const addressL = document.getElementById('addressL');

const inputPhone = document.getElementById('phone');
const phoneLabel = document.getElementById('phoneLabel');
const phoneL = document.getElementById('phoneL');

const btn = document.getElementById('btn');
const labellist = [idLabel, pw1Label, pw2Label, nameLabel, emailLabel, addressLabel, phoneLabel];
const inputlist = [inputId, inputPw1, inputPw2, inputName, inputEmail, inputAddress, inputPhone];
let blank = false;

btn.onclick = checkblank;

function checkblank(){
    for(let i = 0; i < labellist.length; i ++){
        if(labellist[i].innerText == ''){
            blank = true;
        }else{
            blank = false;
            break;
        }
    }
    console.log(blank);
    if(blank == false){
        btn.setAttribute('type', 'button');
        alert("값을 제대로 입력하세요.");
    }else{
        btn.setAttribute('type', 'submit');
        
    }
}


function check0(input, label, label2){
    if(input.value.length == 0){
        label.innerText = '값을 입력하세요.';
        label2.classList.replace('blueResult', 'redResult')
    }else{
        label.innerText = '';
        label2.classList.replace('redResult', 'blueResult')
    }
}

inputId.addEventListener('focusout', function(){
    let value = inputId.value.length;
    //중복검사
    let xhttp = new XMLHttpRequest();

    //url, method 정보
    xhttp.open('post', './memberIdCheck');
    //header
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //요청 발생 post -> parameter 전송
    xhttp.send('id=' + id.value);
    //응답 처리
    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState == 4 && this.status == 200){
            if(this.responseText.trim() == 'true'){
                idLabel.innerText = '사용 가능한 아이디 입니다.';
                idL.classList.replace('redResult', 'blueResult')
            }else{
                idLabel.innerText = '중복된 아이디 입니다.';
                idL.classList.replace('blueResult', 'redResult')
            }
            
        }  
        if(this.readyState == 4 && this.status != 200){
            //error 발생
        }
    });


    if(value == 0){
        console.log(value);
        idLabel.innerText = 'id를 입력하세요.';
        idL.classList.replace('blueResult', 'redResult')
    }else if(value >= 6 && value <= 12){
        idLabel.innerText = '';
        idL.classList.replace('redResult', 'blueResult')
    }else {
        console.log(value);
        idLabel.innerText = 'id는 6~12자 사이로 입력하세요.';
        idL.classList.replace('blueResult', 'redResult')
    }
});

inputPw1.addEventListener('focusout', function(){
    //check0(inputPw1, pw1Label);
    let value = inputPw1.value.length;
    if(value == 0){
        console.log(value);
        pw1Label.innerText = 'pw는 필수입니다.';
        pw1L.classList.replace('blueResult', 'redResult')
    }else if(value >= 6 && value <= 12){
        pw1Label.innerText = '';
        pw1L.classList.replace('redResult', 'blueResult')
    }else {
        console.log(value);
        pw1Label.innerText = 'pw는 6~12자 사이로 입력하세요.';
        pw1L.classList.replace('blueResult', 'redResult')
    }
    if(inputPw1.value !== inputPw2.value){
        pw2Label.innerText='비밀번호가 다릅니다.';
        pw2L.classList.replace('blueResult', 'redResult')
    }
});

inputPw2.addEventListener('focusout', function(){
    //check0(inputPw2, pw2Label);
    let value = inputPw1.value.length;
    if(value == 0){
        console.log(value);
        pw2Label.innerText = 'pw는 필수입니다.';
        pw2L.classList.replace('blueResult', 'redResult')
    }else if(value >= 6 && value <= 12){
        pw2Label.innerText = '';
        pw2L.classList.replace('redResult', 'blueResult')
    }else {
        console.log(value);
        pw2Label.innerText = 'pw는 6~12자 사이로 입력하세요.';
        pw2L.classList.replace('blueResult', 'redResult')
    }
    if(inputPw1.value !== inputPw2.value){
        pw2Label.innerText='비밀번호가 다릅니다.';
        pw2L.classList.replace('blueResult', 'redResult')
    }
});

inputName.addEventListener('focusout', function(){
    check0(inputName, nameLabel, nameL);
});

inputEmail.addEventListener('focusout', function(){
    check0(inputEmail, emailLabel, emailL);
});

inputAddress.addEventListener('focusout', function(){
    check0(inputAddress, addressLabel, addressL);
});

inputPhone.addEventListener('focusout', function(){
    check0(inputPhone, phoneLabel, phoneL);
});

