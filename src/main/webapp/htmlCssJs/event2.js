const b1 = document.getElementById('b1');
const p1 = document.getElementById('p1');
const b2 = document.getElementById('b2');
const p2 = document.getElementById('p2');
const naver = document.getElementById('naver');

//캡쳐링 중단
b1.addEventListener('click', function(e){
    console.log('button click');
    console.log(e);
}, true);

p1.addEventListener('click', function(event){
    console.log('div click');
    console.log(event);
    event.stopPropagation();
}, true)

//버블링과 중단
b2.addEventListener('click', function(e){
    console.log('button2 click');
    console.log(e);
    //e.stopPropagation();
    console.log('button this : ', this);
}, false);

p2.addEventListener('click', function(event){
    console.log('div2 click');
    console.log(event);
    console.log("current target : ", event.currentTarget);
    console.log("target : ", event.target);
    console.log("this : ",this)
}, false);

naver.addEventListener('click', function(event){
    console.log('naver');
    event.preventDefault();
    //return false;
});