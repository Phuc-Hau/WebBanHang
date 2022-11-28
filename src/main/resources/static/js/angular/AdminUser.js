
var app = angular.module("app", []);
app.controller('ctradminuser', function($scope,$http) {

    $scope.item={};
    var ur= window.location.href;
    var id = ur.slice(ur.indexOf('user=')+5);

    function user () {
        $scope.urledit="/admin/api/user/edit/user="+id;
        if($scope.urledit.indexOf('user=:') ==-1) {
            $http.get($scope.urledit).then(resp => {
                $scope.item = resp.data;

                procvince($scope.item.cutomer.procvince, $scope.item.cutomer.district);

                console.log("user", resp)
            }).catch(error => {
                console.log("fail", error)
            })
        }
    }
    user();

    $scope.items =[];
    function lists () {
        $scope.url="/admin/api/userlist";
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            console.log("users", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    lists();
    $scope.image;
    $scope.imag = function (img){
        $scope.image = img;
    }

    $scope.uploadfile = function (file) {
        var form = new FormData();
        form.append("files",file[0]);
        let urlfile = 'http://localhost:8080/api/file/user';

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

        $scope.urlUpdate ='/admin/api/user/update';
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



