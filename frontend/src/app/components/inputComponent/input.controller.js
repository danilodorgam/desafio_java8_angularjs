'use strict';

function InputController(scope) {
    var vm = this;
    vm.tamanhoMinimo = !vm.tamanhoMinimo ? 0 : vm.tamanhoMinimo;

}

InputController.$inject = ['$scope'];

export default InputController;
