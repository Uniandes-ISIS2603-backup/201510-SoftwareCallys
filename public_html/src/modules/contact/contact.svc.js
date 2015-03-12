(function(){
    var clientModule = angular.module('clientModule');
    
    clientModule.service('clientService', ['CRUDBase','catalog.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
           
                               
            }]);
       
    
})();