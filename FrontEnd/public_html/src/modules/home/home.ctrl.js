(function () 
{
    var homeModule = angular.module('homeModule');
    homeModule.controller('homeCtrl', ['$scope', 'homeService', function ($scope, catalogService) 
    {
        catalogService.extendCtrl(this, $scope);
        this.fetchRecords();
    }]);
})();