(function ()
{
    var loginModule = angular.module('loginModule');
    loginModule.controller('loginCtrl', ['$scope', 'loginService', 'catalogService', function ($scope, loginService,catalogService)
    {
        
        this.login= function(username,password1)
        {
            if(this.customGET('login', {userName: username, password: password1})!==null)
            {
                this.currentRecord=this.customGET('login', {userName: username, password: password1});
                catalogService.artist=true; 
                this.artist=true;
                alert(" correctos");
            }
            else
            {
                alert("Su usuario o contraseña no son correctos");
            }
        };
    }]);
})();