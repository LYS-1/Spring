const p1 = document.getElementsByClassName('page-link');
const searchForm = document.getElementById('searchForm');
const page = document.getElementById('page');

for(let p of p1){
    p.addEventListener('click', function(e){
        
        let v = p.getAttribute('data-board-page')
        
        console.log(v);
        
        page.value = v;
        
        searchForm.submit();

    })
}
