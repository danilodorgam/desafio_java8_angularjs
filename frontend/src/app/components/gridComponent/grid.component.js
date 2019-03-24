'use strict'
import GridController from './grid.controller'
import gridTemplate from "./views/grid.template.html";

export default {
    templateUrl: gridTemplate,
    transclude: true,
    bindings:{
        tamanhoPc: '=',
        obrigatorio: '=?'

    },
    controller: GridController,
    controllerAs: "vm"
};
