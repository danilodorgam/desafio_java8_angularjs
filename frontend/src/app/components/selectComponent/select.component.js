'use strict'
import SelectController from './select.controller'
import InputTemplate from "./views/select.template.html";

export default {
    templateUrl: InputTemplate,
    bindings:{
        identificador: '@',
        modelo: '=',
        formulario: '=',
        value: '@',
        descricao: '@',
        listagem: '=',

        tamanhoPc: '@',
        nome: '@?',
        obrigatorio: '=?',
        disabilitado: '=?'

    },
    controller: SelectController,
    controllerAs: "vm"
};
