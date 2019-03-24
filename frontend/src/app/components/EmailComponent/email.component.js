'use strict'
import EmailController from './email.controller'
import gridTemplate from "./views/email.template.html";

export default {
    templateUrl: gridTemplate,
    transclude: true,
    bindings:{
        id: '=', //id da questao
        callBack: '=',
        contexto: '=',
        edicao: '=?'
    },
    controller: EmailController,
    controllerAs: "vm"
};
