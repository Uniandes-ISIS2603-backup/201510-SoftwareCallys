(function ()
{
    var purchaseModule = angular.module('purchaseModule');
    purchaseModule.controller('purchaseCtrl', ['$scope', 'purchaseService', function ($scope, purchaseService)
        {
            purchaseService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})();