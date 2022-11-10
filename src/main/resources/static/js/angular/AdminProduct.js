
var app = angular.module("app", []);

var ur= window.location.href;
var id = ur.slice(ur.indexOf('edit/')+5)

app.controller('ctradminproduct', function($scope,$http) {

    $scope.url="/admin/api/product/edit/"+id;
    $scope.items ={};

    function list () {
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }

    list();

    $scope.reset = function () {
        list();
    }

    $scope.update = function () {
        console.log("m",$scope.items)
    }

});