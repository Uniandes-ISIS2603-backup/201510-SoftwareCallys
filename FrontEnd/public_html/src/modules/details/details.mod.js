(function () {
    var detailsModule = angular.module('detailsModule', ['CrudModule', 'MockModule','shirtModule']);
    
    detailsModule.constant('details.context', 'details');

   detailsModule.config(['details.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();