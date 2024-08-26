const express = require('express');
const morgan = require('morgan');
const { sequelize } = require('./modles');

const app = express();

// force : false // true라면 매번 새롭게 테이블을 생성
sequelize.sync ({ force: false })
    .then(() => {
        console.log('DB 연결 성공 !');
    })
    .catch((err) => {
        console.log(err);
    });

app.use(morgan('dev'));

app.listen(3000, () => {
    console.log('서버 동작 중 !');
});


