(function ()
{
    var detailsModule = angular.module('detailsModule', ['CrudModule', 'MockModule','shirtModule','catalogModule']);
    detailsModule.constant('details.context', 'camiseta');
    detailsModule.constant('details.skipMock', true);
    detailsModule.config(['details.context', 'MockModule.urlsProvider','details.skipMock', function (context, urlsProvider,skipMock)
    {
        urlsProvider.registerUrl(context,skipMock);
    }]);
})();