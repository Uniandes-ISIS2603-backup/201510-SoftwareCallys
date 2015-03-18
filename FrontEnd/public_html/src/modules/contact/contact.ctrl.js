(function () {
	var shirt = angular.module('contactModule');

	shirt.controller('contactCtrl', ['$scope', 'CRUDUtils', 'contact.context', function ($scope, CRUDUtils, context) 
        {
            this.url = context;
            CRUDUtils.extendCtrl(this, $scope);
	}]);
            
})();
