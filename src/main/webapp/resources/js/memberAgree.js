const ch = document.getElementsByClassName('form-check-input');

ch[0].addEventListener('click', function(){
    for(let i = 1; i < ch.length; i ++){
        ch[i].checked = this.checked;
    } 
})

for(let i = 1; i < ch.length; i ++){
    ch[i].addEventListener('click', function(){
        let checkall = true;
        for(let j = 1; j < ch.length; j ++){
            if(!ch[j].checked){
                checkall = !checkall;
                break;
            }
        }
        ch[0].checked = checkall;

        // if(this.checked == false){
        //     ch[0].checked = false;
        // }
        // else if (this.checked == true){
        //     let checkall = false;
        //     for(let j = 1; j < ch.length; j ++){
        //         if(ch[j].checked == true){
        //             checkall = true;
        //         }else if(ch[j].checked == false){
        //             checkall = false;
        //             break;
        //         }  
        //     }
        //     ch[0].checked = checkall;
        // }  
    })
}

const btn1 = document.getElementById('agree');

btn1.addEventListener('click', function(){

    if(ch[0].checked == false){
        alert("전체 동의가 필요합니다.");
    }
    else{
        alert("전체 동의했습니다.")
        location.href="./memberJoin";
    }

})

