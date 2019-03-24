'use strict';

function CpfController(scope) {
    var vm = this;
    vm.tamanhoMinimo = !vm.tamanhoMinimo ? 0 : vm.tamanhoMinimo;



}


CpfController.$inject = ['$scope'];

export default CpfController;
