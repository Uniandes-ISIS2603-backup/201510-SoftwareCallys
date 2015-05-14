(function (angular)
{
        var shirtModule=angular.module('shirtModule',['CrudModule','MockModule']);
        shirtModule.constant('shirt.context','camiseta');
        shirtModule.constant('shirt.skipMock', true);
        shirtModule.config(['shirt.context','MockModule.urlsProvider','shirt.skipMock',function(context,urlsProvider,skipMock)
        {
            urlsProvider.registerUrl(context,skipMock);
        }]);
})(window.angular);