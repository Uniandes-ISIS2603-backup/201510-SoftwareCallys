(function () {
	
		//Configuración módulo shirt
	var shirtModule = angular.module('shirtModule', ['CrudModule', 'MockModule', 'ui.grid']);

	shirtModule.constant('shirt.context', 'shirt');

	shirtModule.config(['shirt.context', 'MockModule.urlsProvider', function (context, urlsProvider) 
        {
            urlsProvider.registerUrl(context);
        }]);
})();