(function()
{
    var catalogModule = angular.module('catalogModule');
    catalogModule.service('catalogService', ['CRUDBase','catalog.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
        
        this.getCatalogo = function () {
                return this.api.customGET('Catalogo');
            };
            
    }]);
})();

