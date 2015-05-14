(function () 
{

	var mainApp = angular.module('mainApp', ['ngRoute', 'stampModule','catalogModule','loginModule','shirtModule','signupModule','detailsModule','contactModule','purchaseModule', 'clientModule']);

	mainApp.config(['$routeProvider', function ($routeProvider) 
            {
                  
                    $routeProvider.when('/stamp', 
                    {
			templateUrl: 'src/modules/stamp/stamp.tpl.html'
                    }).otherwise('/');
                    $routeProvider.when('/signup', 
                    {
			templateUrl: 'src/modules/signup/signup.tpl.html'
                    }).otherwise('/');
                     $routeProvider.when('/login', 
                    {
			templateUrl: 'src/modules/login/login.tpl.html'
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
                    $routeProvider.when('/contact', 
                    {
			templateUrl: 'src/modules/contact/contact.tpl.html'
                    }).otherwise('/');     
                    $routeProvider.when('/purchase', 
                    {
			templateUrl: 'src/modules/purchase/purchase.tpl.html'
                    }).otherwise('/');
                    $routeProvider.when('/client', 
                    {
			templateUrl: 'src/modules/client/client.tpl.html'
                    }).otherwise('/');
            }]);



        
})();