'use strict';


class CadastrarClienteController {
    constructor($scope, $state,ClienteService) {
        this.model = ClienteService;
        this.state = $state;
        this.pesquisar();
    }

    pesquisar(){
        this.model.pesquisar(this.filtro).then(sucesso => {
            this.clientes = sucesso
        });
    }

    excluir(id){
        this.model.excluir(id).then(sucesso => this.pesquisar(), erro => this.pesquisar());

    }


    voltar(){
        window.history.back();
    }



}

CadastrarClienteController.$inject = ['$scope', '$state','ClienteService'];

export default CadastrarClienteController;