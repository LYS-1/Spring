const div1 = document.getElementById('fileList');
const btn = document.getElementById('imgBTN');
const btn2 = document.getElementById('resetBTN');
let count = 0;
let max =4;
let param='pic';
let disable = 0;
let startNum = 0;
// div1.addEventListener('click', function(e){
//     if(e.target.classList.contains('cancelButton')){
//         let id='div' + e.target.getAttribute('data-btn-idx');
//         console.log("delete : " + id);
//         document.getElementById(id).remove();
//         let labelList = document.getElementsByClassName('filelabel');
//         for(let i = 0; i < labelList.length; i ++){
//             labelList[i].innerText = '이미지' + (i+1);
//         }
//         disable --;
//         console.log("disable : ",disable);
//     }
    
// });

function setParam(p){
    param=p;
}
function setMax(m){
    max=m;
}
function setUpdate(sn){
    disable = sn
    startNum = sn
    // for(let i=0;i<disable;i++){
    
    //     let child = '<div class="input-group mb-3" id="div'+count+'">';
    //         child = child + '<input type="file" class="form-control md-8" name="'+ param +'" value=""/>'
    //         child = child + '<button type="button" class="btn btn-outline-secondary btn-danger text-black cancelButton" id="button-addon2" data-btn-idx="'+ count +'">X</button>'
    //         child = child + '</div>'
        
    //     $('#fileList').append(child);
    // }
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

//add

// btn.addEventListener('click', function(){
//     count ++;
//     disable ++;
    
//     alert(count + "회 클릭했음.");
//     if(disable > 4){
//         disable = 4;
//         alert("4개 이상의 이미지 삽입 불가능");
//         return false;
//     }
//     let d = document.createElement('div');
//     let dc = document.createAttribute("class");
//     let di = document.createAttribute('id');
//     dc.value='input-group mb-3';
//     di.value='div'+count;

//     let l = document.createElement('label');
//     let lt = document.createTextNode('이미지' + disable);
//     let lc = document.createAttribute("class");
//     let lf = document.createAttribute("for");
    
//     lc.value='form-label ps-0 my-auto md-4 filelabel';
//     lf.value='files';
    
//     let i = document.createElement('input');
//     let ic = document.createAttribute("class");
//     let it = document.createAttribute('type');
//     let ii = document.createAttribute('id');
//     let ina = document.createAttribute('name');
//     let inputAriaDescribedby = document.createAttribute('aria-describedby');
    
//     ic.value='form-control md-8';
//     it.value='file';
//     ii.value='files';
//     ina.value=param;
//     inputAriaDescribedby.value = "button-addon2"

//     // <button type="button">X</button>
//     let button = document.createElement('button');
//     let buttonClass = document.createAttribute('class');
//     let buttonType = document.createAttribute('type');
//     let buttonIdx = document.createAttribute('data-btn-idx');
//     let buttonText = document.createTextNode('X');
//     let buttonId = document.createAttribute('id');
    
//     buttonClass.value = 'btn btn-outline-secondary btn-danger text-black cancelButton';
//     buttonType.value = 'button';
//     buttonIdx.value = count;
//     buttonId.value = 'button-addon2';


//     d.setAttributeNode(dc);
//     d.setAttributeNode(di);

//     l.setAttributeNode(lc);
//     l.setAttributeNode(lf);

//     i.setAttributeNode(ic);
//     i.setAttributeNode(it);
//     i.setAttributeNode(ii);
//     i.setAttributeNode(ina);
//     i.setAttributeNode(inputAriaDescribedby);

//     button.setAttributeNode(buttonClass);
//     button.setAttributeNode(buttonType);
//     button.setAttributeNode(buttonIdx);
//     button.setAttributeNode(buttonId);
    
//     l.appendChild(lt);
//     button.appendChild(buttonText);

//     d.appendChild(l);
//     d.appendChild(i);
//     d.appendChild(button);

//     div1.append(d);
    
// });


$('#imgBTN').click(()=>{
    count ++;
    disable ++;
    
    
    if(disable > max){
        disable = max;
        alert(max + "개 이상의 이미지 삽입 불가능");
        return false;
    }
    let child = '<div class="input-group mb-3" id="div'+disable+'">';
    child = child + '<input type="file" class="form-control md-8" name="'+ param +'"/>'
    child = child + '<button type="button" class="btn btn-outline-secondary btn-danger text-black cancelButton" id="button-addon2" data-btn-idx="'+ disable +'">X</button>'
    child = child + '</div>'

    $('#fileList').append(child);
})


$('#fileList').on('click', '.cancelButton', function(e){   
    let id = 'div' + $(this).attr('data-btn-idx');
    $('#'+id).remove();
    // $(this).parents('#fileList').remove();
    disable --;   
})

//체크 시 => input 추가 해제 => input 삭제
$('.deleteCheck').click(function(){
    if($(this).prop('checked')){
        let result = confirm('파일이 영구 삭제 됩니다.')
        if(result){
            disable --;
        }else{
            $(this).prop('checked', false);
        }
    }else{
        if(disable == max){
            alert('마지막 첨부 파일란이 지워집니다.')
            disable = max;
            $('#div'+disable).remove();
            return;
        }
        disable ++;
    }
})
