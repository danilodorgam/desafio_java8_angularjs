'use strict';


//Services
import Module from '../../../core/Module';
import bootstrap from './cliente.bootstrap'
import ClienteService from "../../services/ClienteService";
import CepService from "../../services/CepService";


//Controllers
import CadastrarClienteController from './controllers/CadastrarClienteController'
import PesquisarClienteController from './controllers/PesquisarClienteController'

let module = new Module('cliente', [
    ClienteService.name,
    CepService.name
]);

module.setControllers(
    ['cliente.CadastrarQuestaoController', CadastrarClienteController],
    ['cliente.PesquisarClienteController', PesquisarClienteController],



);

module.bootstrap(bootstrap);

export default module.getModule();



