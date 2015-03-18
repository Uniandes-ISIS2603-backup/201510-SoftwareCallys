(function(){
    var homeModule = angular.module('homeModule');
    
    homeModule.service('homeService', ['CRUDBase','home.context', function(CRUDBase, context){
            this.url = context;
            CRUDBase.extendService(this);
    }]);
})();
