(function () {
    var crud = angular.module('CrudModule', ['restangular', 'ui.bootstrap']);
 
    crud.config(['RestangularProvider', function (rp) {
            rp.setBaseUrl('webresources');
 
            //Se añade RequestInterceptor para borrar el cuerpo de la solicitud DELETE
            rp.addRequestInterceptor(function (data, operation) {
                if (operation === "remove") {
                    return null;
                }
                return data;
            });
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