'use strict'
import MensagemController from './mensagem.controller'
import gridTemplate from "./views/mensagem.template.html";

export default {
    templateUrl: gridTemplate,
    bindings:{
        formulario: '=',
        identificador: '@'

    },
    controller: MensagemController,
    controllerAs: "vm"
};
