(function () 
{

	var mainApp = angular.module('mainApp', ['ngRoute', 'homeModule', 'stampModule','shirtModule','detailsModule','contactModule']);

	mainApp.config(['$routeProvider', function ($routeProvider) 
            {
                    $routeProvider.when('/home', 
                    {
			templateUrl: 'src/modules/home/home.tpl.html'
                    }).otherwise('/');
                    $routeProvider.when('/stamp', 
                    {
			templateUrl: 'src/modules/stamp/stamp.tpl.html'
                    }).otherwise('/');
                    $routeProvider.when('/shirt', 
                    {
			templateUrl: 'src/modules/shirt/shirt.tpl.html'
                    }).otherwise('/');
                    $routeProvider.when('/details', 
                    {
			templateUrl: 'src/modules/details/details.tpl.html'
                    }).otherwise('/');
                    $routeProvider.when('/contact', 
                    {
			templateUrl: 'src/modules/contact/contact.tpl.html'
                    }).otherwise('/');
            }]);

	//Configuración módulo home
	var homeModule = angular.module('homeModule', ['CrudModule', 'MockModule']);

	homeModule.constant('home.context', 'home');

	homeModule.config(['home.context', 'MockModule.urlsProvider', function (context, urlsProvider) 
        {
            urlsProvider.registerUrl(context);
        }]);
         
    //Configuración módulo stamp
	var stampModule = angular.module('stampModule', ['CrudModule', 'MockModule']);

	stampModule.constant('stamp.context', 'stamp');

	stampModule.config(['stamp.context', 'MockModule.urlsProvider', function (context, urlsProvider) 
        {
            urlsProvider.registerUrl(context);
        }]);
//Configuración módulo shirt
	var shirtModule = angular.module('shirtModule', ['CrudModule', 'MockModule']);

	shirtModule.constant('shirt.context', 'shirt');

	shirtModule.config(['shirt.context', 'MockModule.urlsProvider', function (context, urlsProvider) 
        {
            urlsProvider.registerUrl(context);
        }]);
    
    //Configuración módulo shirt
	var shirtModule = angular.module('detailsModule', ['CrudModule', 'MockModule']);

	shirtModule.constant('details.context', 'details');

	shirtModule.config(['details.context', 'MockModule.urlsProvider', function (context, urlsProvider) 
        {
            urlsProvider.registerUrl(context);
        }]);
    //Configuración módulo contact
    
	var contactModule = angular.module('contactModule', ['CrudModule', 'MockModule']);

	contactModule.constant('contact.context', 'contact');

	contactModule.config(['contact.context', 'MockModule.urlsProvider', function (context, urlsProvider) 
        {
            urlsProvider.registerUrl(context);
        }]);
        
})();