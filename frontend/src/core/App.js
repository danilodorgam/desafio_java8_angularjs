'use strict';

export default class App {
    constructor(appName, deps = [], get = false) {
        this.appName = appName;
        this.deps = deps;

        this.app = get && angular.module(this.appName) || angular.module(this.appName, deps);
    }

    addModule(m, route) {
        let resolve = function ($q, $ocLazyLoad) {
            return $q(function (resolve) {
                require.ensure([], () => {
                    let module = require('../app/modules/' + m + '/module').default;
                    $ocLazyLoad.load({name: module.name});
                    resolve(module.name);
                });
            });
        };

        resolve.$inject = ['$q', '$ocLazyLoad'];
        return resolve;
    }

    bootstrap(bootstrap = null) {
        bootstrap && this.app.run(bootstrap);
        angular.bootstrap(document, [this.appName], {strictDi: true});
    }

    addConfig(configFn) {
        this.app.config(configFn);
    }

    setRouter(...routes) {
        var self = this;
        routes.forEach(function (route) {
            self.addConfig(route);
        });

    }

    setHtml5Mode(set = true) {
        this.app.config(this.html5Mode(set));
    }

    html5Mode(set) {
        let html5mode = function($locationProvider){
            $locationProvider.html5Mode(true);
        };
        html5mode.$inject = ['$locationProvider'];
        return html5mode;
    }

    static get(appName){
        return new App(appName, [], true);
    }
}