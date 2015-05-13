(function()
{
    var loginModule = angular.module('loginModule');
     loginModule.service('loginService', ['CRUDBase','login.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
        this.login= function(username,password)
        {
            return this.api.customGET('login', {userName: username, password: password});
        };
    }]);
})();
