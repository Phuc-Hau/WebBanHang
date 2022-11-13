var app = angular.module("app", []);
app.controller('ctrlistproduct', function($scope,$http) {

    $scope.items =[];
    $scope.groups=[];
    $scope.groupof;

    $scope.urlgroup="/admin/api/groupproduct";
    $http.get($scope.urlgroup).then(resp => {
        $scope.groups = resp.data;
    }).catch(error => {
        console.log("fail", error)
    })

    function list () {
        $scope.url="/admin/api/productlist";
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            console.log("s", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    list();
})