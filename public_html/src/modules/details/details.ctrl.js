(function () {
	var app = angular.module('detailsModule');

	app.controller('stampCtrl', ['$scope', 'CRUDUtils', 'details.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
                         this.fetchRecords();
                         this.editMode=false;
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