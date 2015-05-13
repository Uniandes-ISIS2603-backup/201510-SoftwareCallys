(function ()
{
    var signupModule = angular.module('signupModule');
    signupModule.controller('signupCtrl', ['$scope', 'signupService', function ($scope, signupService)
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
           artistRecord.datosContacto="a";
           this.saveRecord(artistRecord);
           this.successfull = true;
        };
    }]);
})();