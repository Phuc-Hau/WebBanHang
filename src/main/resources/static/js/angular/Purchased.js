var app = angular.module("app", []);

app.controller('crlPurchased', function($scope,$http) {
    $scope.purchasedlist = [];
    $scope.urllist = "/accounts/api/userQuantityProduct/1";

    $scope.list = function (){
        $http.get($scope.urllist).then(resp => {
            $scope.purchasedlist = resp.data;
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    $scope.list();
});