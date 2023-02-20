console.log("hello world");

//변수 선언 : 데이터타입 변수명
let num1 = 3;
num1="a";

//옛 버전 hoisting 문제 발생
var num2 = 4;

//java의 final과 같은 데이터타입
const num3 = 5;
//num3 = 6;

let num4 = null;

num4 = num1 + num2;

num4 = num1 > num2;

num4 = 1;

num4 = num4 + 1;

num4 ++;

num1 = 3;
num2 = '3';
num4 = 'abc'
num4 = null;
console.log(typeof(num4));
console.log('num4 : ' + num4);
console.log(num1==num2); // 값만 같은지 확인
console.log(num1===num2); // 값과 타입이 같은지 확인
console.log(num3);
console.log('num1 : ' + num1);