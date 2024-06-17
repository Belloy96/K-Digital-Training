// 9. 화살표 함수(Arrow Function) -> 중요하다고 언급

// 8번 파일에서 다뤘던 함수를 '함수 선언문' 이라고 함

/*		↓함수 선언문↓
function sayHello(){
	console.log("Hello");
}
sayHello();				
*/

//		↓함수 표현식↓ 이라고 함

/*
let sayHello = function(){
	console.log("Hello");
}
sayHello();
*/

// 문법에는 어떤 차이가 있을까 ?! => 답은 '호출하는 타이밍'
// 함수 선언문은 JS내에 어디서든지 호출해서 사용할 수 있음 O
//		=> 어떻게 가능할까 ?
sayHello();				
function sayHello(){
	console.log("Hello");
}

// JS는 프로그램이 실행되기 전에 모~든 '함수선언문'을 찾아 한군데에 모아서
//	메모리에 저장하고 있다가 필요할 때 내부적으로 끌어올려서 사용하는 것
//	저장이 되어 있기 때문에 => 함수가 먼저 호출이 되어도 오류없이 잘 작동함 O
// 실제적으로 코드가 끌어올려지는 것은 아니고, 실제 메모리상에도 변화는 없음
//	이것을 '호이스팅(Hoisting)' 이라고 함(중요한 단어!!)

// '함수 표현식'은 코드에 도달하면 생성 (호이스팅 적용 x)
// '그래서 뭘 쓰면 되나요?' => 뭐가 좋다기 보다는 그냥 편하거 쓰세요~

// 화살표 함수
//	여지껏 봤던 함수들보다 더 간결하게 작성할 수 있는 함수

// 1.
var add = function(num1, num2){
	return num1 + num2;	
}

// 2.
var add = (num1, num2) => {
	return num1 + num2;
}

// 3. return을 생략 가능 O
var add = (num1, num2) => {
	num1 + num2;
}

// 4. 반환할 코드가 한 줄이라면 => 중괄호 생략 가능 O
var add = (num1, num2) => num1 + num2;

// 5. 파라미터가 하나라면... => 파라미터가 들어갈 소괄호 생략 가능 O
let sayHello2 = name => `Hello, ${name}`;

// 6. 파라미터가 없는 함수라면 괄호는 생략 가능 X
let asdf = () => console.log('asdf');
asdf();

// Function vs Method
let human = {
	name: "김겸",
	walk: function(){
		console.log("또각 또각");
	} // method : 객체 프로퍼티(속성)로 할당 된 함수	
}
human.walk();



