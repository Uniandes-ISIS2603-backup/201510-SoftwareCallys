(function () {
    var catalogModule = angular.module('catalogModule');

    catalogModule.run(['$httpBackend', 'catalog.context', 'MockModule.mockRecords','catalog.skipMock', function ($httpBackend, context, mockRecords, skipMock) {
            if (skipMock)
            {
                $httpBackend.whenGET(baseUrl + '/' + context + '/mostPopulated').passThrough();
                $httpBackend.whenGET(baseUrl + '/' + context + '/leastPopulated').passThrough();
            } 
            $httpBackend.whenGET('webresources/' + context + '/mostPopulated').respond(function () {
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
                if(!!top){
                    return [200, top, {}];
                }else{
                    return [404, {}, {}];
                }
            });

            $httpBackend.whenGET('webresources/' + context + '/leastPopulated').respond(function () {
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
                if(!!top){
                    return [200, top, {}];
                }else{
                    return [404, {}, {}];
                }
            });
        }]);
})();