const expres = require('express');
const router = expres.Router();

router.get('/', (req, res) => {
    res.send('e에 접근 !');
});

router.get('/1', (req, res) => {
    res.send('path : /e/1');
});

router.get('/2', (req, res) => {
    res.send('path : /e/2');
});

router.get('/3', (req, res) => {
    res.send('path : /e/3');
});

module.exports = router;

