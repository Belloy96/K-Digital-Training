const mongoose = require('mongoose');

const connect = () => {

  // 개발 환경일 때만 콘솔을 통해 몽구스가 생성하는 쿼리 내용을 확인할 수 있는 코드
  if (process.env.NODE_ENV !== 'production') {
    mongoose.set('debug', true);
  }

  // 몽구스와 몽고디비를 연결
  // 주소 형식은 mongodb://[username:password]@[IP Address]:[Port]/[Database]
  // 접속을 시도하는 주소의 데이터베이스는 admin이지만, 실제로 사용할 데이터베이스는 nodejs이어서
  // dbName 옵션을 줘서 nodejs 데이터베이스를 사용하게 함
  mongoose.connect('mongodb://belloy:8230@localhost:27017/admin', {
    dbName: 'nodejs',
    useNewUrlParser: true, // { useNewUrlParser: true } 를 적지 않으면 deprecatedError 가 발생한다. 조만간 없어질 거니까 뭐 이렇게 하라는 것 같은데 일단 경고 메세지가 나오는게 보기 싫어서
  }).then(() => {
    console.log("몽고디비 연결 성공");
  }).catch((err) => {
    console.error("몽고디비 연결 에러", err);
  });
};

// 이벤트 연결 => 에러 발생시 에러 내용을 기록하고, 종료시 재연결을 시도함
// 실행시 MongooseServerSelectionError: connect ECONNREFUSED ::1:27017 => 데이터베이스 실행 안했을 때
//        MongoServerError : Authentication Failed => 비밀번호 틀렸을 때
// 주로 이런 에러가 발생함
mongoose.connection.on('error', (error) => {
  console.error('몽고디비 연결 에러', error);
});
mongoose.connection.on('disconnected', () => {
  console.error('몽고디비 연결이 끊겼습니다. 연결을 재시도합니다.');
  connect();
});

module.exports = connect;