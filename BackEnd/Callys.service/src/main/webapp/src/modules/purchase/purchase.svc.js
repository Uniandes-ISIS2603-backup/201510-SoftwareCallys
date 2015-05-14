(function()
{
    var purchaseModule = angular.module('purchaseModule');
    purchaseModule.service('purchaseService', ['CRUDBase','purchase.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
        this.getPurchasesByClient = function(cliente)
        {
            return this.api.customGET('byClient', {id: cliente});
        };
    }]);
})();

