// 템플릿(Template)이란 ?
// 모든 웹 사이트의 포괄적인 레이아웃 및 기능에 대한 구조를
//  보여주는 미리 디자인된 리소스
// 화면 이동 시 기본 틀은 한 번만 만들어놓고 계속해서 사용하는 것이 가능!
// Node.js의 대표적인 템플릿 엔진으로는 pug와 nunjucks가 있음
// 성능면에서는 pug가 렌더링 속도가 nunjucks보다 빠름,
// pug는 따로 html태그를 pug용 문법으로 변환해야 하지만,
// nunjucks는 html 문법을 그대로 사용하는 것이 가능 => 호환성 좋음

const express = require('express');
const nunjucks = require('nunjucks');
const testRouter = require('./routes/route');
const app = express();

app.use('/test', testRouter);

app.set('view engine', 'html');

nunjucks.configure('views', { // views 폴더가 Nunjucks 파일의 위치가 됨
    express: app,   // express 속성에 app 객체를 연결
    watch: true,    // true로 지정하면 HTML 파일이 변경될 때
                    // 템플릿 엔진을 reload 함
});

app.get('/', (req, res) => {
    res.send('START !');
});

app.get('/include', (req, res) => {
    res.render('main');
});
// http://localhost:3000/include

app.get('/extend', (req, res) => {
    res.render('body');
});
// http://localhost:3000/extend

// /test GET 방식 요청했을 때 => index.html + router 사용


app.listen(3000, () => console.log('서버 동작 중 !'));




