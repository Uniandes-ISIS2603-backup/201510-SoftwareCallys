(function () 
{
    var stampModule = angular.module('stampModule', ['CrudModule', 'MockModule','catalogModule']);
    stampModule.constant('stamp.context', 'stamps');
    stampModule.config(['stamp.context', 'MockModule.urlsProvider', function (context, urlsProvider)
    {
        this.url = urlsProvider.registerUrl(context);
    }]);
})();
