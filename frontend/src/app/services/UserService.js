function UserService(Restangular, toastr) {
    const service = Restangular.service('user');

    const imprimeErro = (erro) =>   toastr.error(erro.data.mensagens[0].mensagem,"Autenticação")


    const autenticar = () => service.one('').get().then(sucesso => sucesso, erro => imprimeErro(erro));

    return {
        autenticar,
    }
}
UserService.$inject = ['Restangular','toastr'];

export default angular.module('UserService',[])
    .service('UserService',UserService)