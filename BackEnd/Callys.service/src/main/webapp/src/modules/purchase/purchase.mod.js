(function (angular) {
    var purchaseModule = angular.module('purchaseModule', ['CrudModule', 'MockModule']);
    purchaseModule.constant('purchase.context', 'purchase');
    purchaseModule.constant('purchase.skipMock', true);
    purchaseModule.config(['purchase.context', 'MockModule.urlsProvider', 'purchase.skipMock', function (context, urlsProvider, skipMock)
    {
        urlsProvider.registerUrl(context, skipMock);
    }]);
})(window.angular);