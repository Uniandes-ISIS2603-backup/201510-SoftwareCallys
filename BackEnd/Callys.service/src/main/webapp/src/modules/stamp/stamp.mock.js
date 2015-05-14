(function (angular) {
    var stampModule = angular.module('stampModule');

    stampModule.run(['$httpBackend', 'stamp.context', 'MockModule.mockRecords', 'stamp.skipMock', function ($httpBackend, context, mockRecords, skipMock, baseUrl) {
            if (skipMock)
            {
                 $httpBackend.whenPOST(baseUrl + '/' + context + '/login').passThrough();
            }
        }]);
})(window.angular);