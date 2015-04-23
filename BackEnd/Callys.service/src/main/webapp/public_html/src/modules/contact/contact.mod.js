(function () {
    var contactModule = angular.module('contactModule', ['CrudModule', 'MockModule','catalogModule']);

    contactModule.constant('contact.skipMock', false);
    contactModule.constant('contact.context', 'home');

   contactModule.config(['contact.context', 'MockModule.urlsProvider', 'contact.skipMock', function (context, urlsProvider, skipMock) {
            urlsProvider.registerUrl(context);
        }]);
})();