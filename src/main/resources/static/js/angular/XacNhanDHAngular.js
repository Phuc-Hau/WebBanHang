let host='/accounts/api/changinformation';


var app = angular.module("myApp", []);

app.controller("myCtrl", function($scope,$http,$location) {

    $scope.load = function(){
        var url = `${host}`;
        $http.get(url).then( resp =>{
            $scope.it = resp.data;
            console.log(resp)

        })
    }
    $scope.load();

    let hostcart='/accounts/order/confirm';
    $scope.items=[];

    $scope.loadcart = function(){
        $http.post(hostcart).then( resp =>{
            $scope.items = resp.data;
            console.log("ad",resp);
        })
    }
    $scope.loadcart();
});
