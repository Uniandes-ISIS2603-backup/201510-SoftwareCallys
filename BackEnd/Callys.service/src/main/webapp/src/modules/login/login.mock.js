(function (angular) {
    var loginModule = angular.module('loginModule');

    loginModule.run(['$httpBackend', 'login.context', 'MockModule.mockRecords', 'login.skipMock', 'MockModule.baseUrl', function ($httpBackend, context, mockRecords, skipMock, baseUrl) {
            if (skipMock) {
                $httpBackend.whenGET(baseUrl + '/' + context + '/login').passThrough();
            } else {
               
            }
        }]);
})(window.angular);