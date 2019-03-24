'use strict';

import Module from '../../../core/Module';



import UserService from '../../services/UserService';

/**
 * Controllers
 */
import LoginController from './controllers/LoginController'


var loginModule = new Module('login', [
    UserService.name

]);


loginModule.setControllers(
    ['login.LoginController', LoginController]
);

loginModule.bootstrap(require('./login.bootstrap').default);

export default loginModule.getModule();



