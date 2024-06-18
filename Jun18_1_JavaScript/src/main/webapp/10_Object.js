// 10. 객체 (Object)

// 제 이름은 '오빈규', 24살
let human = {
	name: "오빈규",
	age: 24,
}

// 객체는 중괄호 안에서 구성되며, key와 value값으로
//		구성된 프로퍼티(속성)가 들어감
// 각각 쉼표로 구분하고, 마지막에는 쉼표가 없어도 되지만,
// 나중에 이것저것 수정할 것을 생각하면 쉼표를 적어놓는 것도 괜찮음(문법적으로 문제 x)

// 접근
console.log(human.name);
console.log(human['age']);

// 추가
human.gender = "Male";
human['hairColor'] = "Black";

// 삭제
delete human.hairColor;
/////////////////////////////////////////
// 단축 프로퍼티
let name = "Beaver";
let age = 5;

/*
let person = {
	name: name,,
	age: age,
	gender: "Male",
}
*/

let person = {
	name,
	age,
	gender: "Male"
} // (이 때, key와 value에서 받아올 변수의 이름이 같아야)

console.log(person.nickname);
// 존재하지 않는 속성에 접근하면, 에러가 발생하는게 아닌 undefined가 나옴

// 이 때, 'in' 연산자를 사용하면 내가 찾는 속성이 있는지 확인할 수 있음
//	in : 어떤 값이 있는지 확인하는 용도
console.log('birthday' in person);	// false
console.log('age' in person);		// true

for (let key in person){		// let [key]에서 key는 변수명
	console.log(key);			// key값
	console.log(person[key]);	// value값
}

// 함수로 객체 만들기
function makeObject(name, age){
	return{
		name,
		age,
		hobby: "Game",
	}
}

let beaver = makeObject("Beaver", 5);
console.log(beaver);








