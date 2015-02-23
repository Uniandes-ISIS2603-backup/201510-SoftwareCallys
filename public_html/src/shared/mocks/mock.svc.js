(function () {
	var mock = angular.module('MockModule');

	mock.provider('MockModule.urls', function () {
		var context = [];
		this.registerUrl = function (value) {
			context.push('webresources/' + value);
		};
		this.$get = function () {
			return context;
		};
	});
})();