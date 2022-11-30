
var app = angular.module("app", []);
app.controller('ctrluser', function($scope,$http) {

    $scope.item={};
    function user () {
        $scope.url="/accounts/api/changinformation"
        $http.get($scope.url).then(resp => {
            $scope.item = resp.data;
            procvince($scope.item.cutomer.procvince, $scope.item.cutomer.district);
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



});



