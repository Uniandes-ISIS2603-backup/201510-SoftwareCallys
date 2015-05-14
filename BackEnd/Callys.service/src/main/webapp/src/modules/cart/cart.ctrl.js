(function ()
{
    var cartModule = angular.module('cartModule');
    cartModule.controller('shirtCtrl', ['$scope', 'cartService', function ($scope, cartService)
    {
        cartService.extendCtrl(this, $scope);
        this.fetchRecords();
       
    }]);
})();