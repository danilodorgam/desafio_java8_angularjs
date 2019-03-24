'use strict'
import TelefoneController from './telefone.controller'
import gridTemplate from "./views/telefone.template.html";

export default {
    templateUrl: gridTemplate,
    transclude: true,
    bindings:{
        id: '=', //id da questao
        callBack: '=',
        contexto: '=',
        edicao: '=?'
    },
    controller: TelefoneController,
    controllerAs: "vm"
};
