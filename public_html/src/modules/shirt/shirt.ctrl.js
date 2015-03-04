(function () {
	var shirt = angular.module('shirtModule');

	shirt.controller('shirtCtrl', ['$scope', 'CRUDUtils', 'shirt.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
                        
                        this.mostPopulated = function () {
					var pop;
                                        pop=0;
                                        var pais;
                                        var arreglo;
                                        pais ="no hay paises en la tabla";
					arreglo = $scope.records;
                                        var i;
                                        for( i = 0; i< arreglo.length; i++)
                                        {
                                           if(arreglo[i].population > pop)
                                            {
                                           pop = arreglo[i].population;
                                           pais = arreglo[i].name;
                                            }
                                        }
                                        alert(pais);
                                        
				};
		}]);
            
})();