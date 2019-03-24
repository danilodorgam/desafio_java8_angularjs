'use strict'
import InputController from './input.controller'
import InputTemplate from "./views/input.template.html";

export default {
    templateUrl: InputTemplate,
    bindings:{
        identificador: '@', //idenficador do input
        tipo: '@', //tipo do input
        modelo: '=', //ngModel
        tamanhoMaximo: '@', //lenght do input
        formulario: '=', //form

        tamanhoPc: '@', //tamanho da grid
        tamanhoMinimo: '@?', //lenght do input
        nome: '@?', //label
        obrigatorio: '=?',
        disabilitado: '=?'

    },
    controller: InputController,
    controllerAs: "vm"
};
