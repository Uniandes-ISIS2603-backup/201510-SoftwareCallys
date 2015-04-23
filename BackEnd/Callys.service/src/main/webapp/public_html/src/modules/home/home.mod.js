(function ()
{
    var homeModule = angular.module('homeModule', ['CrudModule', 'MockModule','catalogModule']);
    homeModule.constant('home.skipMock', false);
    homeModule.constant('home.context', 'home');
    homeModule.config(['home.context', 'MockModule.urlsProvider','home.skipMock' , function (context, urlsProvider, skipMock)
    {
         urlsProvider.registerUrl(context);
    }]);
})();