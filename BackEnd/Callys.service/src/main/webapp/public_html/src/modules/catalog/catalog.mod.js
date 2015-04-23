(function ()
{
    var catalogModule = angular.module('catalogModule', ['CrudModule', 'MockModule']);
    
    catalogoModule.constant('catalogo.skipMock', true);
    catalogModule.constant('catalog.context', 'catalogs');
    catalogModule.config(['catalog.context', 'MockModule.urlsProvider', 'catalogo.skipMock', function (context, urlsProvider, skipMock)
    {
        urlsProvider.registerUrl(context, skipMock);
    }]);
})();