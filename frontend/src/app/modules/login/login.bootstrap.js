'use strict';

function LoginBootstrap($rootScope) {

}

LoginBootstrap.$inject = ['$rootScope'];

export default angular
    .module(process.env.APP_NAME)
    .run(LoginBootstrap);