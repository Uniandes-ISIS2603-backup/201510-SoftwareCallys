(function () {
	var shirtModule = angular.module('shirtModule');

	shirtModule.controller('shirtCtrl', ['$scope', 'shirtService', function ($scope, shirtService) {
                        shirtService.extendCtrl(this, $scope);
			this.fetchRecords();
                        this.rojo= true;
                        this.verde = true;
                        this.azul= true;
                        this.all=true;
                        
                         $scope.myData = [{name: "Moroni", age: 50},
                     {name: "Tiancum", age: 43},
                     {name: "Jacob", age: 27},
                     {name: "Nephi", age: 29},
                     {name: "Enos", age: 34}];
    $scope.gridOptions = { data: 'myData' };
                        
                        
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
                       
		}]);
            
})();