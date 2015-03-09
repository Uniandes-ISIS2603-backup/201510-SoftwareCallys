(function () {
	var shirt = angular.module('shirtModule');

	shirt.controller('shirtCtrl', ['$scope', 'CRUDUtils', 'shirt.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
                        this.rojo= true;
                        this.verde = true;
                        this.azul= true;
                        this.all=true;
                        
                        this.mostrarRojo = function (){
                          
                            this.rojo = true;
                            this.verde = false;
                            this.azul= false;
                            this.all= false;
                        };
                        this.mostrarVerde = function (){
                          
                            this.rojo = false;
                            this.verde = true;
                            this.azul= false;
                            this.all=false;
                        };
                        this.mostrarAzul = function (){
                          
                            this.rojo = false;
                            this.verde = false;
                            this.azul= true;
                            this.all=false;
                        };
                        this.mostrarTodo = function (){
                          
                            this.rojo = true;
                            this.verde = true;
                            this.verde= true;
                            this.all= true;
                        };
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