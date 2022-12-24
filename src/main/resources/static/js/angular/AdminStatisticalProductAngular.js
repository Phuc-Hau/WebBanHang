
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

    $scope.detail = function (id){
        $http.get(`/admin/api/detailsStatisticalProduct/`+id).then(resp => {
            $scope.detailsStatisticalProduct = resp.data;
            document.getElementById('filled-stars').style.width=$scope.detailsStatisticalProduct.star/5*100+'%'
            console.log("detailsStatisticalProduct", resp.data)
        }).catch(error => {
            console.log("fail", error)
        })
    }

});