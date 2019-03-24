'use strict';

export default class Module {
    constructor(moduleName, deps, bootstrap = null) {
        this.module = angular.module(moduleName, deps);
    }

    bootstrap(bootstrapFn){
        this.module.run(bootstrapFn);
    }

    getModule(){
        return this.module;
    }

    setControllers(...controllers) {
        var self = this;
        controllers.forEach(function (controller) {
            self.module.controller(controller[0], controller[1]);
        });
    }
}