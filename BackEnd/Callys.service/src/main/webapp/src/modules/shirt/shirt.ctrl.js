(function ()
{
    var shirtModule = angular.module('shirtModule');
    shirtModule.controller('shirtCtrl', ['$scope', 'shirtService', function ($scope, shirtService)
    {
        shirtService.extendCtrl(this, $scope);
        this.fetchRecords();
        this.selectShirt = function (pName,pImage,pPrice)
        {
            if($scope.currentRecord !== null)
            {
                $scope.currentRecord={name:"",image:"",price:"",stamps:""};
                $scope.currentRecord = {name:pName,image:pImage,price:pPrice,stamps:""};
                this.saveRecord();
            }
            else
            {
                $scope.currentRecord={name:pName,image:pImage,price:pPrice,stamps:""};
                this.saveRecord();
            }
        };
    }]);
})();