'use strict';



function EmailController(scope, EnumService) {
    let vm = this;
    vm.enumService = EnumService;


    if(vm.edicao != null){
        vm.email = vm.edicao;
    }
    vm.salvar = (form,contexto) => {
        if(form.$invalid){
            form.$setSubmitted();
            return;
        }
        vm.callBack(vm.email, vm.contexto)

    }

}

EmailController.$inject = ['$scope','EnumService'];

export default EmailController;
