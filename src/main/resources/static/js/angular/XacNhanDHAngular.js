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
            if($scope.items.length==0){
                window.location='/accounts/cart';
            }
        }).catch(error => {
            console.log("fail", error)
        });
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


    $scope.HuyDH = function (){
        $http.post("/accounts/huydh").then( reap =>{
            window.location='/accounts/cart';
        }).catch(error => {
            console.log("fail", error)
        });
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
        if($scope.pvc==20000 || $scope==30000){
            $http.post(url).then(resp => {
                if(resp.data.status==true){
                    showSuccessToast(resp.data.message)
                    setTimeout ( function () {
                        window.location='/accounts/cart';
                    }, 100);
                }else{
                    showErrorToast(resp.data.message)
                }
            }).catch(error => {
                console.log("fail", error)
            });
        }else{
            showErrorToast("Chưa chọn phương thức giao hàng")
        }
    }


});

