const d1 = document.getElementById('d1');
const add = document.getElementById('add');
const d1_1 = document.getElementById('d1_1');

const result = document.getElementById('result');
let dels = document.getElementsByClassName('dels');
let count = 0;

result.addEventListener('click', function(e){
    //console.log(e.target);
    //console.log(e.target.classList.contains('dels'))
    if(e.target.classList.contains('dels')){
        //console.log('delete');
        //e.target
        id='div' + e.target.getAttribute('data-btn-idx');
        console.log("delete : " + id);
        document.getElementById(id).remove();
        //e.target.remove();
    }
});

add.addEventListener('click', function(){
    count ++;
    let d = document.createElement('div');
    let did = document.createAttribute('id');
    let btn = document.createElement('button');
    let btnidx = document.createAttribute('data-btn-idx');
    let n = document.createTextNode('delete');
    let attr = document.createAttribute('class');
    
    attr.value='dels';
    did.value='div' + count;
    btnidx.value=count;
    btn.setAttributeNode(attr);
    btn.setAttributeNode(btnidx);
    btn.appendChild(n);

    d.setAttributeNode(did);
    d.appendChild(btn);
    
    result.append(d);
});



d1.addEventListener('click', function(){
    d1.removeChild(d1_1);
});



