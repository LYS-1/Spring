//const btnReply = document.getElementById('btnReply');
const replyContents = document.getElementById('replyContents');
//const pageLink = document.querySelectorAll(".page-link");
const commentListResult = document.getElementById('replyList');
const contentsConfirm = document.getElementById('contentsConfirm');
const closeModal = document.getElementById('closeModal');

let updateCheck = 0;
let page = 1;
//댓글 등록
$('#btnReply').click((e)=>{
    //js에서 사용할 가상의 form 태그 생성
    const form = new FormData();//html <form></form>
    form.append('contents', $('#replyContents').val());//<form><input type='text' name='contents' value='dfds'></form>
    form.append('bookNumber', e.target.getAttribute('data-book-bookNumber'))//<form><input type='text' name='contents' value='dfds'><input type='text' name='bookNumber' value='booknum'></form>


    fetch('../bankBookComment/add', {
        method : 'POST',
        //headers : {"Content-type" : "application/x-www-form-urlencoded; charset=UTF-8"},
        body : form
    }).then((response) => response.text())
    .then((res) => {
        if(res.trim() == 1){
            alert('댓글이 등록되었습니다.');
            $('#replyContents').val("");
            getList(1)
        }else{
            alert('댓글 등록이 실패했습니다.')
        }
    }).catch(()=>{
        alert('error');
    })
})

// btnReply.addEventListener('click', function(){
    
//     //js에서 사용할 가상의 form 태그 생성
//     const form = new FormData();//html <form></form>
//     form.append('contents', replyContents.value);//<form><input type='text' name='contents' value='dfds'></form>
//     form.append('bookNumber', btnReply.getAttribute('data-book-bookNumber'))//<form><input type='text' name='contents' value='dfds'><input type='text' name='bookNumber' value='booknum'></form>


//     fetch('../bankBookComment/add', {
//         method : 'POST',
//         //headers : {"Content-type" : "application/x-www-form-urlencoded; charset=UTF-8"},
//         body : form
//     }).then((response) => response.text())
//     .then((res) => {
//         if(res.trim() == 1){
//             alert('댓글이 등록되었습니다.');
//             replyContents.value="";
//             getList(1)
//         }else{
//             alert('댓글 등록이 실패했습니다.')
//         }
//     }).catch(()=>{
//         alert('error');
//     })

// //     let xhttp = new XMLHttpRequest();
// //     xhttp.open('POST', '../bankBookComment/add');
// //     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
// //     xhttp.send('contents=' + replyContents.value + "&bookNumber=" + btnReply.getAttribute('data-book-bookNumber'));
// //     xhttp.addEventListener('readystatechange', function(){
// //         if(this.readyState==4 && this.status==200){
// //             if(this.responseText.trim()==1){
// //                 alert('댓글이 등록되었습니다.');
// //                 replyContents.value="";
// //             }else{
// //                 alert('댓글 등록이 실패했습니다.')
// //             }
// //         }
// //     });
// });




getList(page);

function getList(page){
    
    let count = 0;
    
    fetch('/bankBookComment/list?bookNumber=' + btnReply.getAttribute('data-book-bookNumber') + '&page=' + page, {
        method: 'GET'
    }).then((response)=> response.text())
    .then((res)=>{
        let ar = res.trim();
        $('#replyList').html(ar);
        //commentListResult.innerHTML=ar;
    }).catch(()=>{
        alert('리스트 가져오기 실패');
    })


    // let xhttp2 = new XMLHttpRequest();
    // xhttp2.open('GET', '/bankBookComment/list?bookNumber=' + btnReply.getAttribute('data-book-bookNumber') + '&page=' + page);
    // xhttp2.send();
    // xhttp2.addEventListener('readystatechange', function(){
    //     if(this.readyState == 4 && this.status==200){
            
    //         count ++;
            
    //         let ar = this.responseText.trim();
            
    //         commentListResult.innerHTML = ar;
    //     }
    // })
    
    //출력 : 0 => 비동기 방식이기 때문에.
    //console.log("count : ",count);
}

//paging
$('#replyList').on('click', '.page-link', function(e){

    page = $(this).attr("data-board-page");
    getList(page);
    e.preventDefault();
})

// commentListResult.addEventListener('click', function(e){
//     let pageLink = e.target;
//     if(pageLink.classList.contains("page-link")){
//         page = pageLink.getAttribute("data-board-page");
//         getList(page);
//     }
//     e.preventDefault();
// })

//delete
//$('#commentListResult').on('click', '.update', ()=>{});
$('#replyList').on('click', '.deleteComment', (e)=>{
    let btnDel = e.target;
    let idx = btnDel.getAttribute('data-btn-idx');
    if(btnDel.classList.contains('deleteComment')){
        fetch('../bankBookComment/delete', {
            method : 'POST',
            headers : {"Content-type": "application/x-www-form-urlencoded"},
            body : "num=" + idx
        }).then((response)=> response.text() )//then(function(response){response.text()})
        .then((res)=> {
            if(res.trim() == 1){
                alert('댓글이 삭제 되었습니다.');
                getList(page);
            }else{
                alert('댓글 삭제에 실패했습니다.')
            }
        }).catch(()=>{
            alert('삭제 실패');
        })
        
    }
})
// commentListResult.addEventListener('click', function(e){
//     let btnDel = e.target;
//     let idx = btnDel.getAttribute('data-btn-idx');
//     if(btnDel.classList.contains('deleteComment')){
//         fetch('../bankBookComment/delete', {
//             method : 'POST',
//             headers : {"Content-type": "application/x-www-form-urlencoded"},
//             body : "num=" + idx
//         }).then((response)=> response.text() )//then(function(response){response.text()})
//         .then((res)=> {
//             if(res.trim() == 1){
//                 alert('댓글이 삭제 되었습니다.');
//                 getList(page);
//             }else{
//                 alert('댓글 삭제에 실패했습니다.')
//             }
//         }).catch(()=>{
//             alert('삭제 실패');
//         })
        
//     }
//     // let btnDel = e.target;
//     // if(btnDel.classList.contains('deleteComment')){
//     //     let idx = btnDel.getAttribute('data-btn-idx');
//     //     let xhttp3 = new XMLHttpRequest();
//     //     xhttp3.open('POST', '../bankBookComment/delete');
//     //     xhttp3.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//     //     xhttp3.send("num=" + idx);
//     //     xhttp3.addEventListener('readystatechange', function(){
//     //         if(this.readyState==4 && this.status==200){
//     //             if(this.responseText.trim()==1){
//     //                 alert('댓글이 삭제 되었습니다.');
//     //                 getList(page);
//     //             }else{
//     //                 alert('댓글 삭제에 실패했습니다.')
//     //             }
//     //         }
//     //     });
//     // }
// })

//update

$('#replyList').on('click', '.updateComment', function(e){
    
    let num = $(this).attr('data-btn-idx');
    console.log(num);
    $('#contents').val($('#contents' + num).text());
    
    $('#contentsConfirm').attr('data-btn-idx', num);

    
})

$('#contentsConfirm').click(function(){

    fetch('../bankBookComment/update', {
        method : 'POST',
        headers : {"Content-type": "application/x-www-form-urlencoded"},
        body : "num=" + $(this).attr('data-btn-idx') + '&contents='+ $('#contents').val()
    }).then((response)=> response.text())
    .then((res)=>{
        if(res.trim() == 1){
            alert('댓글이 수정되었습니다.');
            $('#closeModal').click();
            getList(page);
        }else{
            alert('댓글 수정에 실패했습니다.')
        }
    }).catch(()=>{
        alert('관리자에게 문의하세요.')
    })

})





