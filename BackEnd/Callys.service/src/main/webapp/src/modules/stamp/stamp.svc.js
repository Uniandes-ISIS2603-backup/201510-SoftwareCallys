(function(angular)
{
    var stampModule = angular.module('stampModule');
    stampModule.service('stampService', ['CRUDBase','stamp.context', function(CRUDBase, context)
    {
        this.url = context;
        CRUDBase.extendService(this);
        
        this.getBestStampByRating = function () {
                return this.api.customGET('bestRating');
            };
        this.getStampsByTopic = function (topic) {
                return this.api.customGET('byTopic', {topic:topic});
            };  
         this.getStampsByPrice = function (minPrice,maxPrice) {
                return this.api.customGET('byPrice', {minPrice:minPrice,maxPrice:maxPrice});
            }; 
         this.getStampsByArtist = function (artistaId) {
                return this.api.customGET('byArtist', {idArtist:artistaId});
            }; 
            
        
    }]);
})(window.angular);