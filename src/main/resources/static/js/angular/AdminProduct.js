
var app = angular.module("app", []);

var ur= window.location.href;
var id = ur.slice(ur.indexOf('edit/')+5)

app.controller('ctradminproduct', function($scope,$http) {

    $scope.items ={};
    $scope.images ={};

    document.getElementById('newProduct').style.display='';
    document.getElementById('updateProduct').style.display='none';

    function list () {
        $scope.url="/admin/api/product/edit/"+id;
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            console.log("es", resp);
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
        $scope.items.status = true;
    }

    $scope.reset = function () {
        if(id != '://localhost:8080/admin/product/edit') {
            list();
        }else{
            $scope.items = {};
            $scope.items.date=(new Date()).toLocaleDateString('en-GB');
            $scope.items.status = true;
        }
    }
    $scope.update = function (product) {

        $scope.urlupdate= '/admin/api/product/Update';
        uploadfile($scope.items.id);
        console.log("pro", product);

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
        console.log("p",product);
        $http.post($scope.utlnew,product).then(resp => {
            if(resp.data.status){
                showSuccessToast(resp.data.message);
                uploadfile(resp.data.id);
            }else{
                showErrorToast(resp.data.message);
            }
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
            showErrorToast("Lỗi Hệ thống");
        });

    }

    $scope.updateImg = function (id) {

        $scope.urlupdateImg= '/admin/api/img/Update/'+id;

        console.log("img", $scope.items.imgs);

        $http.post($scope.urlupdateImg,$scope.items.imgs).then(resp => {
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

    function uploadfile(id) {
        let form = new FormData();
        for (let i = 0; i < 6; i++) {
            form.append("files", forms.get("files" + i));
        }
        console.log("file", form.getAll("files"));
        let urlfile = 'http://localhost:8080/api/file/AnhWebBanHangddddddd';

        $http.post(urlfile, form, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.image = resp.data;
            $scope.images = angular.copy($scope.image);

            console.log("imgs", $scope.images)

            let yy = 0;
            for (let i = 0; i < 6; i++) {
                if (forms.get("files" + i) != null) {
                    try {
                        $scope.items.imgs[i].image = $scope.image[yy];
                    } catch (err) {
                        try {
                            $scope.items.imgs.push({'image': $scope.image[yy]});
                        } catch (err) {
                            $scope.items.imgs = [{'image': $scope.image[yy]}];
                        }
                    }
                    yy++;
                }
            }
            $scope.updateImg(id);
        }).catch(error => {
            console.log("fail", error)
        })

    }


});