var app = angular.module("app", []);
app.controller('ctrlistproduct', function($scope,$http) {

    $scope.items =[];
    $scope.prop="-date";

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

    $scope.groups =[];

    function lists () {
        $scope.url="/admin/api/groupproductlist";
        $http.get($scope.url).then(resp => {
            $scope.groups = resp.data;
            console.log("s", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    lists();

    $scope.sortBy = function(prop){
        $scope.prop = prop;
    }

})
