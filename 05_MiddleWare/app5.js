const express = require('express');
const morgan = require('morgan');
const nunjucks = require('nunjucks');
const bodyParser = require('body-parser');

const app = express();

app.use(morgan('dev'));
app.use(express.json());
app.use(express.urlencoded({extended : true}));
app.set('view engine', 'html');
nunjucks.configure('views', {
    express : app,
    watch : true,
});

app.get('/', (req,res)=> {
    res.send('kkk');
});

app.get('/products/write', (req, res) => {
    res.render('write');
});

app.post('/products/write', (req, res) => {
    // res.send(req.body);
    res.send(req.body.name);
});

// body-parser란 ?
// node.js의 post 요청 데이터를 추출할 수 있도록 만들어주는 미들웨어
// Express 버전 4.16.0 부터는 body-parser 모듈이 express에 내장
// req.body : JSON 등은 데이터를 담을 때 사용
//  (주로 POST로 유저의 정보 OR 파일 업로드를 보냈을 때)
// bodyParser.json() ( = express.json() )
//   : 'applicaiton/json' 방식의 Content-Type 데이터를 받아줌
// bodyParser.urlencoded() (= express.urlencoded() )
//   : 

app.listen(3000, ()=> {
    console.log('서버 동작 중!');
});
