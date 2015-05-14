(function (angular)
{
    var catalogModule = angular.module('catalogModule');
    catalogModule.controller('catalogCtrl', ['$scope', 'catalogService', function ($scope, catalogService)
        {
            catalogService.extendCtrl(this, $scope);
            this.fetchRecords();
        }]);
})(window.angular);