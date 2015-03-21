(function () {
    var crud = angular.module('CrudModule');

    crud.factory('CRUDBase', ['Restangular', function (RestAngular) {
            function crudConstructor() {
                this.api = RestAngular.all(this.url);

                this.fetchRecords = function (currentPage, itemsPerPage) {
                    return this.api.getList(null, {page: currentPage, maxRecords: itemsPerPage});
                };
                this.saveRecord = function (currentRecord) {
                    if (currentRecord.id) {
                        return currentRecord.put();
                    } else {
                        return this.api.post(currentRecord);
                    }
                };
              
                this.deleteRecord = function (record) {
                    return record.remove();
                };
                this.extendCtrl = function (ctrl, scope) {
                    //Variables para el scope
                    scope.currentRecord = {};
                    scope.records = [];

                    //Variables de paginacion
                    scope.maxSize = 5;
                    scope.itemsPerPage = 5;
                    scope.totalItems = 0;
                    scope.currentPage = 1;

                    //Variables para el controlador
                    ctrl.editMode = false;

                    //Funciones que no requieren del servicio
                    ctrl.createRecord = function () {
                        this.editMode = true;
                        scope.currentRecord = {};
                    };
                    ctrl.editRecord = function (record) {
                        scope.currentRecord = RestAngular.copy(record);
                        this.editMode = true;
                    };

                    //Funciones que usan el servicio CRUD
                    var service = this;

                    ctrl.pageChanged = function () {
                        this.fetchRecords();
                    };

                    ctrl.fetchRecords = function () {
                        return service.fetchRecords(scope.currentPage, scope.itemsPerPage).then(function (data) {
                            scope.records = data;
                            scope.totalItems = data.totalRecords;
                            scope.currentRecord = {};
                            ctrl.editMode = false;
                            return data;
                        });
                    };
                    ctrl.saveRecord = function () {
                        return service.saveRecord(scope.currentRecord).then(function () {
                            ctrl.fetchRecords();
                        });
                    };
                    ctrl.deleteRecord = function (record) {
                        return service.deleteRecord(record).then(function () {
                            ctrl.fetchRecords();
                        });
                    };
                };
            }
            return {extendService: function (svc) {
                    crudConstructor.call(svc);
                }};
        }]);
})();
