(function ()
{
        var shirtModule=angular.module('shirtModule',['CrudModule','MockModule']);
        shirtModule.constant('shirt.skipMock', false);
        shirtModule.constant('shirt.context','shirt');
        shirtModule.config(['shirt.context','MockModule.urlsProvider','shirt.skipMock',function(context,urlsProvider, skipMock)
        {
            urlsProvider.registerUrl(context);
        }]);
})();