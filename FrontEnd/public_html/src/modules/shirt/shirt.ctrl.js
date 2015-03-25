(function ()
{
    var shirtModule = angular.module('shirtModule');
    shirtModule.controller('shirtCtrl', ['$scope', 'shirtService', function ($scope, shirtService)
    {
        shirtService.extendCtrl(this, $scope);
        this.fetchRecords();
    }]);
})();