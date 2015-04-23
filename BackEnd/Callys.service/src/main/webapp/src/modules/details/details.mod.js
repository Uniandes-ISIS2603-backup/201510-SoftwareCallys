(function ()
{
    var detailsModule = angular.module('detailsModule', ['CrudModule', 'MockModule','shirtModule','catalogModule']);
    detailsModule.constant('details.context', 'details');
    detailsModule.config(['details.context', 'MockModule.urlsProvider', function (context, urlsProvider)
    {
        urlsProvider.registerUrl(context);
    }]);
})();