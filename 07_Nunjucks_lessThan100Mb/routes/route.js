const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
    res.render('index', { title: 'Nunjucks', content: '테스트 중 !'});
});

module.exports = router;