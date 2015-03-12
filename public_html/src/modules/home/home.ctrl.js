(function () {
	var homeModule = angular.module('homeModule');

	homeModule.controller('homeCtrl', ['$scope', 'CRUDBase', 'home.context', function ($scope, CRUDBase, context) 
            {
                this.url = context;
                CRUDBase.extendCtrl(this, $scope);       
            }]);
            
})();