const div1 = document.getElementById('fileList');
const btn = document.getElementById('imgBTN');
const btn2 = document.getElementById('resetBTN');
let count = 0;
let max =4;
let param='pic';
function setName(p){
    param=p;
}
function setMax(m){
    max=m;
}


btn2.addEventListener('click', function(){
    let divImg = document.getElementsByClassName('mb-1 imgDIV');
    console.log("divImg.length : ", divImg.length);
    
    while(divImg){
        let i = 0;
        console.log(i);
        divImg[i].remove();
        i ++;
        if(divImg.length == 0){
            break;
        }
    }
    count = 0;

    // for(let i = 0; i < divImg.length; i ++){
    //     console.log(i);
    //     console.log("divImg[",i,"] : ",divImg[i]);
    //     divImg[i].remove();
        
    // }
    // console.log("divImg.length : ", divImg.length);
    // //div1.removeChild(divImg);
    
})


btn.addEventListener('click', function(){
    count ++;
    
    alert(count + "회 클릭했음.");
    if(count > 4){
        
        alert("4개 이상의 이미지 삽입 불가능");
        return false;
    }
    let d = document.createElement('div');
    let l = document.createElement('label');
    let i = document.createElement('input');

    let lt = document.createTextNode('이미지' + count);
    
    let dc = document.createAttribute("class");
    
    let lc = document.createAttribute("class");
    let lf = document.createAttribute("for");
    let ic = document.createAttribute("class");
    let it = document.createAttribute('type');
    let ii = document.createAttribute('id');
    let ina = document.createAttribute('name');

    dc.value='mb-1 imgDIV';
    
    lc.value='form-label ps-0';
    lf.value='files';
    ic.value='form-control';
    it.value='file';
    ii.value='files';
    ina.value=param;

    d.setAttributeNode(dc);
    

    l.setAttributeNode(lc);
    l.setAttributeNode(lf);

    i.setAttributeNode(ic);
    i.setAttributeNode(it);
    i.setAttributeNode(ii);
    i.setAttributeNode(ina);

    l.appendChild(lt);

    d.appendChild(l);
    l.appendChild(i);

    div1.append(d);
});

    // <div class="mb-1">
	// <label for="files" class="form-label ps-0">이미지</label>
	// <input type="file" class="form-control" id="files" name="pic" />
	// </div>