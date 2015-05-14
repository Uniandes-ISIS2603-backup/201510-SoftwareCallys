(function (angular) {
    var loginModule = angular.module('catalogModule');

    loginModule.run(['$httpBackend', 'catalog.context', 'MockModule.mockRecords', 'catalog.skipMock', 'MockModule.baseUrl', function ($httpBackend, context, mockRecords, skipMock, baseUrl) {
            if (skipMock)
            {
                $httpBackend.whenPOST(baseUrl + '/' + context + '/login').passThrough();
            }
        }]);
})(window.angular);