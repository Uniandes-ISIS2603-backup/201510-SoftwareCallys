(function () {
    var contactModule = angular.module('homeModule', ['CrudModule', 'MockModule','catalogModule']);

    contactModule.constant('home.context', 'home');

   contactModule.config(['contact.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();