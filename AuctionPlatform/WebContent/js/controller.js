var app = angular.module('auctionApp', []);
	app.controller('auctionCtrl', function($scope, $http) {
	    $http.get('js/data.json')
       .then(function(res){
          $scope.auctions = res.data;                
        });

       $scope.lessThan = function(prop, val){
			    return function(item){
			      return item[prop] <= val;
			    }
			}
	});