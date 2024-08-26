const expres = require('express');
const router = expres.Router();

router.get('/', (req, res) => {
    res.send('b에 접근 !');
});

router.get('/1', (req, res) => {
    res.send('path : /b/1');
});

router.get('/2', (req, res) => {
    res.send('path : /b/2');
});

router.get('/3', (req, res) => {
    res.send('path : /b/3');
});

module.exports = router;


