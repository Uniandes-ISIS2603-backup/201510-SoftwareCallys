(function()
{
    var contactModule = angular.module('contactModule');
    contactModule.service('contactService', ['CRUDBase','catalog.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
    }]);
})();