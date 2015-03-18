(function () {
    var artistModule = angular.module('artistModule', ['CrudModule', 'MockModule']);
    
    artistModule.constant('artist.context', 'catalog');

   artistModule.config(['artist.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
})();