(function ()
{
    var stampModule = angular.module('stampModule', ['CrudModule', 'MockModule','catalogModule']);
    stampModule.constant('stamp.context', 'stamp');
    stampModule.constant('stamp.skipMock', true);
    stampModule.config(['stamp.context', 'MockModule.urlsProvider','stamp.skipMock', function (context, urlsProvider,skipMock)
    {
        urlsProvider.registerUrl(context,skipMock);
    }]);
})();
