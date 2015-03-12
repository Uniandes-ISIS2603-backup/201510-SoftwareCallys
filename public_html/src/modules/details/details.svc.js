(function(){
    var detailsModule = angular.module('detailsModule');
    
    detailsModule.service('detailsService', ['CRUDBase','details.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
           
                               
            }]);
       
    
})();
