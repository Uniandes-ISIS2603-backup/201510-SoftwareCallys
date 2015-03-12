(function () {
    var homeModule = angular.module('homeModule', ['CrudModule', 'MockModule','catalogModule']);

    homeModule.constant('home.context', 'home');

   homeModule.config(['home.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();