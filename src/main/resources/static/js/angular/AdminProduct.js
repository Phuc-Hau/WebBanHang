
var app = angular.module("app", []);

var ur= window.location.href;
var id = ur.slice(ur.indexOf('edit/')+5)

app.controller('ctradminproduct', function($scope,$http) {

    $scope.url="/admin/api/product/edit/"+id;
    $scope.items =[];
    $http.get($scope.url).then(resp => {
        $scope.items = resp.data;
        console.log("Success", resp)
    }).catch(error => {
        console.log("fail", error)
    })

});