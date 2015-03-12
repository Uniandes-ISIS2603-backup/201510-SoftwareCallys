(function () {
    var detailsModule = angular.module('detailsModule', ['CrudModule', 'MockModule']);
    
    detailsModule.constant('details.context', 'detail');

   detailsModule.config(['details.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();