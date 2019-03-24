'use strict';

import Router from '../../../core/Router';
import Template from '../../assets/layout/blank.html';
import LoginView from './views/login.html'

let loadModule = function(){
    let resolve = function ($q, $ocLazyLoad) {
        return $q(function (resolve) {
            require.ensure([], () => {
                let module = require('./login.module').default;
                $ocLazyLoad.load({name: module.name});
                resolve(module.name);
            });
        });
    };

    resolve.$inject = ['$q', '$ocLazyLoad'];
    return resolve;
};

/*Default Routes*/

let loginRouter = new Router('login', {
    url: '/login',
    templateUrl: Template,
    abstract: true,
    resolve: {defaultModule: loadModule()}
});



loginRouter.addRoute('autenticar', {
    url: '/autenticar',
    templateUrl: LoginView,
    controller: 'login.LoginController as vm'
});



export default angular
    .module('login.routes', [])
    .config(loginRouter.route());

