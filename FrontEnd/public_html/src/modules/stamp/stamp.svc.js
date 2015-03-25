(function()
{
    var stampModule = angular.module('stampModule');
    stampModule.service('stampService', ['CRUDBase','stamp.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
    }]);
})();