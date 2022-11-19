
var app = angular.module("app", []);

var ur= window.location.href;
var id = ur.slice(ur.indexOf('edit/')+5)

app.controller('ctradminproduct', function($scope,$http) {

    $scope.items ={};

    document.getElementById('newProduct').style.display='';
    document.getElementById('updateProduct').style.display='none';

    function list () {
        $scope.url="/admin/api/product/edit/"+id;
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
        }).catch(error => {
            console.log("fail", error)
        })
    }

    if(id != '://localhost:8080/admin/product/edit'){
        document.getElementById('newProduct').style.display='none';
        document.getElementById('updateProduct').style.display='';
        list();
    }else{
        $scope.items.date=(new Date()).toLocaleDateString('en-GB');
    }

    $scope.reset = function () {
        if(id != '://localhost:8080/admin/product/edit') {
            list();
        }else{
            $scope.items = {};
        }
    }
    $scope.update = function (product) {
        $scope.urlupdate= '/admin/api/product/Update';
        $http.post($scope.urlupdate,product).then(resp => {
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

    $scope.new = function (product){
        $scope.utlnew ='/admin/api/product/new';
        product.date = new Date();
        $http.post($scope.utlnew,product).then(resp => {
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