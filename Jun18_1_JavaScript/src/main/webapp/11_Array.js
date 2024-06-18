// 11. 배열
//	순서가 있는 리스트
let students = ["곽두팔", "이춘식", "김춘삼"];
console.log(students[1]); // 인덱스는 0부터 시작 !!!

// 배열은 문자뿐만 아니라, 숫자, 객체, 함수, ... 포함할 수 있음 
let arr = [
	"비버",
	3,
	false,
	{
		name: "비붜",
		age: 7,
	},
	function test(){
		console.log("TEST");
	},
];
console.log(arr);

// length : 배열의 길이
console.log(students.length);

let days = ["월", "화", "수"];
console.log(days);

// push() : 배열 끝에 추가 (여러개 가능 O)
days.push("목");
console.log(days);
 
// pop() : 배열 끝의 요소 제거
days.pop();
console.log(days);

// shift(), unshift() : 배열의 제일 앞에 있는 요소 제거 / 추가
days.unshift("일");
console.log(days);

days.shift();
console.log(days);
 
// unshift()는 여러개 요소들을 추가할 수 있음 !
days.unshift("목", "금", "토");
console.log(days);

// 날짜 객체
let today = new Date();
console.log(today);


