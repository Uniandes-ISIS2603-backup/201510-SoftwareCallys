(function ()
{
        var detailsModule =angular.module('detailsModule');
        detailsModule.controller('detailsCtrl',['$scope','detailsService','shirtService','catalogService',function($scope,detailsService,shirtService,catalogService)
        {
            detailsService.extendCtrl(this, $scope);
            this.fetchRecords();
            this.stampMode=true;
            catalogService.fetchRecords().then(function(data)
            {
                $scope.catalogRecords = data;
            });
            shirtService.fetchRecords().then(function(data)
            {
               $scope.ShirtRecords = data;
            });
            $scope.amount=0;
            this.editMode=false;
            this.shoppingCar = function ()
            {
                    this.editMode = !this.editMode;
            };
            this.saveSale = function ()
            {
                $scope.currentRecord.price= $scope.ShirtRecords[0].price*$scope.currentRecord.quantity;
                $scope.amount = $scope.amount+$scope.currentRecord.price;
                this.saveRecord();
            };
            this.addStamp = function (catalog)
            {
                $scope.ShirtRecords[0].stamps=$scope.ShirtRecords[0].stamps+"\n StampName: "+catalog.name+"    StampPrice: "+catalog.price+"\n";
                $scope.ShirtRecords[0].price=$scope.ShirtRecords[0].price+catalog.price;
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
})();