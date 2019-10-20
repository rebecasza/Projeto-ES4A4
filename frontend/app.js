
const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
app.use(express.static(__dirname));

app.use(bodyParser.json()); 

app.use(function(req, res, next) {
    let err = new Error('Not Found');
    err.status = 404;
    next(err);
});

app.listen(3000, function () {
    console.log('Academic running on port 3000!');
});
module.exports = app;