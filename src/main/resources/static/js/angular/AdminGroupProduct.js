
var app = angular.module("app", []);


app.controller('ctradmingroupproduct', function($scope,$http) {

    $scope.items =[];
    function lists () {
        $scope.url="/admin/api/groupproductlist";
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            console.log("s", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    lists();

    $scope.item ={};
    $scope.image;

    try {
        document.getElementById('newGroupProduct').style.display = '';
        document.getElementById('updateGroupProduct').style.display = 'none';
    }catch (e) {

    }
    function list () {
        if(id != "://localhost:8080/admin/productlist") {
            $scope.url = "/admin/api/groupproduct/edit/" + id;
            $http.get($scope.url).then(resp => {
                console.log("item", resp)
                $scope.item = resp.data;
            }).catch(error => {
                console.log("fail", error)
            })
        }
    }

    var ur= window.location.href;
    var id = ur.slice(ur.indexOf('edit/')+5)

    if(id != '://localhost:8080/admin/groupproduct/edit'){
        try{
            document.getElementById('newGroupProduct').style.display = 'none';
            document.getElementById('updateGroupProduct').style.display = '';
        } catch (e) {

        }
        list();
    }else{
        $scope.item.date=(new Date()).toLocaleDateString('en-GB');
    }

    $scope.reset = function () {
        if(id != '://localhost:8080/admin/groupproduct/edit') {
            list();
        }else{
            $scope.item = {};
            $scope.item.date=(new Date()).toLocaleDateString('en-GB');
            document.getElementById("imageResult").src='/file/user/avata.jpg';
        }

    }
    $scope.update = function (groupProduct) {
        $scope.urlupdate= '/admin/api/groupproduct/Update';
        console.log("groupProduct", groupProduct)
        $http.post($scope.urlupdate,groupProduct).then(resp => {
            if(resp.data.status){
                showSuccessToast(resp.data.message);
            }else{
                showErrorToast(resp.data.message);
            }
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
            showErrorToast("Lỗi Hệ thống");
        })

    }

    $scope.new = function (groupProduct){
        $scope.utlnew ='/admin/api/groupproduct/New';
        groupProduct.date = new Date();
        $http.post($scope.utlnew,groupProduct).then(resp => {
            if(resp.data.status){
                showSuccessToast(resp.data.message);
            }else{
                showErrorToast(resp.data.message);
            }
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
            showErrorToast("Lỗi Hệ thống");
        })
    }

    $scope.uploadfile = function (files) {

        let form = new FormData();

        for(var i = 0; i< files.length; i++){
            form.append("files",files[i]);
        }

        let urlfile = 'http://localhost:8080/api/file/Groupproduct';

        $http.post(urlfile,form,{
            transformRequest: angular.identity,
            headers:{'Content-Type': undefined}
        }).then(resp => {
            $scope.image = resp.data[0];
            $scope.item.images =angular.copy($scope.image);
        }).catch(error => {
            console.log("fail", error)
        })
    }

});