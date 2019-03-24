'use strict';



function TelefoneController(scope, EnumService) {
    let vm = this;
    vm.enumService = EnumService;

    vm.init = () => {
        vm.comboTipoTelefone();
    }


    if(vm.edicao != null){
        vm.telefone = vm.edicao;
    }
    vm.salvar = (form,contexto) => {
        if(form.$invalid){
            form.$setSubmitted();
            return;
        }
        vm.callBack(vm.telefone, vm.contexto)

    }

    vm.comboTipoTelefone = () => {
        vm.enumService.ListarTipoTelefone().then(retorno => {
            vm.listarTipoTelefone = retorno
        })
    }
}

TelefoneController.$inject = ['$scope','EnumService'];

export default TelefoneController;
