'use strict';

import App from './core/App';

import DefaultModule from './app/modules/home/home.routes';
import ClienteModule from './app/modules/cliente/cliente.routes'
import LoginModule from './app/modules/login/login.routes'


import InputComponent from './app/components/inputComponent/input.module'
import SelectComponent from './app/components/selectComponent/select.module'
import GridComponent from './app/components/gridComponent/grid.module'
import MensagemComponent from './app/components/mensagemComponent/mensagem.module'
import FormComponent from './app/components/formComponent/form.module'
import CpfComponent from './app/components/cpfComponent/cpf.module'
import CepComponent from './app/components/cepComponent/cep.module'
import TelefoneComponent from './app/components/TelefoneComponent/telefone.module'
import NumeroTelefoneComponent from './app/components/numeroTelefoneComponent/numeroTelefone.module'
import EmailComponent from './app/components/EmailComponent/email.module'

import MasksModule from './app/filters/masks/masks.module'



new App(process.env.APP_NAME, [
    'ng-fx',
    'ngLocale',
    'ngMessages',
    'ui.router',
    'oc.lazyLoad',
    'ngSanitize',
    'restangular',
    'toastr',
    'datatables',
    'datatables.bootstrap',
    'pascalprecht.translate',
    'ui.utils.masks',
    'ui.router.grant',
    'ui.bootstrap',


    // Modulos
    DefaultModule.name,
    ClienteModule.name,
    LoginModule.name,

    // Components
    GridComponent.name,
    InputComponent.name,
    SelectComponent.name,
    MensagemComponent.name,
    FormComponent.name,
    CpfComponent.name,
    CepComponent.name,
    TelefoneComponent.name,
    NumeroTelefoneComponent.name,
    EmailComponent.name,




    MasksModule.name,
]);
