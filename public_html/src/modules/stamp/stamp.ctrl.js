(function () {
	var app = angular.module('stampModule');

	app.controller('stampCtrl', ['$scope', 'CRUDUtils', 'stamp.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
                         this.editMode=false;
            this.upload= function(){
                this.editMode=true;
            }; 
            }]);
        app.directive('stampsRating', function(){
           return{
               restrict: 'A',
               template: '<ul class="rating">'+
                           '<li ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">'+
                             '\u2605' +
                           '</li>' +
                         '</ul>',
               scope: {
                   ratingValue: '=',
                   max: '='
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
                   };
                   scope.$watch('ratingValue', function(oldVal, newVal) {
                       if(newVal){updateStars();};
                   });
               }
           } 
        });   
})();