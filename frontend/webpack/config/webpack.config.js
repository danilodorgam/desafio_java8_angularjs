var path = require('path');
var plugins = require('./webpack.plugins');
var rules = require('./webpack.rules');

var config = {};

config.entry = {
    app: ['babel-polyfill', path.join(__dirname, '../../src/main.js')],
    vendor: [
        'angular',
        'jquery',
        'datatables.net',
        'angular-datatables',
        'angular-messages',
        'angular-toastr',
        'ui-router.grant',
        'oclazyload',
        'lodash',
        'restangular',
        'angular-i18n/angular-locale_pt-br.js',
        'angular-input-masks',
        'angular-translate',
        'ng-fx',
        'angular-sanitize',
        'angular-ui-bootstrap',
    ]
};

config.output = {
    filename: '[name].[hash].js',
    chunkFilename: '[name].[hash].bundle.js',
    path: path.join(__dirname, '../../build/')
}


config.module = {
    rules: []
};

config.module.rules = rules;
config.plugins = plugins;

module.exports = config;