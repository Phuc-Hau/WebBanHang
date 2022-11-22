var app = angular.module("app", []);
app.controller('ctrlistproduct', function($scope,$http) {

    $scope.items =[];
    $scope.prop="-date";

    function list () {
        $scope.url="/admin/api/productlist";
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            $scope.itemstrue = $scope.items.filter(s=>s.status==true);
            $scope.itemsfalse= $scope.items.filter(s=>s.status==false);
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
        }).catch(error => {
            console.log("fail", error)
        })
    }
    lists();

    $scope.sortBy = function(prop){
        $scope.prop = prop;
    }

    $scope.ResetFilter = function (){
        $scope.Status ="";
        $scope.searchname ="";
        $scope.groupof="";
        list();
        lists();
    }

})
