const btn = document.getElementById('btn');
const btn2 = document.getElementById('btn2');
btn.addEventListener('click', function(){

    let r1 = document.getElementById('r1');
    let c1 = document.getElementById('c1');

    console.log(r1.value);
    console.log(c1.value);

    let r = r1.value;
    let c = c1.value;
    let t1 = window.document.getElementById('t1');
    let t2 = window.document.getElementById('t2');
    let col='';
    let row='';
    for(let i = 0; i < c; i ++){
        col = col + '<td></td>';
    }
    for(let i = 0; i < r; i ++){
        row = row + '<tr>' + col + '</tr>' 
    }
    t1.innerHTML=row;
    
})

btn2.addEventListener('click', function(){
    let r2 = document.getElementById('r2');
    let c2 = document.getElementById('c2');
    let result='';
    let rv2 = r2.value;
    let cv2 = c2.value;
    console.log(rv2);
    console.log(cv2);
    for(let i = 0; i < rv2; i ++){
        result = result + '<tr>';
        for(let j = 0; j < cv2; j ++){
            result = result + '<td></td>'
        }
        result = result + '</tr>';
    }

    t2.innerHTML=result;
})

const btn3 = document.getElementById('s1');
//배열
const options = document.getElementsByClassName('options');
btn3.addEventListener("click", function(){
    for(let i = 0; i < options.length; i ++){
        if(options[i].selected == true){
            console.log(options[i].value);
            break;
        }
    }
})

const btn4 = document.getElementById('check');
const roptions = document.getElementsByName('r1');

btn4.addEventListener("click", function(){
    for(let i = 0; i < roptions.length; i ++){
        if(roptions[i].checked == true){
            console.log(roptions[i].value);
            break;
        }
    }
})


const cboptions = document.getElementsByClassName('ch');

for(let i = 0; i < cboptions.length; i ++){
    cboptions[i].addEventListener("click", function(){
        for(let j = 0; j < cboptions.length; j ++){
            cboptions[j].checked = this.checked;
        }
    })
}