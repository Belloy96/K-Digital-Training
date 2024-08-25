// 세션 (Session)
// 쿠키와 세션의 차이는 데이터의 저장 장소임!
// 쿠키는 데이터를 브라우저에 저장하는 반면,
// 세션은 서버에 저장
// 그런데 HTTP는 상태를 저장하지 않기 때문에 
// 각 사용자를 식별해줄 수 있는 값이 필요한데...=> 쿠키!!!
// 그 정보를 '세션 쿠키' 라고 함

// 특징
//   - 세션은 서버에 저장됨
//   - 서버는 세션쿠키로 사용자를 식별함
//   - 세션'쿠키'이기 때문에 브라우저가 종료되면 세션쿠키도 사라짐

const express = require('express');
const morgan = require('morgan');
const cookieParser = require('cookie-parser');
const nunjucks = require('nunjucks');
const session = require('express-session');

const app = express();

app.use(morgan('dev'));
app.use(cookieParser());
app.use(session({
    // 요청이 왔을때 세션에 수정사항이 생기지 않아도 다시 저장할지 여부
    resave : true,
    // 세션이 저장할 내역이 없더라도 세션을 저장할지 여부
    saveUninitialized : false,
    // 쿠키 암호화
    secret : 'secretkk',
    // 쿠키 설정과 동일함
    cookie : {
        httpOnly : true,
        secure : false,
    },
    // 세션쿠키 이름 (connect.sid가 기본값)
    name : 'ean-cookie',
    // store : 세션 저장소, 기본값은 메모리
}));
app.use(express.json());
app.use(express.urlencoded({ extended : true}));
app.set('view engine', 'html');
nunjucks.configure('views', {

    express : app,
    watch : true,
});

app.get('/', (req, res)=>{
    const { user } = req.session; // 세션값들을 다 볼 수 있음
    if (user) {
        res.render('login', { user });
        return;
    }
    res.render('index');
});

// 이름 등록 
app.post('/', (req, res)=>{
    const { name } = req.body;
    req.session.user = name;
    res.redirect('/');
    // 개발자모드 - Application - Storage - Cookies 에서 확인
});

// 세션 삭제
app.get('/delete', (req, res)=>{
    req.session.destroy(); // 세션 모두 제거
    res.redirect('/');
});

// 세션 데이터 확인
app.get('/lookSession', (req, res)=>{
    res.render('sessionData', { sessions: req.session });
});

// 세션 데이터 추가
app.get('/addSession', (req, res)=>{
    req.session.addData = 'addData';
    console.log(req.sessionID);
    res.redirect('/');
});


app.listen(3000, ()=>{
    console.log('3000번 포트 작동 중');
})







