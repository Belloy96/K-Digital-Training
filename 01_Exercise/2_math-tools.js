// 모듈(Module)이란 ?
//  하나의 프로그램을 이루는 하나하나의 조각
//  일반적으로 JS파일 하나를 일겉음
//  (라이브러리의 너낌!)
// 이 모듈은 두 가지의 종류로 나뉘게 되는데

// 1. 내가 직접 만든 모듈
//      말 그대로 내가 만든 모듈
// 2. 이미 만들어져 있는 모듈
//      은 또 누가지의 종류로 나뉘는데...
//      1. 외장모듈
//      개발자들이 만들어 놓은 모듈
//      이 외장모듈을 사용하기 위해서는
//      NPM(Node Package Manager)이라는 것을 사용함
//      JS 개발자들이 유용한 패키지들을 만들어두었고,
//      그 코드들이 공개되어 있는 곳이 NPM!
//      제 3자가 만든 모듈이라는 의미에서
//      서드파티(3rd-party) 모듈이라고도 함

//      2. 내장모듈
//      Node를 설치하고 나면 기본적으로 제공해주는 모듈
//      따로 NPM을 사용하지 않음
//      코어(core) 모듈이라고도 함

// function add(a, b) {
//     return a + b;
// }

// add 함수를 모듈 외부로 공개하기!
// export : 내보내다

// exports.add = add;
//  앞에 있는 add : 모듈 외부로 공개할 이름
//  뒤에 있는 add : 모듈 내부에서의 이름

exports.PI = 3.141592;
exports.add = function add(a, b) {return a + b};
exports.substract = function substract(a, b) {return a - b};
exports.multiply = function multiply(a, b) {return a * b};
exports.divide = function divide(a, b) {return a / b};

// 객체로 표현하기
let calculator = {
    PI: 3.141592,
    add: (a, b) => a + b,
    substract: (a, b) => a - b,
    multiply: (a, b) => a * b,
    divide: (a, b) => a / b,
}

module.exports = calculator;
// 위에서 만든 내용을 전부 다 하나의 객체에 넣어버렸음
//  => calculator라는 객체의 속성과 메소드가 되었음
// 또한 이 객체 자체를 그대로 외부의 공개를 함

//  exports : 공개하고 싶은 것을 하나씩 공개할 때
//      exports.속성 = 값
//  module.exports : 공개하고 싶은 것들을 모아서 하나의 객체로
//                   만들어서 공개할 때
//      module.exports = 객체

