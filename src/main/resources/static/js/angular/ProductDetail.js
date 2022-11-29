var app = angular.module("app", []);
var ur= window.location.href;
var id = ur.slice(ur.indexOf('sanpham/')+8)
app.controller('ctrlproductdetail', function($scope,$http) {

    $scope.items =[];

    function list () {
        $scope.url="/api/product/"+id;
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            console.log("s", resp)
            groupproduct($scope.items.groupProduct.id);
        }).catch(error => {
            console.log("fail", error)
        })
    }
    list();

     $scope.groupproduct =[];
     function groupproduct (id) {
            $scope.url="/api/product/groupproduct/"+id;
            $http.get($scope.url).then(resp => {
                $scope.groupproduct = resp.data;
                console.log("p", resp)
            }).catch(error => {
                console.log("fail", error)
            })
        }




})