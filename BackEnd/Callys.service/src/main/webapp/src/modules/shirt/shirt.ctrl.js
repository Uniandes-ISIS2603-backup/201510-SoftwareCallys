(function ()
{
    var shirtModule = angular.module('shirtModule');
    shirtModule.controller('shirtCtrl', ['$scope', 'shirtService', function ($scope, shirtService)
    {
        shirtService.extendCtrl(this, $scope);
        this.fetchRecords();
        this.selectShirt = function (pName,pImage,pPrice)
        {
            alert(pName);
            if($scope.currentRecord !== null)
            {
                $scope.currentRecord = {name:"pName",image:pImage,price:pPrice,color:"",talla:"",material:"",texto:""};
                this.saveRecord();
            }
            else
            {
                $scope.currentRecord={name:pName,image:pImage,price:pPrice};
                this.saveRecord();
            }
        };
    }]);
})();