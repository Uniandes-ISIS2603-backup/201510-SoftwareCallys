(function () {
    
    var stampModule = angular.module('stampModule');
    
    stampModule.controller('stampCtrl', ['$scope', 'stampService', 'stampGet','catalogService', function ($scope, stampService,stampGet,catalogService) {
            stampService.extendCtrl(this, $scope);
            stampGet.get({}, function (stampGet) {
                    $scope.name = stampGet.name;
                });
            this.fetchRecords();
            catalogService.fetchRecords().then(function(data){
                $scope.catalogRecords = data;
            });
            this.editMode = false;
            this.upload = function () 
            {
                this.editMode = !this.editMode;
            };

            this.rate = function () 
            {
                this.saveRecords();
            };

            this.rateStamp = function (rating) 
            {
                $scope.currentRecord.rating = rating;
                this.saveRecords();

            };
            this.deleteStamp = function (record) 
            {
                this.deleteRecord(record);

            };
             this.saveCatalog = function(catalogRecord)
             {
                catalogService.saveRecord(catalogRecord); 
                 catalogService.fetchRecords().then(function(data)
                 {
                    $scope.catalogRecords = data;
                 });
                this.editMode = false;
            };
        }]);
    stampModule.directive('ratingStamps', function () {
        return{
            restrict: 'A',
            template: '<ul class="rating line1">' +
                    '<line1 ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">' +
                    '\u2605' +
                    '</line1>' +
                    '</ul>',
            scope: {
                ratingValue: '=',
                max: '='
            },
            link: function (scope, elem, attrs) {
                var updateStars = function () {
                    scope.stars = [];
                    for (var i = 0; i < scope.max; i++) {
                        scope.stars.push({filled: i < scope.ratingValue});
                    }
                };
                scope.toggle = function (index) {
                    scope.ratingValue = index + 1;
                    elem.onRatingSelected({
                        rating: index + 1
                    });
                };
                scope.$watch('ratingValue', function (oldVal, newVal) {
                    if (newVal) {
                        updateStars();
                    }
                });
            }
        }
    });

})();