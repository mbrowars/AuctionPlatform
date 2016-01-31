var app = angular.module('auctionApp', []);
	app.controller('auctionCtrl', function($scope, $http) {
	    $http.get('js/data.json')
       .then(function(res){
          $scope.auctions = res.data;
          $scope.maxPrice = Math.round(getMax(res.data));
        });

       $scope.lessThan = function(prop, val){
			    return function(item){
			      return item[prop] <= val;
			    }
			}
      
	});
	
	
function getMax(arr) {
    var max = 0;
    for (var i=0 ; i<arr.length ; i++) {
        if (!max || parseInt(arr[i]["price"]) > parseInt(max["price"]))
            max = arr[i];
    }
    return max["price"];
}