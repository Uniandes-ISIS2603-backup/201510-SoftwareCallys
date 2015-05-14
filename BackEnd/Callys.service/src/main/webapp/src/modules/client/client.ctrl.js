(function (angular)
{
    var clientModule = angular.module('clientModule');
    clientModule.controller('clientCtrl', ['$scope', 'clientService', function ($scope, clientService)
    {
        clientService.extendCtrl(this, $scope);
        this.fetchRecords();
    }]);
})(window.angular);