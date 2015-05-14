(function ()
{
    var purchaseModule = angular.module('purchaseModule');
    purchaseModule.controller('purchaseCtrl', ['$scope', 'purchaseService', function ($scope, purchaseService)
        {
            purchaseService.extendCtrl(this, $scope);
            system.print
            this.getPurchasesByClient(2);
            
            
            this.cliente=2;
            
            this.getPurchasesByClient= function(cliente)
        {
             this.currentRecord=purchaseService.getPurchasesByClient(cliente);
              
        };
        }]);
})();