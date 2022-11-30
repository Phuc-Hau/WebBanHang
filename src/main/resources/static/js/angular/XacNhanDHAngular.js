let host='/accounts/api/changinformation';

var app = angular.module("myApp", []);

app.controller("myCtrl", function($scope,$http) {

    $scope.load = function(){
        var url = `${host}`;
        $http.get(url).then( resp =>{
            $scope.it = resp.data;
            console.log(resp)
        })
    }
    $scope.load();

    let hostcart='/accounts/order/confirm';
    $scope.items=[];

    $scope.loadcart = function(){
        $http.post(hostcart).then( resp =>{
            $scope.items = resp.data;
            sumMoney($scope.items);
            console.log("h",resp)
        })
    }
    $scope.loadcart();

    $scope.summoney;





    function sumMoney(item){
        let u=0;
        for (let i = 0; i < item.length; i++) {
            u += item[i].product.price *(1- item[i].product.sale) * item[i].quantity;
        }
        $scope.summoney = u;
    }

    $scope.dv=1;
    $scope.dvgh =function() {
        if($scope.dv==1){
            $scope.pvc = 20000;
        }
        if($scope.dv==2){
            $scope.pvc = 30000;
        }

    }

    $scope.DatHang = function (items){
        var url ='/accounts/cart/pay/'+$scope.dv;
        $http.post(url).then(resp => {

        }).catch(error => {
            console.log("fail", error)
        });
    }


});

