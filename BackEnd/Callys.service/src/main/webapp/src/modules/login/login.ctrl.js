(function (angular)
{
    var loginModule = angular.module('loginModule');
    loginModule.controller('loginCtrl', ['$scope', 'loginService', 'catalogService', function ($scope, loginService,catalogService)
    {
        this.cliente=1;
        
        this.login= function()
        {
                var user = {username : $scope.currentRecord.username , clave : $scope.currentRecord.password};
                loginService.login(user);
                if(this.res!==null)
                {
                    catalogService.artist=true; 
                    this.artist=true;
                }
                else
                {
                    this.wrong=true;
                }
        };
    }]);
})(window.angular);