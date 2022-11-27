var app = angular.module("app", []);
var ur= window.location.href;
var id = ur.slice(ur.indexOf('sanpham/')+8)
app.controller('ctrlproductdetail', function($scope,$http) {

    $scope.items =[];

    function list () {
        $scope.url="/product/api/"+id;
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            console.log("s", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }

    list();


})