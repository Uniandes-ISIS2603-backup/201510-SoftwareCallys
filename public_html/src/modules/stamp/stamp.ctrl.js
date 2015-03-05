(function () {
	var app = angular.module('stampModule');

	app.controller('stampCtrl', ['$scope', 'CRUDUtils', 'stamp.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
                         this.editMode=false;
            this.upload= function(){
                this.editMode=true;
            };
            }]);
           
})();