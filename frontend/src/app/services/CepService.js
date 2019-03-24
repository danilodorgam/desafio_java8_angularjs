function CepService(Restangular, toastr) {
    const service = Restangular.withConfig(function(configurer){
        configurer.setBaseUrl(process.env.REST_VIACEP);

    }).service('ws');

    const imprimeErro = () =>  toastr.error("Número invalido","CEP")


    const consultaCep = (cep) => service.one(cep).one('json').customGET().then(retorno => {
        if(retorno.erro){
            imprimeErro();
        }
        return retorno;
    });


    return {
        consultaCep
    }
}
CepService.$inject = ['Restangular','toastr'];

export default angular.module('CepService',[])
    .service('CepService',CepService)