
var app = angular.module("app", []);
app.controller('ctrluser', function($scope,$http) {

    $scope.item={};
    function user () {
        $scope.url="/accounts/api/changinformation"
        $http.get($scope.url).then(resp => {
            $scope.item = resp.data;
            procvince($scope.item.cutomer.procvince, $scope.item.cutomer.district);
            $scope.GHN($scope.item.cutomer.procvince, $scope.item.cutomer.district,$scope.item.cutomer.ward);
            console.log("user", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    user();


    $scope.image;
    $scope.imag = function (img){
        $scope.image = img;
    }

    $scope.reset = function (){
        $scope.image='';
        user();
    }

    $scope.uploadfile = function (file) {
        var form = new FormData();
        form.append("files",file[0]);
        let urlfile = '/api/file/user';

        $http.post(urlfile,form,{
            transformRequest: angular.identity,
            headers:{'Content-Type': undefined}
        }).then(resp => {
            $scope.imag(resp.data[0]);
        }).catch(error => {
            console.log("fail", error)
        })
    }

    $scope.update = function (user){
        user.cutomer.procvince = document.getElementById("address_1").value;
        user.cutomer.district = document.getElementById('address_2').value;
        user.cutomer.birthday = document.getElementById('DateofBirth').value;
        if($scope.image != undefined){
            user.img= $scope.image;
        }

        $scope.urlUpdate ='/accounts/api/user/update';
        $http.post($scope.urlUpdate,user).then(resp => {
            if(resp.data.status==true){
                showSuccessToast(resp.data.message);
            }else{
                showErrorToast(resp.data.message);
            }
            console.log("ss", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }


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
            $scope.WardGHN($scope.districtGHN[0].DistrictID,WardID);
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
        })
    }



});



