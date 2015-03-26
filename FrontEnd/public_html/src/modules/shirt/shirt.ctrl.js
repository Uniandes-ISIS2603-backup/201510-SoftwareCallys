(function ()
{
    var shirtModule = angular.module('shirtModule');
    shirtModule.controller('shirtCtrl', ['$scope', 'shirtService', function ($scope, shirtService)
    {
        shirtService.extendCtrl(this, $scope);
        this.fetchRecords();
        this.saveShirt = function (pName,pImage,pPrice)
        {
           $scope.currentRecord={name:pName,image:pImage,price:pPrice,stamps:""};
           this.saveRecord();
        };
    }]);
})();