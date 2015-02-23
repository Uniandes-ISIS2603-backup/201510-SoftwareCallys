(function () {
	var mocksModule = angular.module('MockModule', ['ngMockE2E']);

	mocksModule.run(['$httpBackend', 'MockModule.urls', function ($httpBackend, urls) {
			function mockUrls(url) {
				var records = [];
				var url_regexp = new RegExp(url + '/([0-9]+)');
				$httpBackend.whenGET(url).respond(function (method, url, data) {
					return [200, records, {}];
				});
				$httpBackend.whenGET(url_regexp).respond(function (method, url, data) {
					var id = url.split('/').pop();
					var record;
					angular.forEach(records, function (value, key) {
						if (value.id == id) {
							record = angular.copy(value);
						}
					});
					return [200, record, {}];
				});
				$httpBackend.whenPOST(url).respond(function (method, url, data) {
					var record = angular.fromJson(data);
					record.id = Math.floor(Math.random() * 10000);
					records.push(record);
					return [200, record, {}];
				});
				$httpBackend.whenPUT(url_regexp).respond(function (method, url, data) {
					var record = angular.fromJson(data);
					angular.forEach(records, function (value, key) {
						if (value.id === record.id) {
							records.splice(key, 1, record);
						}
					});
					return [200, null, {}];
				});
				$httpBackend.whenDELETE(url_regexp).respond(function (method, url, data) {
					var id = url.split('/').pop();
					angular.forEach(records, function (value, key) {
						if (value.id == id) {
							records.splice(key, 1);
						}
					});
					return [200, null, {}];
				});
				$httpBackend.whenGET(/^((?!webresources).)*$/).passThrough();
			};
			for (var i in urls) {
				mockUrls(urls[i])
			}
		}]);
})();