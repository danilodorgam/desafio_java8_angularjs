'use strict';

function restangularConfig($httpProvider, RestangularProvider) {
    RestangularProvider.setBaseUrl(process.env.REST_BASE);
    RestangularProvider.setDefaultHttpFields("")
}

function RestangularRun(Restangular, $state, $rootScope,toastr) {
    Restangular.addFullRequestInterceptor(function (element, operation, route, url, headers, params, httpConfig) {
        let sessionStorage = window.sessionStorage;

        if(url.search("ws") < 1) {
            var isLogado = sessionStorage.getItem("token")
            if(!isLogado){
                $state.go("login.autenticar")
            }
            headers = {
                'Authorization': 'Basic ' + isLogado
            };
        }

        return {
            element: element,
            params: params,
            headers: headers,
            httpConfig: httpConfig
        };
    });

    Restangular.setErrorInterceptor(
        function ( response ) {
            if ( response.status == 401 ) {
                sessionStorage.removeItem("token")
                toastr.error("Não logado","Usuario")
                $state.go("login.autenticar");
            }
            if ( response.status == 403 ) {
                sessionStorage.removeItem("token")
                toastr.error("sem permissão para essa ação","Usuario")
                $state.go("login.autenticar");
            }

        }
    );
}

RestangularRun.$inject = ['Restangular', '$state', '$rootScope','toastr'];

restangularConfig.$inject = ['$httpProvider', 'RestangularProvider'];

angular.module(process.env.APP_NAME).config(restangularConfig).run(RestangularRun);