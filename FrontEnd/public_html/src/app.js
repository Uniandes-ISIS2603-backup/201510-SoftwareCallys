(function () 
{

	var mainApp = angular.module('mainApp', ['ngRoute', 'stampModule','catalogModule','homeModule']);

	mainApp.config(['$routeProvider', function ($routeProvider) 
            {
                  
                    $routeProvider.when('/stamp', 
                    {
			templateUrl: 'src/modules/stamp/stamp.tpl.html'
                    }).otherwise('/');
                     $routeProvider.when('/home', 
                    {
			templateUrl: 'src/modules/home/home.tpl.html'
                    }).otherwise('/');
                    $routeProvider.when('/details', 
                    {
			templateUrl: 'src/modules/details/details.tpl.html'
                    }).otherwise('/');
                    $routeProvider.when('/catalog', 
                    {
			templateUrl: 'src/modules/catalog/catalog.tpl.html'
                    }).otherwise('/');
                    $routeProvider.when('/shirt', 
                    {
			templateUrl: 'src/modules/shirt/shirt.tpl.html'
                    }).otherwise('/');
                           
                           
            }]);



        
})();