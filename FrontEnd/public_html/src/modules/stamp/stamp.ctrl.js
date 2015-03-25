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
            this.error= false;
            var image;
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
            this.editStamp = function (catalog) 
            {
                catalogService.editRecord(catalog);
                this.editMode = true;
            };
            this.deleteStamp = function (catalogRecord) 
            {
                 catalogService.deleteRecord(catalogRecord);
                  catalogService.fetchRecords().then(function(data)
                     {
                        $scope.catalogRecords = data;
                     });
            };
            document.getElementById('files').addEventListener('change', handleFileSelect, false);
             function handleFileSelect(evt) 
             {
                        var files = evt.target.files; // FileList object
                        var reader = new FileReader();

                          // Closure to capture the file information.
                          reader.onload = (function() {
                            return function(e) 
                            {
                                image=e.target.result;
                            };
                          })(files[0]);

                          // Read in the image file as a data URL.
                          reader.readAsDataURL(files[0]);
            }

  
             this.saveStamp = function(catalogRecord,catalogForm)
             {
                 
                 if(catalogForm.$valid)
                 {
                    catalogRecord.image= image;
                    catalogService.saveRecord(catalogRecord); 
                     catalogService.fetchRecords().then(function(data)
                     {
                        $scope.catalogRecords = data;
                     });
                    this.editMode = false;
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