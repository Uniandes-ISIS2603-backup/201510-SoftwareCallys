(function (angular)
{
    var stampModule = angular.module('stampModule');
    stampModule.controller('stampCtrl', ['$scope', 'stampService', 'catalogService', function ($scope, stampService,catalogService)
    {
        stampService.extendCtrl(this, $scope);
        this.fetchRecords();
        catalogService.fetchRecords().then(function(data)
        {
            $scope.catalogRecords = data;
        });
        this.artist=catalogService.artist;
        this.uploadMode = false;
        this.editMode = false;
        this.error= false;
        this.artistaId=false;
        this.maxPrice=false;
        this.minPrice=false;
        this.topic= false;
        this.upload = function ()
        {
            this.uploadMode = !this.uploadMode;
        };
        this.edit = function ()
        {
            this.editMode = !this.editMode;
        };
        this.rate = function ()
        {
            this.saveRecords();
        };
        this.likeStamp = function (record)
        {
            record.rating +=1;
            catalogService.saveRecord(record);
            catalogService.fetchRecords().then(function(data)
                {
                   $scope.catalogRecords = data;
                });
        };
        this.dislikeStamp = function (record)
        {
            record.rating = record.rating-1;
            catalogService.saveRecord(record);
            catalogService.fetchRecords().then(function(data)
                {
                   $scope.catalogRecords = data;
                });
        };
        this.editStamp = function (record)
        {
            this.uploadMode = true;
            this.editRecord(record);
            catalogService.fetchRecords().then(function(data)
            {
               $scope.catalogRecords = data;
            });
        };
        this.deleteStamp = function (catalogRecord)
        {
             catalogService.deleteRecord(catalogRecord);
              catalogService.fetchRecords().then(function(data)
                 {
                    $scope.catalogRecords = data;
                 });
        };
        this.getBestStampByRating = function () {
               return stampService.getBestStampByRating();
            };
         this.getStampsByTopic = function (topic) {
                return stampService.getStampsByTopic(topic);
            };
         this.getStampsByPrice = function (minPrice,maxPrice) {
               return stampService.getStampsByPrice(minPrice,maxPrice);
            };
          this.getStampsByArtist = function (artistaId) {
                return stampService.getStampsByArtist(artistaId);
            };
        this.saveStamp = function(catalogRecord,catalogForm)
        {
            if(catalogForm.$valid)
            {
               catalogRecord.image= "image";
               catalogRecord.rating= 0;
               catalogService.saveRecord(catalogRecord);
               catalogService.fetchRecords().then(function(data)
               {
                  $scope.catalogRecords = data;
               });
               this.uploadMode = false;
                this.error=false;
               catalogForm.$setPristine();
               catalogForm.$setUntouched();
            }
            else
            {
               catalogForm.$setPristine();
               this.error=true;
            }
        };
    }]);
})(window.angular);