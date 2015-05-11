(function ()
{
    var loginModule = angular.module('loginModule');
    loginModule.controller('loginCtrl', ['$scope', 'loginService', 'catalogService', function ($scope, loginService,catalogService)
    {
        
        this.login= function(username,password)
        {
            if(this.api.customGET('login',username,password)!==null)
            {
                this.currentRecord=this.api.customGET('login',username,password);
                catalogService.artist=true; 
                this.artist=true;
                  alert("Su usuario tos");
            }
            else
            {
                alert("Su usuario o contraseña no son correctos");
            }
        };
    }]);
})();