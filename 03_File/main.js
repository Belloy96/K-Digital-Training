const fs = require('fs');

// 파일 쓰기

// writeFile() : 파일이 존재하지 않으면 파일을 생성하고 내용을 적어냄
// 이어쓰기 기능 X => appendFile() (이어쓰기)

let data = '파일 시스템 예제!';

// console.log('파일을 생성합니다.');

// fs.writeFile('text1.txt', data, 'utf-8', function(error){
//     // 에러가 발생했다면 에러를 호출함
//     if (error) {
//         throw error
//     }
//     // 정상적으로 만들었으면
//     console.log('파일이 생성되었습니다.');
// });
// console.log('파일 생성 중...');

// 위의 코드를 실행했을 때
// 파일을 생성합니다
// 파일 생성 중...
// 파일이 생성되었습니다.
// 순서로 실행되었음을 알 수 있음!

// 이건 Node.js 개발자의 빅픽쳐!!!
// 이렇게 소스코드의 작동순서가 위에서 아래로 순차대로
// 실행되지 않는 이 상황을 비동기(Async)라고 함 <- 상당히 중요한 개념!!
// 쉽게 말하면 순서의 작동을 보증하지 않는다는 뜻!

// 그 사람은 왜 때문에 이렇게 만든거죠...?

// 이 비동기 방식은 이런 현상을 없애줍니다 (렉)
// 파일을 생성하면서, 동시에 다른 작업도 가능하게 해줌

// Q. 볼일이 너무 급한데, 화장실에 줄이 길게 서있다.
//      어떻게 해결할 것인가???
//  하남자특) 화장실 칸을 늘림
//  상남자특) 문따고 들어가서 같이 볼일봄 ㄹㅇㅋㅋ

// 암튼 이 비동기의 장점은 간단한 작업을 하기 위해서
// 오래 걸리는 작업을 기다릴 필요가 없는 것임!!!

// fs.unlink('text1.txt', function(error){
//     if (error) {
//         throw error
//     }
//     console.log('파일 삭제 성공!')
// })
// => node main.js => 위의 코드 주석처리

// 근데 '난 렉이 걸려도 순서대로 진행되는게 좋은데요?'
//  => fs.writeFileSync() !!

// console.log('파일을 생성합니다.');
// console.log('파일 생성 중...');
// fs.writeFileSync('text1.txt', data); // encoding 기본값이 utf-8
// console.log('파일이 생성되었습니다.');

// 파일 읽기
// fs.readFile('text1.txt', 'utf-8', function(error, data) {
//     if (error) {
//         throw error
//     }
//     console.log(data);
// })

// 파일 이어서 쓰기
fs.appendFile('text1.txt', '\n데이터 추가하기!', function(error){
    if (error) {
        throw error
    }
    console.log('이어쓰기 끝 !')
})

