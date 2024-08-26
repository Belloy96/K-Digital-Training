const express = require('express');
const app = express();

app.get('/', (req, res) => {
    res.send('START !');
});

// app.get('/a/1', (req, res) => {
//     res.send('path :  /a/1')
// });

// app.get('/a/2', (req, res) => {
//     res.send('path :  /a/2')
// });

// app.get('/a/3', (req, res) => {
//     res.send('path :  /a/3')
// });

// app.get('/b/1', (req, res) => {
//     res.send('path :  /b/1')
// });

// app.get('/b/2', (req, res) => {
//     res.send('path :  /b/2')
// });

// app.get('/b/3', (req, res) => {
//     res.send('path :  /b/3')
// });

// app.get('/c/1', (req, res) => {
//     res.send('path :  /c/1')
// });

// app.get('/c/2', (req, res) => {
//     res.send('path :  /c/2')
// });

// app.get('/c/3', (req, res) => {
//     res.send('path :  /c/3')
// });

// app.get('/d/1', (req, res) => {
//     res.send('path :  /d/1')
// });

// app.get('/d/2', (req, res) => {
//     res.send('path :  /d/2')
// });

// app.get('/d/3', (req, res) => {
//     res.send('path :  /d/3')
// });

// app.get('/e/1', (req, res) => {
//     res.send('path :  /e/1')
// });

// app.get('/e/2', (req, res) => {
//     res.send('path :  /e/2')
// });

// app.get('/e/3', (req, res) => {
//     res.send('path :  /e/3')
// });

// 만약 처리해야 할 요청이 무수히 많아진다면,
// 이 요청들을 하나의 파일에 관리하는 것은 쉽지 않을 것!
//  => 그렇다면 이 요청들을 어떻게 분리할 수 있을까 ?

// 라우터 파일을 인식할 수 있게 require() 메소드로
//  라우터 파일의 경로를 등록
const aRouter = require('./routes/a')
const bRouter = require('./routes/b')
const cRouter = require('./routes/c')
const dRouter = require('./routes/d')
const eRouter = require('./routes/e')

app.use('/a', aRouter);
app.use('/b', bRouter);
app.use('/c', cRouter);
app.use('/d', dRouter);
app.use('/e', eRouter);

app.listen(3000, () => console.log('서버 동작 중 !'));

// 가정) http://localhost:3000/e/2로 요청이 들어왔다고 가정
//  1) index.js의 app.use('/e', eRouter)에서 요청을 가로챔
//  2) ./routes/e 로 요청 이동
//  3) e.js의 router.get('/2', function(...)) 요청 이동
//  4) 웹 페이지에 'path : /e/2' 출력

// 에러처리
// 라우터에서 설정되어있지 않는 주소로 접속하려 할 때
app.all('*', (req, res) => {
    res.status(404).send('404 ! Page Not Found !');
})







