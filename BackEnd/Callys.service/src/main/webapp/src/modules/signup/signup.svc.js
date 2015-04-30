(function()
{
    var signupModule = angular.module('signupModule');
     signupModule.service('signupService', ['CRUDBase','signup.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
    }]);
})();
