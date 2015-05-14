(function ()
{
        var cartModule=angular.module('cartModule',['CrudModule','MockModule']);
        cartModule.constant('cart.context','carroCompras');
        cartModule.constant('cart.skipMock', true);
        cartModule.config(['cart.context','MockModule.urlsProvider','cart.skipMock',function(context,urlsProvider,skipMock)
        {
            urlsProvider.registerUrl(context,skipMock);
        }]);
})();