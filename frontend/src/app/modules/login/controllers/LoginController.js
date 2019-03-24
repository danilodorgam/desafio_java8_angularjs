'use strict';


class LoginController {
    constructor($rootScope, UserService, $state) {
        let vm = this;
        vm.userService = UserService;
        vm.state = $state;
        vm.root = $rootScope;
        vm.sessionStorage = window.sessionStorage;

    }

    logar(form, vm) {
        if(form.$invalid){
            form.$setSubmitted();
            return;
        }
        vm.sessionStorage.setItem("token",btoa(vm.login.user+":"+vm.login.senha))
        vm.userService
            .autenticar(vm.login)
            .then(function (res) {
                vm.state.go("main.home")
            }, function (error) {
                vm.authMsg = error.data.error_description;
            });
    }


}

LoginController.$inject = ['$rootScope', 'UserService', '$state'];

export default LoginController;