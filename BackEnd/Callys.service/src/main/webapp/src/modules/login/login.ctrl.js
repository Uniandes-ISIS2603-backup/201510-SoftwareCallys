(function ()
{
    var loginModule = angular.module('loginModule');
    loginModule.controller('loginCtrl', ['$scope', 'loginService', 'catalogService', function ($scope, loginService,catalogService)
    {
        
        this.login= function(username,password)
        {
             this.currentRecord=loginService.login(username,password);
                if(this.currentRecord!==null)
                {
                    alert(this.currentRecord.name);
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