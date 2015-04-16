(function ()
{
    var shirt = angular.module('contactModule');
    shirt.controller('contactCtrl', ['$scope', 'contactService', function ($scope, contactService)
    {
        contactService.extendCtrl(this, $scope);
        this.fetchRecords();
    }]);
})();
