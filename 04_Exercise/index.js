// http 모듈은 node에 내장되어있는 웹 관련 모듈!
// Spring때도 마찬가지지만, 사용자는 요청하고 서버는 응답하는 구조

const http = require('http');

http.createServer((request, response) => {
    response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
    response.write('안녕 서버얌 ?');
    response.end();
}).listen(3000); 

// 터미널에서 node index.js로 실행하기
// http 모듈도 괜찮은데, 이것보다 더 좋은 모듈도 있음!
// express라는 것인데
//  Python의 Flask/Django, Java의 Spring/SpringBoot처럼
//  JavaScript 에서 사용하는 웹 프레임워크의 종류 중 하나
// Express 프레임워크는 코드의 양을 줄여주고 
//  나중에 유지보수를 쉽게 하도록 만들어줌
// 터미널에서 Ctrl + C눌러서 서버 종류 후
//  => npm init -y 로 package.json 생성
//  => npm install express 설치
//  => package.json 파일에 dependencies 확인 후
//  => app.js 만들기















