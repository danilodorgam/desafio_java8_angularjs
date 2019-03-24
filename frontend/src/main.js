'use strict';


import 'bootstrap/dist/css/bootstrap.min.css';
import './app/assets/less/app.less'





import './app';
import './bootstrap'

import './app/configs/restangular.config';
import './app/configs/toastr.config'

import './app/assets/layout/blank.html'
import './app/assets/layout/sidebar.html'
import './app/assets/layout/top-navbar.html'


angular.bootstrap(document, [process.env.APP_NAME], {strictDi: true});
