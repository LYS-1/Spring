const btn = document.getElementById('btn');

btn.addEventListener("click", function(){
    
    let c2 = window.document.getElementById('c2');
    
    console.log(c2.innerText);
    console.log(c2.innerHTML);
    //c2.innerText='test';
    c2.innerHTML='<img src="../resources/images/testimg2.jpg">'

});

const btn2 = document.getElementById('btn2');

btn2.addEventListener("click", function(){
    
    let c3 = document.getElementById('c3');

    let t = c3.title;

    console.log(c3.getAttribute('title'));
    console.log(t);
})

const btn3 = document.getElementById('btn3');

btn3.addEventListener("click", function(){

    let c4 = document.getElementById('inputText');

    console.log(c4.value);

    console.log(c4.getAttribute('value'));
})

let c1 = window.document.getElementById('c1');

//alert(c1);

console.log(c1);

//c1.innerText='changetext';
