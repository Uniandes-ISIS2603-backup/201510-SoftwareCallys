(function () {
    var stampModule = angular.module('stampModule', ['CrudModule', 'MockModule','ngResource','catalogModule']);

    stampModule.constant('stamp.context', 'stamps');

    stampModule.config(['stamp.context', 'MockModule.urlsProvider', function ($http, context, urlsProvider) {
        this.url = urlsProvider.registerUrl(context);
        function saveStamp (stamp, callback, callbackError ){
            $http.get({
                url: 'WebResources/Stamp/saveStamp/',
                data: angular.toJson(stamp),
                contentType: 'application/json'
            }).succes(_.bind(function(data) {
                callback(data);
            },this)).error(_.bind(function(data){
                callbackError(data);
            },this));
        };
    }]);
})();
