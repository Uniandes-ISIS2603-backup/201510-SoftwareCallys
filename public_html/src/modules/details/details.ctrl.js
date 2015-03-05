(function () {
	var app = angular.module('detailsModule');

	app.controller('detailsCtrl', ['$scope', 'CRUDUtils', 'details.context', function ($scope, CRUDUtils, context) 
            {
                this.url = context;
                CRUDUtils.extendCtrl(this, $scope);       
            }]);
            
})();