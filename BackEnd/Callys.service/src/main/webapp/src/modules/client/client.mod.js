(function ()
{
        var clientModule=angular.module('clientModule',['CrudModule','MockModule']);
        clientModule.constant('client.context','cliente');
        clientModule.constant('client.skipMock', true);
        clientModule.config(['client.context','MockModule.urlsProvider','client.skipMock',function(context,urlsProvider,skipMock)
        {
            urlsProvider.registerUrl(context,skipMock);
        }]);
})();