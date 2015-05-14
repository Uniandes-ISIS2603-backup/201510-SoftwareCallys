(function(angular)
{
    var shirtModule = angular.module('shirtModule');
    shirtModule.service('shirtService',['CRUDBase','shirt.context',function(CRUDBase,context)
    {
        this.url = context;
        CRUDBase.extendService(this);
    }]);
})(window.angular);

