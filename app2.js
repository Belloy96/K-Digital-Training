// 자주 사용하는 미들웨어 !

// npm install morgan cookie-parser express-session

const express = require('express');
const morgan = require('morgan');
const path = require('path');

const app = express();

// morgan - 요청과 응답에 대한 정보를 콘솔에 알려줌
app.use(morgan('dev'));
// GET / 200 2.732 ms -21
// 는 각각 [요청방식] [주소] [응답상태코드] [응답속도] - [응답바이트]

// app.get('/', (req,res)=>{
//     res.send('연결완료');
// });

app.get('/', (req,res)=>{
    res.sendFile(path.join(__dirname,'/index.html'));
}); // 이 경우에는 css가 적용안됨 

// css의 적용을 위해서 는 static이라는 미들웨어가 필요한데
//  정적(static) 파일을 제공하는 역할을 해줌
// express 객체 안에 있는 기능이라서 꺼내서 쓰기만 하면 됨
// app.use('요청경로', express.static('실제경로')); 로 사용

// 이 프로젝트에 'css'라는 폴더를 만들어서 css파일 넣어주기!
app.use('/', express.static(path.join(__dirname,'css')));

app.listen(3000,()=>{
    console.log('3000번 포트에 연결됨');
});

