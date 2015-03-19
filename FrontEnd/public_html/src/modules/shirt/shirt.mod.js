(function () 
{
		//Configuración módulo shirt
	var shirtModule = angular.module('shirtModule', ['CrudModule', 'MockModdule']);

	shirtModule.constant('shirt.context', 'shirts');

	shirtModule.config(['shirt.context', 'MockModule.urlsProvider', function (context, urlsProvider) 
        {
            urlsProvider.registerUrl(context);
        }]);
})();