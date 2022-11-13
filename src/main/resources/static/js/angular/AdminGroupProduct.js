
var app = angular.module("app", []);

var ur= window.location.href;
var id = ur.slice(ur.indexOf('edit/')+5)

app.controller('ctradmingroupproduct', function($scope,$http) {

    $scope.items ={};

    document.getElementById('newGroupProduct').style.display='';
    document.getElementById('updateGroupProduct').style.display='none';

    function list () {
        $scope.url="/admin/api/groupproduct/edit/"+id;
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
        }).catch(error => {
            console.log("fail", error)
        })
    }

    if(id != '://localhost:8080/admin/groupproduct/edit'){
        document.getElementById('newGroupProduct').style.display='none';
        document.getElementById('updateGroupProduct').style.display='';
        list();
    }else{
        $scope.items.date=(new Date()).toLocaleDateString('en-GB');
    }

    $scope.reset = function () {
        if(id != '://localhost:8080/admin/groupproduct/edit') {
            list();
        }else{
            $scope.items = {};
        }
    }
    $scope.update = function (groupProduct) {
        $scope.urlupdate= '/admin/api/groupproduct/Update';
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
});