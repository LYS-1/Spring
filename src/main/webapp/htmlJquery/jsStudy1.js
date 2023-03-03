const btn1 = document.getElementById('btn1');
const buttons = document.querySelectorAll('.buttons')//document.getElementById('buttons');

let ar = [1,2,3];

console.log("old")
for(let i; i < ar.length; i ++){
    console.log(ar[i]);
}

console.log("for of")
for(let a of ar){
    console.log(a);
}

console.log("for in")
for(let j in ar){
    console.log(j);
    console.log(ar[j]);
}

console.log("foreach")
ar.forEach(function(v, i, list){
    console.log('v : ' , v, ', i : ', i, ', ar : ', list)
})

// alert(buttons);
// alert(ar);
// console.log(buttons);
// console.log(ar);

buttons.forEach(function(v){
    v.addEventListener('click', function(){
        console.log('click');
    });
});

console.log(parseInt('1')  + 1);
console.log('1'*1 + 1);