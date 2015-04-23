(function ()
{
    var purchaseModule = angular.module('purchaseModule', ['CrudModule', 'MockModule']);
    purchaseModule.constant('purchase.context', 'purchases');
    purchaseModule.config(['purchase.context', 'MockModule.urlsProvider', function (context, urlsProvider)
    {
        urlsProvider.registerUrl(context);
    }]);
})();