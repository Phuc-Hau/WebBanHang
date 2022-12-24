
var app = angular.module("app", []);


app.controller('ctradminstatisticalproduct', function($scope,$http) {

    $scope.StatisticalProduct =[];
    function lists () {
        $http.get(`/admin/api/StatisticalProduct`).then(resp => {
            var StatisticalProduct = resp.data;
            StatisticalProduct.reduce(function(res, value) {
                if (!res[value.product.id]) {
                    res[value.product.id] = { product: value.product, quantity: 0 };
                    $scope.StatisticalProduct.push(res[value.product.id])
                }
                res[value.product.id].quantity += value.quantity;
                return res;
            }, {});

            console.log("StatisticalProduct", $scope.StatisticalProduct)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    lists();

});