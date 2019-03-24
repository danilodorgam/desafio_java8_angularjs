'use strict';


class HomeController {
    constructor($scope, $rootScope){
        $rootScope.currTitle = "Pagina Inicial"
    }
}

HomeController.$inject = ['$scope', '$rootScope'];

export default HomeController;