(function () {
    var stampModule = angular.module('stampModule', ['CrudModule', 'MockModule','ngResource','catalogModule']);

    stampModule.constant('stamp.context', 'stamps');

    stampModule.config(['stamp.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
            urlsProvider.registerUrl(context);
        }]);
    stampModule.factory('stampGet', function($resource){
        return $resource('/Callys.service/services/stamps', {},{ 
            query:  {method:'GET', params:{}, isArray:false}
            
        });
    });
 
      stampModule.factory('stampPost', function($resource){
        return $resource('/Callys.service/services/stamps', {},{ 
            query:  {method:'POST', params:{}, isArray:false}
            
        });
    });
})();
