(function (angular) {
    var loginModule = angular.module('loginModule');

    loginModule.run(['$httpBackend', 'login.context', 'MockModule.mockRecords', 'login.skipMock', 'MockModule.baseUrl', function ($httpBackend, context, mockRecords, skipMock, baseUrl) {
            if (skipMock)
            {
                $httpBackend.expectGET(baseUrl + '/' + context + '/login');
                $httpBackend.whenGET(baseUrl + '/' + context + '/login').passThrough();
            }
        }]);
})(window.angular);