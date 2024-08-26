// 라우터 (Router)
// express에서 라우팅이라는 개념은 클라이언트로부터 요청받은
//  URL과 View를 매칭시키는 것
// express 이전에 라우터를 만들 때에는 if문으로 각 영역을 분리했기에
// 가독성이 좋지 않고 기능을 확장하기도 어려웠음

// app.get() 방식으로 routing을 할 경우,
//  하나의 js파일 내에서 모든 routing을 처리해야 함
// expresss.Router 클래스는 'MiddleWare' 이기 때문에,
//  경로별로 js파일을 만들어서 router들을 관리할 수 있음

const expres = require('express');
const router = expres.Router();

router.get('/', (req, res) => {
    res.send('a에 접근 !');
});

// 지금 경로가 '/' 로 되어있는데 이유는
// app.use('/a', aRouter) 에서 /a 들어오면 aRouter가
//  실행되도록 설정을 해놓을 것

router.get('/1', (req, res) => {
    res.send('path : /a/1');
});

router.get('/2', (req, res) => {
    res.send('path : /a/2');
});

router.get('/3', (req, res) => {
    res.send('path : /a/3');
});


module.exports = router;



