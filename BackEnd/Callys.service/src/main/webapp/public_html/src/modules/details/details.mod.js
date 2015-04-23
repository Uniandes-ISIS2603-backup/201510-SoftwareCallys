(function ()
{
    var detailsModule = angular.module('detailsModule', ['CrudModule', 'MockModule','shirtModule','catalogModule']);
    detailsModule.comstant('details.skipMock', false)
    detailsModule.constant('details.context', 'details');
    detailsModule.config(['details.context', 'MockModule.urlsProvider','details.skipMock', function (context, urlsProvider, skipMock)
    {
        urlsProvider.registerUrl(context);
    }]);
})();