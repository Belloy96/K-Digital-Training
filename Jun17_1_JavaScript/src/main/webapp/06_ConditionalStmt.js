// 논리연산자, 비교연산자, 일치연산자 결과값으로 나온 true, false를 가지고...
// 6. 조건문
//	어떤 조건에 따라서 이후에 실행이 달라지게 하는 문법!

// if문 (Java와 같다)
//	if절 괄호 안에 조건을 따져서 true라면 실행하게끔!
// if - else if - else
//		... 예제 생략 ㅎ_ㅎ

// switch-case
//	case가 다양할 때, 보다 간결하게 나타낼 수 있는 장점

/*switch(변수명 or 값) {
	case 값1:
		내용
	case 값2:
		내용
	...
	default:
		내용
}*/

// 사과 : 100원
// 바나나 : 200원
// 키위 : 300원
// 멜론 : 500원
// 수박 : 500원
// 사고 싶은 과일을 입력(prompt)해서 그 가격을 출력(alert)

// 내 답안
/*
let input = prompt("과일 이름 하나를 입력해주세요");
switch(input) {
	case "사과":
		document.write('100원');
		break;
	case "바나나":
		document.write('200원');
		break;
	case "키위":
		document.write('300원');
		break;
	case "멜론":
		document.write('500원');
		break;
	case "수박":
		document.write('500원');
		break;
	default:
		document.write('없는 과일이거나 두개 이상 입력했습니다');
		break;
}
*/

// 강사님 답안

let fruit = prompt("과일을 입력하세요.");

switch (fruit) {
	case "사과":
		alert(`${fruit} : 100원`);
		break;
	case "바나나":
		alert(`${fruit} : 200원`);
		break;
	case "키위":
		alert(`${fruit} : 300원`);
		break;
	case "멜론":
	case "수박":
		alert(`${fruit} : 500원`);
		break;
	default:
		alert(`${fruit}...? 그런거 없는데요?`)
		break;
}



