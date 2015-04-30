(function ()
{
    var catalogModule = angular.module('catalogModule', ['CrudModule', 'MockModule']);
    catalogModule.constant('catalog.context', 'stamp');
    catalogModule.constant('catalog.skipMock', true);
    catalogModule.config(['catalog.context', 'MockModule.urlsProvider','catalog.skipMock', function (context, urlsProvider,skipMock)
    {
        urlsProvider.registerUrl(context,skipMock);
    }]);
})();