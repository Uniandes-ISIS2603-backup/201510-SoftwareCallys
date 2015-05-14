(function(angular)
{
    var catalogModule = angular.module('catalogModule');
    catalogModule.service('catalogService', ['CRUDBase','catalog.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
        this.artist=false;
    }]);
})(window.angular);

