(function ()
{
    var loginModule = angular.module('loginModule');
    loginModule.controller('loginCtrl', ['$scope', 'loginService', 'catalogService', function ($scope, loginService,catalogService)
    {
        this.cliente=1;
        
        this.login= function()
        {
                var user = {username : $scope.currentRecord.username , clave : $scope.currentRecord.password}
                var res = loginService.login(user);
                if(this.res!==null)
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