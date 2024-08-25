
const express = require('express');
const morgan = require('morgan');
const nunjucks = require('nunjucks');
const bodyParser = require('body-parser');
const fs = require('fs');
const path = require('path');
const multer = require('multer')

const app = express();

// 이미지 불러오기
app.use('/uploads', express.static('uploads'));

app.use(morgan('dev'));
app.use(express.json());
app.use(express.urlencoded({extended : true}));
app.set('view engine', 'html');
nunjucks.configure('views', {
    express : app,
    watch : true,
});

try {
    fs.readdirSync('uploads'); // 폴더 확인
} catch (err) {
    console.log('uploads 폴더가 없습니다. 폴더를 생성합니다');
    fs.mkdirSync('uploads'); //폴더생성
}

const upload = multer({
    storage : multer.diskStorage({ // 저장할 공간 정보 : 하드디스크에 저장
        destination(req,file,done) { // 저장 위치
            done(null, 'uploads/'); // uploads라는 폴더안에 저장
        },
        filename(req,file,done) { // 파일명을 어떤 이름으로 올릴지
            const ext = path.extname(file.originalname); // 파일의 확장자
            done(null, path.basename(file.originalname, ext)+ext); // 파일이름 + 확장자 이름으로 저장
        }
    }),
    limits : {fileSize : 10*1024*1024}
});


app.get('/', (req,res)=> {
    res.send('kkk');
});

app.get('/upload', (req, res)=>{
    res.render('upload')
});

// 위에서 설정한 upload 객체 변수를 라우터에 장착
// 파일 업로드 같은 동작은 특정한 라우터에서 일어나기 때문에
// 굳이 app.use()에는 장착하지는 않는 편
// upload.single('image')
//  : 'image'이름은 upload.html의 <input type ="file" name="image">
//      에서 폼데이터 이름으로 온 것!
app.post('/upload', upload.single('image'),(req, res)=>{

    // upload.singe('image')의 업로드 정보가 req.file에 있고
    // <input type="text" name ="title">의 텍스트 정보가
    //      req.body에 있음
    console.log(req.file, req.body);
    // 주소로 불러올때는 꼭 http:// 프로토콜 적어주기!!
    res.send('<img src=http://localhost:3000/uploads/'
        + req.file.originalname + '>');
});


app.listen(3000, ()=> {
    console.log('서버 동작 중');
});

// multer (이미지 / 파일 업로드를 위한 모듈)
// npm install multer@1.4.4 설치 (이상버전에서는 한글이 깨짐)
// multer 패키지 안에는 여러 종류의 미들웨어가 들어있음

// storage는 저장할 공간에 대한 정보. 디스크나 메모리에 저장 가능
//  diskStorage는 하드디스크에 업로드 파일을 저장한다는 것
// destination는 저장할 경로
// filename은 저장할 파일명 (파일명+확장자 형식)
// limits는 파일 갯수나 파일 사이즈를 제안할 수 있음

// done()은 함수인데, 미들웨어에서 사용하는 next()와 비슷하게
// 다음 미들웨어로 작업을 넘기도록 하고,
// done()의 첫번쨰 파라미터로는 에러가 있다면 에러를 넣고,
// 두번쨰 파라미터로는 실제 경로나 파일의 이름 넣어주면 되고
// req나 file의 데이터를 가공해서done으로 넘기는 방식임!!

// 업로드를 활용하기 위해서는 서버에 uploads 폴더가 꼭 존재해야 함!!



