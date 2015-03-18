(function () {
    var crud = angular.module('CrudModule', ['restangular', 'ui.bootstrap']);

    crud.config(['RestangularProvider', function (rp) {
            rp.setBaseUrl('webresources');
            rp.addResponseInterceptor(function (data, operation) {
                var extractedData;
                if (operation === "getList") {
                    extractedData = data.records;
                    extractedData.totalRecords = data.totalRecords;
                } else {
                    extractedData = data;
                }
                return extractedData;
            });
        }]);
})();