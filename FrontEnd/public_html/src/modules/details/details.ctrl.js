(function () {
	var detailsModule = angular.module('detailsModule');

	detailsModule.controller('detailsCtrl', ['$scope', 'detailsService', function ($scope, detailsService) {
			detailsService.extendCtrl(this, $scope);
                         this.fetchRecords();
                         this.editMode=false;
                           this.shoppingCar = function () {
                               
                                this.editMode = !this.editMode;
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