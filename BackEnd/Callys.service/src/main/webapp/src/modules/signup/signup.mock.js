(function (angular) {
    var signupModule = angular.module('signupModule');

    signupModule.run(['$httpBackend', 'signup.context', 'MockModule.mockRecords', 'signup.skipMock', 'MockModule.baseUrl', function ($httpBackend, context, mockRecords, skipMock, baseUrl) {
            if (skipMock) {
                $httpBackend.whenGET(baseUrl + '/' + context + '/signup').passThrough();
            } else {
                $httpBackend.whenGET(baseUrl + '/' + context + '/signup').respond(function () {
                    var top;
                    var collection = mockRecords[context];
                    for (var i in collection) {
                        if (!top && collection[i].population) {
                            top = collection[i];
                        } else {
                            if (collection[i].population && top.population < collection[i].population) {
                                top = collection[i];
                            }
                        }
                    }
                    if (!!top) {
                        return [200, top, {}];
                    } else {
                        return [404, {}, {}];
                    }
                });

                $httpBackend.whenGET(baseUrl + '/' + context + '/signup').respond(function () {
                    var top;
                    var collection = mockRecords[context];
                    for (var i in collection) {
                        if (!top && collection[i].population) {
                            top = collection[i];
                        } else {
                            if (collection[i].population && top.population > collection[i].population) {
                                top = collection[i];
                            }
                        }
                    }
                    if (!!top) {
                        return [200, top, {}];
                    } else {
                        return [404, {}, {}];
                    }
                });
            }
        }]);
})(window.angular);
