// 2. 자료형
// ▶ 문자형 String

let name1 = "Belloy";
let name2 = 'Belloy';
let name3 = `Belloy`; // ~ 표시할 때 shift 안누른 키 `` (backtick)

let message1 = "I'm a boy.";
let message2 = 'I\'m a boy.'; // 작은 따옴표를 사용 시 \ 역슬래시를 넣으면

// 문자열 내부에 변수를 표현할 때 사용하면 좋은 backtick!
//	${변수명} 을 넣어서 표현함
let message3 = `My name is ${name1}`;
document.write(message3 + '<br>');
let message4 = "My name is ${name1}";
document.write(message4 + '<br>'); // ${name1}이 그대로 노출됨...

// 계산 (표현식) 도 사용가능
let message5 = `I am ${100 + 99} years old.`;
document.write(message5 + '<br>');
document.write('-----------------------------<br>')

// ▶ 숫자형 Number (정수 / 실수)
let age = 100;
let height = 187.3;

// 역시나 사칙연산이 가능 O
document.write(1 + 2 + "<br>");
document.write(1 - 2 + "<br>");
document.write(1 * 2 + "<br>");
document.write(1 / 2 + "<br>");
document.write(6 % 4 + "<br>");

let a = 1 / 0;
document.write(a + "<br>"); // Infinity(무한대)

let b = name1 / 2;
document.write(b + "<br>"); // NaN : Not a Number : 숫자가 아니다

// + 연산자로 글자끼리 이어주기도 가능 O
let aa = "나는";
let bb = " 입니다";
document.write(aa + name1 + bb + '<br>');
document.write(aa + age + '살' + bb + '<br>');
document.write('-----------------------------<br>')

// ▶ 논리형 Boolean
let c = true;		// 참
let d = false;		// 거짓

document.write((name1 == "Belloy") + '<br>')
document.write((age < 20) + '<br>')
document.write('-----------------------------<br>')

// ▶ null, undefined
let e;
document.write(e + '<br>');		// undefined : 값이 할당되지 않은 상태

let f = null;
document.write(f +'<br>');		// null : 존재하지 않는 값
document.write('-----------------------------<br>');

// ▶ typeof 연산자 : 변수의 자료형을 알아낼 때 사용
//	직접 코드를 짰으면 당연히 이 연산자는 쓸모 X
//	다른 개발자가 코드를 짰을 때, 변수에 대한 데이터타입(자료형)을 알아야 할 때
//	or API를 통해서 받아온 데이터의 자료형을 알아내서 다른 방식으로 처리해야 할 때
document.write(typeof name1 + '<br>');
document.write(typeof age + '<br>');
document.write(typeof c + '<br>');
document.write(typeof e + '<br>');
document.write(typeof f + '<br>');		// null값은 하나의 객체인 object로 봄




