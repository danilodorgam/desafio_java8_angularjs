'use strict';

import Router from '../../../core/Router';
import Template from '../../assets/layout/app.html';
import CadastrarClienteView from './views/cadastrar.cliente.html'
import PesquisarClienteView from './views/pesquisar.cliente.html'

let loadModule = function(){
    let resolve = function ($q, $ocLazyLoad) {
        return $q(function (resolve) {
            require.ensure([], () => {
                let module = require('./cliente.module').default;
                $ocLazyLoad.load({name: module.name});
                resolve(module.name);
            });
        });
    };

    resolve.$inject = ['$q', '$ocLazyLoad'];
    return resolve;
};

/*Default Routes*/

let clienteRouter = new Router('cliente', {
    url: '/cliente',
    templateUrl: Template,
    abstract: true,
    resolve: {defaultModule: loadModule()}
});



clienteRouter.addRoute('cadastrar', {
    url: '/cadastrar',
    templateUrl: CadastrarClienteView,
    controller: 'cliente.CadastrarQuestaoController as vm'
});

clienteRouter.addRoute('editar', {
    url: '/editar/{id: [0-9]+}',
    templateUrl: CadastrarClienteView,
    controller: 'cliente.CadastrarQuestaoController as vm'
});
clienteRouter.addRoute('visualizar', {
    url: '/visualizar/{id: [0-9]+}',
    templateUrl: CadastrarClienteView,
    controller: 'cliente.CadastrarQuestaoController as vm'
});


clienteRouter.addRoute('pesquisar', {
    url: '/pesquisar',
    templateUrl: PesquisarClienteView,
    controller: 'cliente.PesquisarClienteController as vm'
});


export default angular
    .module('cliente.routes', [])
    .config(clienteRouter.route());

