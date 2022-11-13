var app = angular.module("app", []);

app.controller('orderstatus', function($scope,$http) {

    //list
    $scope.urllist="/accounts/api/listorderstatus";
    //liststatus
    $scope.urlgroup="/accounts/api/listordersDetailltatus/";
    $scope.orderlist =[];
    $scope.orderstatus =[];



    $http.get($scope.urllist).then(resp => {
        $scope.orderlist = resp.data;
        console.log("Success", resp)
    }).catch(error => {
        console.log("fail", error)
    })


    $scope.orderid = function (id){
        $http.get($scope.urlgroup+id).then(resp => {
            $scope.orderstatus = resp.data;
            console.log("Success Group", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }



});