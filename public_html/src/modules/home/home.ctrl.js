(function () {
	var app = angular.module('homeModule');

	app.controller('homeCtrl', ['$scope', 'CRUDUtils', 'home.context', function ($scope, CRUDUtils, context) 
            {
                this.url = context;
                CRUDUtils.extendCtrl(this, $scope);       
            }]);
            
})();