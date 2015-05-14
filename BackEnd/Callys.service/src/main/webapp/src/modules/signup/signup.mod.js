(function ()
{
    var signupModule = angular.module('signupModule', ['CrudModule', 'MockModule','clientModule']);
    signupModule.constant('signup.context', 'artista');
    signupModule.constant('signup.skipMock', true);
    signupModule.config(['signup.context', 'MockModule.urlsProvider','signup.skipMock', function (context, urlsProvider, skipMock)
    {
         urlsProvider.registerUrl(context,skipMock);
    }]);
})();