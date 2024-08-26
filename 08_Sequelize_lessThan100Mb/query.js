// SQL문을 시퀄라이즈로 작업하기!
const { User } = require('../models'); // models 폴더에 있는 것들 사용 가능!
// 1. insert into beaver.users (name, age, married, comment) values ('beaver', 35, 0, '안녕하새우!');
User.create({
    name: 'beaver',
    age: 35,
    married: false,
    comment: '안녕하새우!',
});

// 2. select * from beaver.users;
// findAll 메소드 !
User.findAll({});

// 3. 단일 데이터 가져오기
// select * from beaver.users limit 1; => limit = oracle의 rownum
// findOne 메소드 !
User.findOne({});

// 4. attributes 옵션을 사용해서 원하는 컬럼만을 가져올 수 있음
// select name, married from beaver.users;
User.findAll({
    attributes: ['name', 'married'],
});

// 5. 조건 검색
// select name, age from beaver.users where married = 1 and age > 30;
// const { Op } = require('sequelize');
const { User } = require('../models');
User.findAll({
    attributes: ['name', 'married'],
    where: {
        married: true,
        age: { [Op.gt]: 30},
    }
});

// mysql 에서는 undefind 자료형을 지원하지 않아서 빈 값을 넣고자 한다면 null을 사용할 것 !
// 연산자 관련
// Sequelize 객체 내부의 Op 객체를 불러왔고
// Op.gt (초과) / Op.gte (이상) / Op.lt (미만) / Op.lte (이하)
// Op.ne (같지 않음) / Op.or (또는) / Op.in (배열 요소중 하나) / Op.notIn (배열 요소와 모두 다름)
// 정도의 연산자가 자주 사용 됨

// Op.or 예시
// select id, name from users where married = 0 or age > 30;
User.findAll({
    attributes: ['id', 'name'],
    where: {
        [Op.or] : [{ married: false}, { age : { [Op.gt]: 30} },]
    }
});

// 6. Update
// update beaver.users set cmt = '바꿀 내용' where id = 2;
User.update({
    comment: '바꿀 내용',
}, {
    where: { id: 2 },
});

// 첫번째 파라미터는 수정할 내용, 두번째 파라미터는 어떤 데이터를 바꿀지 특정

// 7. Delete
// delete from beaver.users where id = 2;
User.destroy({
    where: { id : 2},
});

// ----------------------------------------------------
// 관계 쿼리
// 현재 User 모델은 Comment 모델과 hasMany - belongsTo 관계
// 이 때 특정 사용자를 가져오면서 그 사람의 댓글까지 모두 가져오고 싶다면 include 속성을 사용 !
const user = User.findOne({
    include: [{
        model: Comment,
    }]
});















