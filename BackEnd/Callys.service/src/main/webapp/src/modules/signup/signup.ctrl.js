(function ()
{
    var signupModule = angular.module('signupModule');
    signupModule.controller('signupCtrl', ['$scope', 'signupService', function ($scope, signupService)
    {
                signupService.extendCtrl(this, $scope);
                
                


    }]);
})();