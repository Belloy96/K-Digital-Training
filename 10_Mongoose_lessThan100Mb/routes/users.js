const express = require('express');
const User = require('../schemas/user');
const Comment = require('../schemas/comment');

const router = express.Router();

router.route('/')
  // get방식으로 데이터를 JSON형태로 반환
  .get(async (req, res, next) => {
    try {
      const users = await User.find({});
      res.json(users);
    } catch (err) {
      console.error(err);
      next(err);
    }
  })
  // POST방식으로 데이터를 등록 (.create({}) )
  // 정의한 스키마에 부합하지 않는 데이터를 넣지 않으면 에러!
  // _id는 자동으로 생성됨
  .post(async (req, res, next) => {
    try {
      const user = await User.create({
        name: req.body.name,
        age: req.body.age,
        married: req.body.married,
      });
      console.log(user);
      res.status(201).json(user);
    } catch (err) {
      console.error(err);
      next(err);
    }
  });

// 댓글 조회하는 라우터
// find옵션으로 댓글을 쓴 사용자의 아이디로 댓글을 조회한 후
// populate 메소드로 관련있는 컬렉선의 다큐먼트를 불러옴
// Comment 스키마 commenter 필드의 ref가 User로 되어 있으므로
// 자동으로 user 컬렉션에서 사용자 다큐먼트를 찾아서 합치게 됨 
router.get('/:id/comments', async (req, res, next) => {
  try {
    const comments = await Comment.find({ commenter: req.params.id })
      .populate('commenter');
    console.log(comments);
    res.json(comments);
  } catch (err) {
    console.error(err);
    next(err);
  }
});

module.exports = router;