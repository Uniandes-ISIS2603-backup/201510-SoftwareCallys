(function () {
    var mock = angular.module('MockModule');

    mock.value('MockModule.mockRecords', {});

    mock.provider('MockModule.urls', function () {
        var context = [];
        this.registerUrl = function (value, skip) {
            context.push({url: value, skip: !!skip});
        };
        this.$get = function () {
            return context;
        };
    });
})();