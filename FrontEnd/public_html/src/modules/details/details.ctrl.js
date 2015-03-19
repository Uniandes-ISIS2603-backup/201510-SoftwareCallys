(function () {
	var detailsModule = angular.module('detailsModule');

	detailsModule.controller('detailsCtrl', ['$scope', 'detailsService', function ($scope, detailsService) {
			detailsService.extendCtrl(this, $scope);
                         this.fetchRecords();
                         $scope.amount=0;
                         this.editMode=false;
                           this.shoppingCar = function () {
                               
                                this.editMode = !this.editMode;
                            };
                            this.saveSale = function () {
                                $scope.currentRecord.price=399*$scope.currentRecord.quantity;
                                $scope.amount = $scope.amount+$scope.currentRecord.price;
					this.saveRecord();
						
					
					
				};
                                   this.deleteSale = function (record) {
                     
                                $scope.amount = $scope.amount-record.price;
					this.deleteRecord(record);
						
					
					
				};
                                 this.deletePurchase = function () {
					var self = this;
					this.api.getList().then(function (data) {
						$scope.records = data;
						$scope.currentRecord = {};
						self.editMode = false;
					});
				};
                                
                                 this.getPurchase = function () {
					var self = this;
					this.api.getList().then(function (data) {
						$scope.records = data;
						$scope.currentRecord = {};
						self.editMode = false;
					});
				};
            }]);
            
})();