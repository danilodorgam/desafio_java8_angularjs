'use strict';

import Module from '../../../core/Module';
import bootstrap from './home.bootstrap'
import HomeController from './controllers/HomeController'

let module = new Module('home', []);

module.setControllers(
    ['home.HomeController', HomeController],
);

module.bootstrap(bootstrap);

export default module.getModule();



