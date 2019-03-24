'use strict'
import FormController from './form.controller'
import gridTemplate from "./views/form.template.html";

export default {
    templateUrl: gridTemplate,
    transclude: true,
    bindings:{
        formulario: '=', //form
        metodoSubmit: '=',
        contexto: '='
    },
    controller: FormController,
    controllerAs: "vm"
};
