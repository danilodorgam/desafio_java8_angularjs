'use strict';

import PhoneBrFilter from './phonebr.filter';
import Truncate from './truncate.filter';
import CpfFilter from './cpf.filter'

var m = angular.module('mi.filters', [])
    .filter('phoneBr', PhoneBrFilter)
    .filter('cpf',CpfFilter)
    .filter('truncate', Truncate);

export default m;
