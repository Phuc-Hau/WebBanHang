let host='/accounts/api/changinformation';

var app = angular.module("myApp", []);
app.controller("myCtrl", function($scope,$http) {
    $scope.pvc=0;
    $scope.load = function(){
        var url = `${host}`;
        $http.get(url).then( resp =>{
            $scope.user = resp.data;
            $scope.GHN($scope.user.cutomer.procvince, $scope.user.cutomer.district);
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
                window.location='/shopping/cart';
            }
            console.log("sp",resp);
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
            window.location='/shopping/cart';
        }).catch(error => {
            console.log("fail", error)
        });
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
        var ward = JSON.parse(document.getElementById("wards").value);
        $scope.user.cutomer.ward = ward.WardName;
        $scope.user.cutomer.address = document.getElementById('addressedit').value;

        $scope.pay.receiver =  editaddress.cutomer.name;
        $scope.pay.tel = editaddress.cutomer.tel;
        $scope.pay.procvince = document.getElementById("address_1").value;
        $scope.pay.district = document.getElementById("address_2").value;
        $scope.pay.ward = ward.WardName;
        $scope.pay.address = document.getElementById('addressedit').value;

        $scope.GHN($scope.pay.procvince, $scope.pay.district, ward.WardName);
        $scope.CalculateFeeGHN();

    }

    $scope.DatHang = function (user){
        var url ='/accounts/cart/pay';

        if($.isEmptyObject($scope.pay)){
            $scope.pay.receiver =  user.cutomer.name;
            $scope.pay.tel = user.cutomer.tel;
            $scope.pay.procvince = user.cutomer.procvince;
            $scope.pay.district = user.cutomer.district;
            $scope.pay.address =user.cutomer.address;
            $scope.pay.ward = user.cutomer.ward;
        }

        $scope.pay.deliveryCharges = $scope.CalculateFee.total;
            if($scope.pay.deliveryCharges>0) {
                $http.post(url, $scope.pay).then(resp => {
                    if (resp.data.status == true) {
                        showSuccessToast(resp.data.message)
                        setTimeout(function () {
                            window.location = '/accounts/orderstatus';
                        }, 500);
                        //

                        $scope.cart;
                        var json = localStorage.getItem("cart");
                        $scope.cart = json ? JSON.parse(json) : []
                        $scope.cart = [];
                        var json = JSON.stringify(angular.copy($scope.cart));
                        localStorage.setItem("cart", json);

                        //
                    } else {
                        showErrorToast(resp.data.message)
                    }
                }).catch(error => {
                    console.log("fail", error)
                });
            }else{
                showErrorToast("Vui long chọn lại đơn vị giao hàng!")
            }
    }

    $scope.CalculateFee ={};

    $scope.GHN = function (ProvinceID,DistrictID,WardID){

        $scope.provinceGHN = {};
        // provinceGHN
        $http.get(`https://online-gateway.ghn.vn/shiip/public-api/master-data/province`,{
            headers:{'Content-Type': 'application/json',
                'Token':'c7dd3752-81b7-11ed-be76-3233f989b8f3'
            }
        }).then( resp =>{
            $scope.provinceGHN = resp.data.data.filter(s=>s.ProvinceName == ProvinceID);
            $scope.DistrictGHN($scope.provinceGHN[0].ProvinceID, DistrictID,WardID);
        })

    }

    $scope.DistrictGHN =function (ProvinceID,DistrictID,WardID){
        // districtGHN
        $http.post(`https://online-gateway.ghn.vn/shiip/public-api/master-data/district`,
            {
                "province_id": ProvinceID
            },
            {
                headers:{'Content-Type': 'application/json',
                    'Token':'c7dd3752-81b7-11ed-be76-3233f989b8f3'
                }
            }
        ).then( resp =>{
            $scope.districtGHN = resp.data.data.filter(s=>s.DistrictName == DistrictID);
            $scope.ServicesGHN($scope.districtGHN[0].DistrictID);
            $scope.WardGHN($scope.districtGHN[0].DistrictID,WardID);
            $scope.CalculateFeeGHN();
        })
    }

    $scope.Ward =function (){
        var procvince = document.getElementById("address_1").value;
        var district = document.getElementById("address_2").value;
        $scope.GHN(procvince,district);
    }

    $scope.WardGHN =function (DistrictID,WardID){
        // WardGHN
        $http.post(`https://online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id`,
            {
                "district_id": DistrictID
            },
            {
                headers:{'Content-Type': 'application/json',
                    'Token':'c7dd3752-81b7-11ed-be76-3233f989b8f3'
                }
            }
        ).then( reap =>{
            if(WardID != null){
                $scope.wardGHN = reap.data.data.filter(s=>s.WardName == WardID);
            }else{
                $scope.wardGHN = reap.data.data;
            }
            $scope.setCalculateFeeWard($scope.wardGHN[0])
        })
    }

    $scope.services =[];
    $scope.ServicesGHN = function (DistrictID){
        //servicesGHN
        $http.post(`https://online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/available-services`,
            {
                "shop_id":3487060,
                "from_district": 1454,
                "to_district": DistrictID
            },
            {
                headers:{'Content-Type': 'application/json',
                    'Token':'c7dd3752-81b7-11ed-be76-3233f989b8f3'
                }
            }
        ).then( reap =>{
            $scope.services = reap.data.data;
            $scope.setCalculateFeeServices(reap.data.data)
        })
    }

    $scope.setCalculateFeeWard = function (Ward){
        $scope.CalculateFee.Ward = Ward;
    }
    $scope.setCalculateFeeServices = function (Services){
        $scope.CalculateFee.Services = Services;
    }
    $scope.setCalculateFeetotal = function (Total){
        $scope.CalculateFee.total = Total;
    }

    $scope.CalculateFeeGHN = function (){

        console.log("u", $scope.CalculateFee);

        var dv = document.getElementById("dv").value;

        try {
            $scope.services = $scope.CalculateFee.Services.filter(s=>s.service_id == dv);
        }catch (e) {
            $scope.services = $scope.CalculateFee.Services;
        }

        // Calculate Fee GHN
        $http.post(`https://online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/fee`,
            {
                "from_district_id":1454,
                "service_id":$scope.services[0].service_id,
                "service_type_id":$scope.services[0].service_type_id,
                "to_district_id":$scope.CalculateFee.Ward.DistrictID,
                "to_ward_code": "`"+$scope.CalculateFee.Ward.WardCode+"`" ,
                "height":30,
                "length":20,
                "weight":20,
                "width":20,
                "insurance_value":10000,
                "coupon": null
            },
            {
                headers:{'Content-Type': 'application/json',
                    'Token':'c7dd3752-81b7-11ed-be76-3233f989b8f3'
                }
            }
        ).then( reap =>{
            console.log("GHN", reap.data)
            $scope.pvc = reap.data.data.total;
            $scope.setCalculateFeetotal(reap.data.data.total)
        })
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



