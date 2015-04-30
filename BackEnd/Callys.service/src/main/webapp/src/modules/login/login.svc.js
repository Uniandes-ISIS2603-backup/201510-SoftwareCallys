(function(){
    var loginModule = angular.module('loginModule');
     loginModule.service('loginService', ['CRUDBase','login.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
    }]);
})();
