function EnumService(Restangular, toastr) {
    const service = Restangular.service('enum');

    const imprimeErro = (erro) =>   toastr.error(erro.data.mensagens[0].mensagem,"Enum")


    const ListarTipoTelefone = () => service.get('').then(sucesso => sucesso.dados, erro => imprimeErro(erro));


    return {
        ListarTipoTelefone
    }
}
EnumService.$inject = ['Restangular','toastr'];

export default angular.module('EnumService',[])
    .service('EnumService',EnumService)