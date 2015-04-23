(function ()
{
        var clientModule=angular.module('clientModule',['CrudModule','MockModule']);
        clientModule.constant('client.context','client');
        clientModule.config(['client.context','MockModule.urlsProvider',function(context,urlsProvider)
        {
            urlsProvider.registerUrl(context);
        }]);
})();