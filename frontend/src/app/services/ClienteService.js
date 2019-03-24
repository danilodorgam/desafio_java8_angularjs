function ClienteService(Restangular, toastr) {
    const service = Restangular.service('cliente');

    const imprimeErro = (erro) =>   toastr.error(erro.data.mensagens[0].mensagem,"Cliente")

    const salvar = (cliente) => service.post(cliente).then(sucesso => {
        toastr.success("Salva com sucesso!","Cliente")
        return sucesso;
    }, erro => {
        imprimeErro(erro);
        return erro;
    });

    const salvarEdicao = (id, cliente) => service.one(id.toString()).customPUT(cliente).then(sucesso => {
        toastr.success("Atualizada com sucesso!","Cliente")
        return sucesso;
    }, erro => {
        imprimeErro(erro);
        return erro;
    });

    const excluir = (id) => service.one(id.toString()).remove().then(sucesso => {
        toastr.info("Excluida com sucesso!","Cliente")
        return sucesso;
    }, erro => {
        imprimeErro(erro);
        return erro;
    });

    const pesquisar = (filtro = null) => service.get('').then(sucesso => sucesso.dados, erro => imprimeErro(erro));

    const obterEditacao = (id) => service.one('detalhar').one(id.toString()).get().then(sucesso => sucesso.dados, erro => imprimeErro(erro));

    return {
        salvar,
        pesquisar,
        salvarEdicao,
        obterEditacao,
        excluir
    }
}
ClienteService.$inject = ['Restangular','toastr'];

export default angular.module('ClienteService',[])
    .service('ClienteService',ClienteService)