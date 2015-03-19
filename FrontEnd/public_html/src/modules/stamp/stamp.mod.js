(function () {
    var stampModule = angular.module('stampModule', ['CrudModule', 'MockModule','ngResource','catalogModule']);

    stampModule.constant('stamp.context', 'stamps');

    stampModule.config(['stamp.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
    stampModule.factory('stampResource', function($resource){
        return $resource('http://localhost:8080/resources/webservices/stamp', {},{ query: {method:'GET', params:{}, isArray:false} });
    });
})();
