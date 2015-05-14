(function()
{
    var loginModule = angular.module('loginModule');
     loginModule.service('loginService', ['CRUDBase','login.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
        this.login= function(username,password)
        {
            var usuario = {"username":username, "clave":password};
            return this.api.customPOST(usuario, 'login');
        };
    }]);
})();
