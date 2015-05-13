(function()
{
    var purchaseModule = angular.module('purchaseModule');
    purchaseModule.service('purchaseService', ['CRUDBase','purchase.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
        this.viewPurchases= function(cliente)
        {
            return this.api.customGET(null, {idCliente: cliente});
        };
    }]);
})();

