(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'stampModule','shirtModule']);

	mainApp.config(['$routeProvider', function ($routeProvider) {
			$routeProvider.when('/stamp', {templateUrl: 'src/modules/stamp/stamp.html'
                                
			}).when('/shirt', {templateUrl: 'src/modules/shirt/shirt.html'
                                
			}).otherwise('/');
		}]);

	//Configuración módulo stamp
	var stampModule = angular.module('stampModule', ['CrudModule', 'MockModule']);
        var shirtModule = angular.module('shirtModule', ['CrudModule', 'MockModule']);

	stampModule.constant('sptamp.context', 'stamp');
	stampModule.config(['stamp.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
                }]);
            
        shirtModule.constant('shirt.context', 'shirt');
        shirtModule.config(['shirt.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
})();