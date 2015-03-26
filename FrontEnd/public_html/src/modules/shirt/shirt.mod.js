(function ()
{
        var shirtModule=angular.module('shirtModule',['CrudModule','MockModule']);
        shirtModule.constant('shirt.context','shirt');
	shirtModule.config(['shirt.context','MockModule.urlsProvider',function(context,urlsProvider)
        {
            urlsProvider.registerUrl(context);
        }]);
})();