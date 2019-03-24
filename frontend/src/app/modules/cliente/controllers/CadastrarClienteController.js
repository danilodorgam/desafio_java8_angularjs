'use strict';




class CadastrarClienteController {
    constructor($scope, $state,ClienteService,$rootScope,CepService) {
        this.model = ClienteService;
        this.state = $state;
        this.id = this.state.params.id;
        this.$rootScope = $rootScope;
        this.cepService = CepService;
        this.abreComponenteTelefone = false;
        this.abreComponenteEmail = false;
        this.telefonesInvalido = false;
        this.emailsInvalido = false;

        this.disabilitar =  this.state.current.name == "cliente.visualizar"
        if(this.id){
            this.model.obterEditacao(this.id).then(sucesso => this.cliente = sucesso)
        }
        this.recebeCep()

    }

    salvar (form, vm){
        if(form.$invalid){
            form.$setSubmitted();
            return;
        }
        if(vm.cliente.telefones == null || vm.cliente.telefones.length == 0){
            vm.telefonesInvalido = true;
            return;

        }
        if(vm.cliente.emails == null || vm.cliente.emails.length == 0){
            vm.emailsInvalido = true;
            return;

        }
        if(vm.id){
            vm.model.salvarEdicao(vm.id,vm.cliente).then(sucesso =>  vm.state.go("cliente.pesquisar"));

        }else{
            vm.model.salvar(vm.cliente).then(sucesso =>  vm.state.go("cliente.pesquisar"));

        }

    }


    recebeCep(){
        let vm = this;
        this.$rootScope.$on('recebeCep', function (event, cep) {
            vm.cepService.consultaCep(cep).then(ret => {
                vm.cliente.bairro = ret.bairro;
                vm.cliente.logradouro = ret.logradouro;
                vm.cliente.cidade = ret.localidade;
                vm.cliente.uf = ret.uf;

            })
        });
    }

    adicionaTelefone(telefone, vm){
        if(vm.cliente == null || vm.cliente.telefones == null){
            if(vm.cliente == null){
                vm.cliente = {}
            }
            vm.cliente.telefones = []

        }
        if(vm.telefone !== telefone){
            vm.cliente.telefones.push(telefone)

        }
        vm.telefonesInvalido = false;
        vm.abreComponenteTelefone = false;
    }


    prepararEdicaoTelefone(telefone){
        this.telefone = angular.copy(telefone);
        this.abreComponenteTelefone = true;
    }


    prepararEdicaoEmail(email){
        this.email = angular.copy(email);
        this.abreComponenteEmail = true;
    }

    adicionaEmail(email, vm){
        if(vm.cliente == null || vm.cliente.emails == null){
            if(vm.cliente == null){
                vm.cliente = {}
            }
            vm.cliente.emails = []

        }
        if(vm.email !== email){
            vm.cliente.emails.push(email)

        }
        vm.emailsInvalido = false;
        vm.abreComponenteEmail = false;
    }









    voltar(){
        window.history.back();
    }



}

CadastrarClienteController.$inject = ['$scope', '$state','ClienteService','$rootScope','CepService'];

export default CadastrarClienteController;