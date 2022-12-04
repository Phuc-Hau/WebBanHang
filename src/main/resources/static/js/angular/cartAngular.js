var app = angular.module("myApp", []);

var url=`/accounts`;

app.controller('ctrcart', function($scope,$http) {
    $scope.items =[];

    $scope.list = function () {

        $http.get(url+`/list`).then(resp => {
            $scope.items = resp.data;
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })

    }
    $scope.list();

    $scope.getPricesum = function(){
        let amount = 0;
        for (let index = 0; index < $scope.items.length; index++) {
            if($scope.items[index].check==true) {
                amount += $scope.items[index].quantity * ($scope.items[index].product.price*(1-$scope.items[index].product.sale));
            }
        }
        return amount;
    }

    $scope.getSize = function(){
        return  $scope.items.length;
    }

    $scope.getAmount = function(){
        let amount = 0;
        for (let index = 0; index < $scope.items.length; index++) {
            amount += $scope.items[index].quantity;
        }
        return amount;
    }

    $scope.pre = function (id) {
        var index = $scope.items.findIndex(element => element.id == id);
        if($scope.items[index].quantity > 1) {
            $http.get(url+`/cart/pre/`+id).then(resp => {

                    $scope.items[index].quantity--;

            }).catch(error => {
                console.log("fail", error)
            })
        }
    }


    $scope.plus = function (id) {
        var index = $scope.items.findIndex(element => element.id == id);
        $http.get(url+`/cart/plus/`+id).then(resp => {
            $scope.items[index].quantity ++;
        }).catch(error => {
            console.log("fail", error)
        })
    }

    $scope.delete = function (id){
        var index = $scope.items.findIndex(element => element.id == id);
        $http.post(url+`/cart/delete/`+id).then(resp => {
            $scope.items.splice(index, 1);
        }).catch(error => {
            console.log("fail", error)
        });
    }

    $scope.newpay = function (items){
        $scope.cardpay = items.filter(x => x.check ==true);
        for (let i = 0; i < $scope.cardpay.length ; i++) {
            delete $scope.cardpay[i] ['check'];
            delete $scope.cardpay[i] ['order'];
        }

        if($scope.cardpay.length == 0 ){
            showErrorToast("Chưa chọn sản phẩm");
        }else{
            console.log("ee",$scope.cardpay)
            $http.post(url+`/cart/newpay`,$scope.cardpay).then(resp => {
                window.location='/accounts/xacnhandonhang';
            }).catch(error => {
                console.log("fail", error)
            });
        }

    }




});
