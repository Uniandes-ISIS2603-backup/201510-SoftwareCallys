(function () {
	var app = angular.module('stampModule');

	app.controller('stampCtrl', ['$scope', 'CRUDUtils', 'stamp.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
                         this.editMode=false;
            this.upload= function(){
                editMode=true;
            }
            function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah')
                    .attr('src', e.target.result)
                    .width(150)
                    .height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
		}]);
           
})();