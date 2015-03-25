(function ()
{
    var catalogModule = angular.module('catalogModule', ['CrudModule', 'MockModule']);
    catalogModule.constant('catalog.context', 'catalogs');
    catalogModule.config(['catalog.context', 'MockModule.urlsProvider', function (context, urlsProvider)
    {
        urlsProvider.registerUrl(context);
    }]);
})();