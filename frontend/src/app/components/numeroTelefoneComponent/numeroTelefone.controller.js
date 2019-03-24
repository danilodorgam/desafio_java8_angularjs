'use strict';

function NumeroTelefoneController(scope) {
    var vm = this;
    vm.tamanhoMinimo = !vm.tamanhoMinimo ? 0 : vm.tamanhoMinimo;



}


NumeroTelefoneController.$inject = ['$scope'];

export default NumeroTelefoneController;
