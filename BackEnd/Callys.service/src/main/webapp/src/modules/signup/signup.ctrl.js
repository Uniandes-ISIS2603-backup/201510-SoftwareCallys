(function (angular)
{
    var signupModule = angular.module('signupModule');
    signupModule.controller('signupCtrl', ['$scope', 'signupService','clientService', function ($scope, signupService, clientService)
    {
        this.client = false;
        this.artist = false;
        this.successfull = false;
        signupService.extendCtrl(this, $scope);
        this.clientFunction = function ()
        {
            this.client = !this.client;
        };
        this.artistFunction = function ()
        {
            this.artist = !this.artist;
        };
        this.saveArtist= function (artistRecord)
        {
           this.saveRecord(artistRecord);
           this.successfull = true;
        };
        this.saveClient= function (clientRecord)
        {
           clientService.saveRecord(clientRecord);
           this.successfull = true;
        };
    }]);
})(window.angular);