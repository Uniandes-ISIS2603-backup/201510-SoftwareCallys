(function(angular)
{
    var contactModule = angular.module('contactModule');
    contactModule.service('contactService', ['CRUDBase','contact.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
    }]);
})(window.angular);