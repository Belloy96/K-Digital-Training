const express = require('express');
const path = require('path');

const app = express(); // 객체 생성
const port = 3000;

// get방식 요청
app.get('/', (req,res) => { // '/' 기본 주소값
    res.send('익스프레스 해윙?');
});

// url 추가하기
app.get('/ean', (req,res) => {
    res.send('아이엠이안');
});

app.listen(port, ()=>{
    console.log(`Express가 ${port}번 포트에서 동작 중!`); // 잘 작동하는가 확인
});


// 서버 껐다 켰다 귀찮음..
// nodemon 설치
// npm install -g nodemon
// -g : global (전역 전체) / 한번 설치해놓으면 계속 쓸 수 있음

// 라우터! (Router)
// 클라이언트의 요청 경로(path)를 보고
//  이 요청을 처리할 수 있는 곳으로 기능을 전달해주는 역할을 함
// 이러한 역할을 라우팅이라고 하는데
// 네트워크 용어, 어떤 네트워크 안에서
//      통신되는 데이터를 보낼 경로를 선택하는 과정
// 갈림길에서 어디로 가야할지를 선택하는 과정 !

// 단순한 문자열 대신에 HTML로 응답하고 싶다면
//  res.sendFile() 메소드를 활용하면 되는데
// 이 때, 파일의 경로를 path 모듈을 사용해서 지정하면 됨

app.get('/success', (req, res)=>{
    // __dirname : 현재 경로 위치
    // 에 있는 index.html 파일을 열러라!
    res.sendFile(path.join(__dirname, '/index.html'));
});










