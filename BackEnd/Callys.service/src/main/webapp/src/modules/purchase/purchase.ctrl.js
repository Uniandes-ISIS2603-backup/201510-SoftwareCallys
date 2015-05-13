(function ()
{
    var purchaseModule = angular.module('purchaseModule');
    purchaseModule.controller('purchaseCtrl', ['$scope', 'purchaseService', function ($scope, purchaseService)
        {
            purchaseService.extendCtrl(this, $scope);
            this.fetchRecords();
            
            
            this.cliente=1;
            
            this.viewPurchases= function(cliente)
        {
             this.currentRecord=purchaseService.viewPurchases(cliente);
              
        };
        }]);
})();