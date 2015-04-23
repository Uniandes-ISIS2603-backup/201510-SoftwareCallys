(function ()
{
    var clientModule = angular.module('clientModule');
    clientModule.controller('clientCtrl', ['$scope', 'clientService','purchaseService', function ($scope, clientService, purchaseService)
    {
        clientService.extendCtrl(this, $scope);
        this.fetchRecords();
        purchaseService.fetchRecords().then(function(data)
            {
                $scope.purchaseService = data;
            });
         this.likeStamp = function (record)
        {
            record.rating +=1;
            purchaseService.saveRecord(record);
            purchaseService.fetchRecords().then(function(data)
                {
                   $scope.purchaseService = data;
                });
        };
        this.dislikeStamp = function (record)
        {
            record.rating = record.rating-1;
            purchaseService.saveRecord(record);
            purchaseService.fetchRecords().then(function(data)
                {
                   $scope.purchaseService = data;
                });
        };
    }]);
})();