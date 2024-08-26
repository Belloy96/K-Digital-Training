const express = require('express');
const User = require('../schemas/user');

const router = express.Router();

// User.find({}) 로 모든 사용자를 찾은 후에
// mongoose.html을 렌더링할 때 users 변수로 넣음
router.get('/', async (req, res, next) => {
  try {
    const users = await User.find({});
    res.render('mongoose', { users });
  } catch (err) {
    console.error(err);
    next(err);
  }
});

module.exports = router;