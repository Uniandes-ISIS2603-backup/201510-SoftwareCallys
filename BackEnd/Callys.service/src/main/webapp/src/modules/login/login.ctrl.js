(function ()
{
    var loginModule = angular.module('loginModule');
    loginModule.controller('loginCtrl', ['$scope', 'loginService', 'catalogService', function ($scope, loginService,catalogService)
    {
        this.cliente=1;
        
        this.login= function(username,password)
        {
             $scope.currentRecord=loginService.login(username,password);
                if(this.currentRecord!==null)
                {
                    alert($scope.currentRecord.name);
                    catalogService.artist=true; 
                    this.artist=true;
                }
                else
                {
                    alert("Wrong username or password");
                }
        };
    }]);
})();