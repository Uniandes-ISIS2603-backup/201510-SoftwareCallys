(function () 
{

	var mainApp = angular.module('mainApp', ['ngRoute', 'homeModule']);

	mainApp.config(['$routeProvider', function ($routeProvider) 
            {
                    $routeProvider.when('/home', 
                    {
			templateUrl: 'src/modules/home/home.tpl.html'
                    }).otherwise('/');
            }]);

	//Configuración módulo home
	var sportModule = angular.module('homeModule', ['CrudModule', 'MockModule']);

	sportModule.constant('home.context', 'sports');

	sportModule.config(['home.context', 'MockModule.urlsProvider', function (context, urlsProvider) 
        {
            urlsProvider.registerUrl(context);
        }]);
            

        
})();