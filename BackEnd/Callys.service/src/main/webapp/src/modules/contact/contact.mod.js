(function (angular)
{
    var contactModule = angular.module('contactModule', ['CrudModule', 'MockModule']);

    contactModule.constant('contact.context', 'contact');

   contactModule.config(['contact.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})(window.angular);