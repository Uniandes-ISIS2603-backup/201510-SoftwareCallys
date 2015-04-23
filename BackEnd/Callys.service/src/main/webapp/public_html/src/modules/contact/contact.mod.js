(function () {
    var contactModule = angular.module('contactModule', ['CrudModule', 'MockModule','catalogModule']);

    contactModule.constant('contact.context', 'home');

   contactModule.config(['contact.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();