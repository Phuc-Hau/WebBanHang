let host='/accounts/api/changinformation';

var app = angular.module("myApp", []);

app.controller("myCtrl", function($scope,$http) {

    $scope.load = function(){
        var url = `${host}`;
        $http.get(url).then( resp =>{
            $scope.user = resp.data;

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

    $scope.EditAddress = function (use){
        $scope.editaddress = angular.copy(use);
        procvince(use.cutomer.procvince, use.cutomer.district);
    }

    $scope.pay = {};

    $scope.UpdateAddress = function (editaddress){
        $scope.user.cutomer.name = editaddress.cutomer.name;
        $scope.user.cutomer.tel = editaddress.cutomer.tel;
        $scope.user.cutomer.procvince = document.getElementById("address_1").value;
        $scope.user.cutomer.district = document.getElementById("address_2").value;
        $scope.user.cutomer.address = document.getElementById('addressedit').value;

        $scope.pay.receiver =  editaddress.cutomer.name;
        $scope.pay.tel = editaddress.cutomer.tel;
        $scope.pay.procvince = document.getElementById("address_1").value;
        $scope.pay.district = document.getElementById("address_2").value;
        $scope.pay.address = document.getElementById('addressedit').value;

    }

    $scope.DatHang = function (user){
        var url ='/accounts/cart/pay';

        if($.isEmptyObject($scope.pay)){
            $scope.pay.receiver =  user.cutomer.name;
            $scope.pay.tel = user.cutomer.tel;
            $scope.pay.procvince = user.cutomer.procvince;
            $scope.pay.district = user.cutomer.district;
            $scope.pay.address =user.cutomer.address;
        }

        $scope.pay.dv = $scope.dv;
        console.log("p",$scope.pay)

        if($scope.pvc==20000 || $scope.pvc==30000){
            $http.post(url,$scope.pay).then(resp => {
                if(resp.data.status==true){
                    showSuccessToast(resp.data.message)
                    setTimeout ( function () {
                        window.location='/accounts/orderstatus';
                    }, 500);
                    //

                    $scope.cart;
                    var json = localStorage.getItem("cart");
                    $scope.cart = json ? JSON.parse(json) : []
                    $scope.cart = [];
                    var json = JSON.stringify(angular.copy($scope.cart));
                    localStorage.setItem("cart",json);

                    //
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

function Edit(i) {
    if(i==1){
        document.getElementById("diachi").contentEditable = true;
    }
    if(i==0){
        document.getElementById("nguoinhan").contentEditable = true;
    }
}


$('#myModal').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
})
function onlyNumberKey(evt) {
    var ASCIICode = (evt.which) ? evt.which : evt.keyCode
    if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
        return false;
    return true;
}



