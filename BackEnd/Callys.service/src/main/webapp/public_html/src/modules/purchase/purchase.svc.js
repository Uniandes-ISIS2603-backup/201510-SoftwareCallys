(function()
{
    var purchaseModule = angular.module('purchaseModule');
    purchaseModule.service('purchaseService', ['CRUDBase','purchase.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
    }]);
})();

