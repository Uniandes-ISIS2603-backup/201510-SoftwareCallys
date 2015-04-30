(function ()
{
    var loginModule = angular.module('loginModule');
    loginModule.controller('loginCtrl', ['$scope', 'loginService', function ($scope, catalogService)
    {
        catalogService.extendCtrl(this, $scope);
        this.fetchRecords();
    }]);
})();