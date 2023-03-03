let car = {
    brand: 'audi',
    price: 3000,
    info:function(){
        console.log('brand : ',this.brand, ' price : ',this.price);
    }
}
//클래스 선언
class student{
    #n = '';
    #kor;

    set n(n){
        this.#n = n;
    }

    get n(){
        return this.#n;
    }
    set kor(kor){
        this.#kor = kor;
    }

    get kor(){
        return this.#kor;
    }

    info(){
        console.log(this.#n, "/" , this.#kor);
    }
}
const btn1 = document.getElementById('btn1');

btn1.addEventListener('click', function(){
    // console.log("brand",car.brand);
    // console.log("price",car.price);
    // console.log('info');
    // car.info();

    // car.color='red';
    // console.log('for in')
    // for(let v in car){
    //     console.log(car[v]);
    // }
    let s = new student();
    s.n = 'inputN';
    s.kor = 100;
    s.eng = 100;
    s.info();
    console.log(s.eng);
    console.log(s.n, s.kor);
})

