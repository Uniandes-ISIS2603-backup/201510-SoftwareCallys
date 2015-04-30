(function ()
{
    var signupModule = angular.module('signupModule', ['CrudModule', 'MockModule']);
    signupModule.constant('signup.context', 'signups');
    signupModule.config(['signup.context', 'MockModule.urlsProvider', function (context, urlsProvider)
    {
         urlsProvider.registerUrl(context);
    }]);
})();