(function (angular) {
    var stampModule = angular.module('stampModule');

    stampModule.run(['$httpBackend', 'stamp.context', 'MockModule.mockRecords', 'stamp.skipMock', 'MockModule.baseUrl', function ($httpBackend, context, mockRecords, skipMock, baseUrl) {
            if (skipMock)
            {

            }
        }]);
})(window.angular);