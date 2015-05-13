(function()
{
    var cartModule = angular.module('cartModule');
    cartModule.service('cartService',['CRUDBase','shirt.context',function(CRUDBase,context)
    {
        this.url = context;
        CRUDBase.extendService(this);
    }]);
})();

