'use strict';

function Bootstrap($rootScope) {

}

Bootstrap.$inject = ['$rootScope'];

export default angular
    .module(process.env.APP_NAME)
    .run(Bootstrap);