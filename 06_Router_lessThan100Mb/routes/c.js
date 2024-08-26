const expres = require('express');
const router = expres.Router();

router.get('/', (req, res) => {
    res.send('c에 접근 !');
});

router.get('/1', (req, res) => {
    res.send('path : /c/1');
});

router.get('/2', (req, res) => {
    res.send('path : /c/2');
});

router.get('/3', (req, res) => {
    res.send('path : /c/3');
});


module.exports = router;

