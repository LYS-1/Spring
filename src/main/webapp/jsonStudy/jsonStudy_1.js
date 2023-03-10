$('#btn').click(()=>{
    
    let productId = $('#productId').val();
    
    $.ajax({
        type:'GET',
        url:'https://dummyjson.com/products/'+productId, //resttemplate
        //"content-type : application/json"
        success: function(response){
            console.log(response);
            console.log(typeof response);

        }
    })

    // $.get('https://dummyjson.com/products/'+productId, (response)=>{
    //     console.log(response);
    //     console.log('title',response.title);
    //     alert(response);
    //     let result = JSON.stringify(response);
    //     console.log(result);
    //     alert(result);
    //     console.log(typeof result);

    // })
    
})

$.get('https://dummyjson.com/products', (response)=>{
    console.log("length : ",response.products.length);
    //let result='';
    for(let item of response.products){
        let result = '<div class="card" style="width: 18rem;">'
        result = result + '<img src="'+ item.thumbnail +'" class="card-img-top" alt="...">'
        result = result + '<div class="card-body">'
        result = result + '<h5 class="card-title">'+ item.title +'</h5>'
        result = result + '<p class="card-text">'+ item.description +'</p>'
        result = result + '<p class="card-price">$'+ item.price +'</p>'
        result = result + '<a href="#" class="btn btn-primary detail" data-btn-idx="'+ item.id +'">상세 페이지</a>'
        result = result + '</div></div>'
        $('#productList').append(result)
    }
    //$('#productList').html(result);
})


$('#productList').on('click', '.detail', function(e){
    let id = $(this).attr('data-btn-idx');
    $.get('https://dummyjson.com/products/'+ id, (response)=>{
        console.log(response.title);
        
    })
    e.preventDefault();
})