(function (angular)
{
    var purchaseModule = angular.module('purchaseModule');
    purchaseModule.controller('purchaseCtrl', ['$scope', 'purchaseService', function ($scope, purchaseService)
    {
        purchaseService.extendCtrl(this, $scope);
        
        this.noRate=false;
        this.viewPurchases= function(cliente)
        {
            this.currentRecord=purchaseService.getPurchasesByClient(cliente);
        };
        this.viewPurchases(2);
    }]);
})(window.angular);