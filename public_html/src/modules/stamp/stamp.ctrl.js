(function () {
	var app = angular.module('stampModule');

	app.controller('stampCtrl', ['$scope', 'CRUDUtils', 'stamp.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
                         this.fetchRecords();
                         this.editMode=false;
                                this.upload= function(){
                                    this.editMode= !this.editMode;
                                };
                                this.rateStamp = function(rating){
                                        $scope.currentRecord.rating = ($scope.currentRecord.rating + rating)/2;
                                        this.saveRecords();
                                        alert($scope.currentRecord.rating);
                                };
                                this.deleteStamp = function (record) {
					this.deleteRecord(record);
				};
                               
                                
                                 this.getStamp = function () {
				
					this.api.getList().then(function (data) {
						$scope.records = data;
						$scope.currentRecord = {};
						this.editMode = false;
					});
				};
            }]);
        app.directive('ratingStamps', function(){
           return{
               restrict: 'A',
               template: '<ul class="rating line1">'+
                           '<line1 ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">'+
                             '\u2605' +
                           '</line1>' +
                         '</ul>',
               scope: {
                   ratingValue: '=',
                   max: '=',
                   onRatingSelected: '&'
               },
               link: function (scope, elem, attrs){
                   var updateStars = function (){
                        scope.stars = [];
                        for(var i = 0; i < scope.max; i++){
                            scope.stars.push({filled: i < scope.ratingValue});
                        }
                   };
                   scope.toggle = function(index){
                       scope.ratingValue = index+1;
                       scope.onRatingSelected({
                          rating:index +1 
                       });
                   };
                   scope.$watch('ratingValue', function(newVal, oldVal) {
                       if(newVal){updateStars();}
                   });
               }
           } 
        });   
})();