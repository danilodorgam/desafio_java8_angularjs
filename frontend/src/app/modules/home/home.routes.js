'use strict';

import Router from '../../../core/Router';
import Template from '../../assets/layout/app.html';
import Home from './views/dashboard.html'

let loadModule = function(){
    let resolve = function ($q, $ocLazyLoad) {
        return $q(function (resolve) {
            require.ensure([], () => {
                let module = require('./home.module').default;
                $ocLazyLoad.load({name: module.name});
                resolve(module.name);
            });
        });
    };

    resolve.$inject = ['$q', '$ocLazyLoad'];
    return resolve;
};

/*Default Routes*/

let homeRoute = new Router('main', {
    url: '',
    templateUrl: Template,
    abstract: true,
    resolve: {defaultModule: loadModule()}
});



homeRoute.addRoute('home', {
    url: '/home',
    templateUrl: Home,
    controller: 'home.HomeController as vm',

});


export default angular
    .module('home.routes', [])
    .config(homeRoute.route());

