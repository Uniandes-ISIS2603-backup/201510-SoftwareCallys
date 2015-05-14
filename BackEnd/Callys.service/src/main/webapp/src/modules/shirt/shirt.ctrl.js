(function (angular)
{
    var shirtModule = angular.module('shirtModule');
    shirtModule.controller('shirtCtrl', ['$scope', 'shirtService', function ($scope, shirtService)
    {
        shirtService.extendCtrl(this, $scope);
        this.fetchRecords();
        this.selectShirt = function (pName,pImage,pPrice)
        {
            $scope.currentRecord={};
            $scope.currentRecord={name:pName,image:pImage,price:pPrice};
            this.saveRecord();
        };
    }]);
})(window.angular);