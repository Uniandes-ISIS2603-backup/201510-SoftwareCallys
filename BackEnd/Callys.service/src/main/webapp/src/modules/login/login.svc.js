(function(angular)
{
    var loginModule = angular.module('loginModule');
     loginModule.service('loginService', ['CRUDBase','login.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
        this.login= function(user)
        {
            var result = this.api.customPOST(user, 'login');
            return result;
        };
    }]);
})(window.angular);
