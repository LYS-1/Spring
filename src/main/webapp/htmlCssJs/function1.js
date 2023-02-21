//전역변수
let n = 'iu';
var old = 'old';
//function 선언
function f1 (){
    console.log("function test");
    console.log(n);
    var old='old';
}

//funciton 호출
f1();

//매개변수 선언시 let, const는 생략해야함
function f2 (n1, n2){
    //지역변수
    let name = 'test';
    return n1+n2;
}

let rt = f2(1,2);
console.log(rt);
console.log(name);
console.log("old : " + old);

let fun = function (){
    console.log('익명함수');
    return 1;
}

fun();

function f3(f){
    console.log('f3 :', f(), 1);
}

f3(fun);

const d1 = document.getElementById('d1');

function callback1(){
    console.log('callback1');
}

let callback2 = function(){
    console.log('callback2');
}

//다른곳에서도 같은 함수를 사용하고 싶을 때
// d1.addEventListener('click', callback1);
// d1.addEventListener('click', callback2);

// 여기에서만 사용하는 함수
d1.addEventListener('click', function(){
    callback1();
    callback2();
});