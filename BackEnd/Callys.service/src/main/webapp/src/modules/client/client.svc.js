(function(angular)
{
    var clientModule = angular.module('clientModule');
    clientModule.service('clientService',['CRUDBase','client.context',function(CRUDBase,context)
    {
        this.url = context;
        CRUDBase.extendService(this);
    }]);
})(window.angular);

