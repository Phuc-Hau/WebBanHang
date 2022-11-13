var app = angular.module("app", []);
app.controller('ctrlistgroupproduct', function($scope,$http) {

    $scope.items =[];

    function list () {
        $scope.url="/admin/api/groupproductlist";
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            console.log("s", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    list();
})