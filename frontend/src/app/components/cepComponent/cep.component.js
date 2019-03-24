'use strict'
import CepController from './cep.controller'
import InputTemplate from "./views/cep.template.html";

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
    controller: CepController,
    controllerAs: "vm"
};
