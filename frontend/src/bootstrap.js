'use strict';


function Bootstrap($rootScope, $location, DTOptionsBuilder,$state) {
    $rootScope.pageTitle = 'Desafio';
    $rootScope.app = {
        name: 'Desafio',
        description: 'Desafio em Java8 (Spring e Spring Boot) + Angularjs',

    };
    $rootScope.datatable = {};

    $rootScope.logout = () => {
        window.sessionStorage.removeItem("token")
        $state.go("login.autenticar");
    }

    $rootScope.datatable.options = DTOptionsBuilder
        .newOptions()
        .withLanguage(require('./app/i18n/datatable.pt_BR.json'))
        .withOption('bFilter', true)
        .withOption('bLengthChange', true)
        .withOption('ordering', true)
        .withBootstrapOptions();
}

Bootstrap.$inject = ['$rootScope', '$location', 'DTOptionsBuilder','$state'];

export default angular.module(process.env.APP_NAME).run(Bootstrap);
