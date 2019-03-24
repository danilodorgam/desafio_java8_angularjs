'use strict';

function CepController(scope, $rootScope) {
    var vm = this;
    vm.root = $rootScope;
    vm.tamanhoMinimo = !vm.tamanhoMinimo ? 0 : vm.tamanhoMinimo;


    vm.enviaCep = (cep) =>   {
        vm.root.$emit('recebeCep', cep);
    }

}

CepController.$inject = ['$scope','$rootScope'];

export default CepController;
