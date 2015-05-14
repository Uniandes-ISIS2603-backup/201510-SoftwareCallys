(function (angular)
{
        var detailsModule =angular.module('detailsModule');
        detailsModule.controller('detailsCtrl',['$scope','detailsService','shirtService','catalogService','purchaseService',function($scope,detailsService,shirtService,catalogService,purchaseService )
        {
            detailsService.extendCtrl(this, $scope);
            this.fetchRecords();
            this.stampMode=true;
            $scope.amount=0;
            $scope.sales= [];
            catalogService.fetchRecords().then(function(data)
            {
                $scope.catalogRecords = data;
            });
            shirtService.fetchRecords().then(function(data)
            {
               $scope.ShirtRecords = data;
            });
            this.savePurchase = function(records)
            {
                   purchaseService.saveRecord(records);
            };
            this.editMode=false;
            this.shoppingCar = function ()
            {
                    this.editMode = !this.editMode;
            };
            this.addToCar = function ()
            {
                $scope.currentRecord.price= $scope.ShirtRecords[0].price*$scope.currentRecord.quantity;
                $scope.amount = $scope.amount+$scope.currentRecord.price;
                $scope.sales.push($scope.currentRecord);
            };
            this.addStamp = function (catalog)
            {
                $scope.ShirtRecords[0].stamps=catalog;
                $scope.ShirtRecords[0].price=$scope.ShirtRecords[0].price+catalog.price;
                detailsService.addStamp($scope.ShirtRecords[0]);
                shirtService.fetchRecords().then(function(data)
                {
                    $scope.ShirtRecords = data;
                });
                this.stampMode=false;
            };
            this.deleteStamp = function (catalog)
            {
                $scope.ShirtRecords[0].price=$scope.ShirtRecords[0].price-catalog.price;
                this.stampMode=true;
            };
            this.deleteSale = function (record)
            {
                if($scope.amount >0)
                {
                    $scope.amount = $scope.amount-record.price;
                }
                this.deleteRecord(record);
            };
        }]);
})(window.angular);
