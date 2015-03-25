(function () 
{
	var detailsModule = angular.module('detailsModule');
	detailsModule.controller('detailsCtrl', ['$scope', 'detailsService','shirtService', function ($scope, detailsService,shirtService) 
        {
            detailsService.extendCtrl(this, $scope);
            this.fetchRecords();
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
                $scope.currentRecord.price=50*$scope.currentRecord.quantity;
                $scope.amount = $scope.amount+$scope.currentRecord.price;
                this.saveRecord();
            };
            this.deleteSale = function (record) 
            {
                $scope.amount = $scope.amount-record.price;
                this.deleteRecord(record);
            };
        }]);  
})();