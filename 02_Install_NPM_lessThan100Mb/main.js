// NPM은 Node Package Mangaer의 약자로,
// node로 생성한 패키지/프로젝트를 관리하는 도구

// npm init -y : npm을 쓸 수 있는 초기 환경을 설정
// // -y : 일일이 입력해서 설정한 후 yes 입력해야 하는데
//          입력없이 한 번에 처리해줌
// 그리고 이러한 패키지 / 프로젝트 정보를 가지고 있는 것이
//      생성된 package.json 파일

// package.json에 있는 내용을 복붙해서 주석처리함
// {
//     "name": "02_install_npm",    // 이 프로젝트의 이름
//     "version": "1.0.0",          // 이 프로젝트의 버전
//     "main": "main.js",           // 진입점이 되는 모듈
//     "scripts": {                 // 스크립트에 대한 명령어
//       "test": "echo \"Error: no test specified\" && exit 1"
//     },
//     "keywords": [],              // 패키지를 문자열 배열로 설명해줌
//     "author": "",                // 작성자
//     "license": "ISC",            // 패키지에 대한 권한
//     "description": ""            // 이 프로젝트에 대한 설명
//     "dependencies": ""           // 모듈 의존성
//   }

// 3rd party module 불러오기
// 터미널에 npm install cowsay
//  package-lock.json이 생기고, package.json 둘 다
//  cowsay에 대한 dependencies가 생긴 것이 확인 됨!
// package-lock.json : 나중에 이 프로젝트를 배포할 때,
//                      이 프로젝트에 필요한 모듈의 버전을 명시해둔 곳
//  이걸 토대로 다른 컴퓨터에서 이 프로젝트를 실행할 때
//  그 내용을 바탕으로 npm install 하면
//  관련된 모듈들이 한 번에 설치가 됨!!

const cowsay = require('cowsay');
console.log(cowsay.say({
    text : 'I Love Sogogi!',
}));
// 터미널에서 node main.js 실행











