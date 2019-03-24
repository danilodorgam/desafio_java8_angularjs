'use strict';

export default class Router {
    constructor(routeName, opts) {
        this.routeName = routeName;
        this.states = [];
        this.addRoute(routeName, opts);
    }

    addRoute(routeName, opts) {
        if (opts && !opts.abstract)
            routeName = [this.routeName, routeName].join('.');

        this.states.push({name: routeName, state: opts});
    }

    route(){
        var self = this;
        let routeFn = function ($urlRouterProvider, $stateProvider) {
            $urlRouterProvider.otherwise('/home');
            self.states.forEach(function (route) {
               $stateProvider.state(route.name, route.state);
            });
        };

        routeFn.$inject = ['$urlRouterProvider', '$stateProvider'];

        return routeFn;
    }

}