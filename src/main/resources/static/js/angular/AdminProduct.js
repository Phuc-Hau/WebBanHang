
var app = angular.module("app", []);

var ur= window.location.href;
var id = ur.slice(ur.indexOf('edit/')+5)

app.controller('ctradminproduct', function($scope,$http) {


    $scope.items =[];
    $scope.prop="-date";

    function list () {
        $scope.url="/admin/api/productlist";
        $http.get($scope.url).then(resp => {

            $scope.items = resp.data;
            $scope.itemstrue = $scope.items.filter(s=>s.status==true);
            $scope.itemsfalse= $scope.items.filter(s=>s.status==false);

        }).catch(error => {
            console.log("fail", error)
        })
    }
    list();

    $scope.groups =[];

    function lists () {
        $scope.url="/admin/api/groupproductlist";
        $http.get($scope.url).then(resp => {
            $scope.groups = resp.data;
        }).catch(error => {
            console.log("fail", error)
        })
    }
    lists();

    $scope.sortBynumber=0;
    $scope.sortBy = function(prop){
        $scope.sortBynumber++;
        if($scope.sortBynumber%2==0){
            if(prop.indexOf('-') != -1){
                $scope.prop = prop;
            }else{
                $scope.prop = "-"+prop;
            }
        }else{
            if(prop.indexOf('-') != -1){
                $scope.prop = prop.slice(1);
            }else{
                $scope.prop = prop;
            }
        }
    }

    $scope.ResetFilter = function (){
        $scope.Status ="";
        $scope.searchname ="";
        $scope.groupof="";
        $scope.sortBynumber=1;
        $scope.sortBy("date");
        list();
        lists();
    }


    $scope.item ={};
    $scope.images ={};

    try{
        document.getElementById('newProduct').style.display='';
        document.getElementById('updateProduct').style.display='none';
    } catch (e) {
        
    }

    $scope.list=function() {
        if(id != '://localhost:8080/admin/product/edit') {
            $scope.url = "/admin/api/product/edit/" + id;
            $http.get($scope.url).then(resp => {
                $scope.item = resp.data;
                console.log("product", resp);
                for (let i = $scope.item.imgs.length; i < 6; i++) {
                    document.getElementById('imageResult' + i).src = '/assets/images/plus.png';
                }
            }).catch(error => {
                console.log("fail", error)
            })
        }
    }

    if(id != '://localhost:8080/admin/product/edit'){
        try{
            document.getElementById('newProduct').style.display='none';
            document.getElementById('updateProduct').style.display='';
        } catch (e) {
            
        }
        $scope.list();
    }else{
        $scope.item.date=(new Date()).toLocaleDateString('en-GB');
        $scope.item.status = true;
    }

    $scope.reset = function () {
        if(id != '://localhost:8080/admin/product/edit') {
            $scope.item.imgs=undefined;
            $scope.list();
        }else{
            $scope.item = {};
            $scope.item.date=(new Date()).toLocaleDateString('en-GB');
            $scope.item.status = true;
        }
        forms = new FormData();

    }
    $scope.update = function (product) {

        $scope.urlupdate= '/admin/api/product/Update';

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
            showErrorToast("L???i H??? th???ng");
        })
        uploadfile($scope.item.id);
        setTimeout ( function () {
            $scope.reset();
        }, 500);

    }

    $scope.new = function (product){
        console.log("r",forms)
        if(forms.get('files0') == null && forms.get('files1') == null &&  forms.get('files2') == null
            &&  forms.get('files3') == null &&  forms.get('files4') == null &&  forms.get('files5') == null){
            showErrorToast("Ch??a ch???n ???nh");
        }else {
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
                showErrorToast("L???i H??? th???ng");
            });
        }
    }

    function uploadfile(id) {
        let form = new FormData();
        for (let i = 0; i < 6; i++) {
            form.append("files", forms.get("files" + i));
        }
        console.log("file", form.getAll("files"));
        let urlfile = 'http://localhost:8080/api/file/AnhWebBanHang';

        $http.post(urlfile, form, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.image = resp.data;
            $scope.images = angular.copy($scope.image);

            console.log("imgs", $scope.images)

            let yy = 0;
            for (let i = 0; i < 7; i++) {
                if (forms.get("files" + i) != null) {
                    try {
                        $scope.item.imgs[i].image = $scope.image[yy];
                    } catch (err) {
                        try {
                            $scope.item.imgs.push({'image': $scope.image[yy]});
                        } catch (err) {
                            $scope.item.imgs = [{'image': $scope.image[yy]}];
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

    $scope.updateImg = function (id) {

        $scope.urlupdateImg= '/admin/api/img/Update/'+id;

        console.log("img", $scope.item.imgs);

        $http.post($scope.urlupdateImg,$scope.item.imgs).then(resp => {
            if(resp.data.status){
                forms = new FormData();
            }else{
                showErrorToast(resp.data.message);
            }
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
            showErrorToast("L???i H??? th???ng");
        })

    }

    $scope.Removed = function () {
        removed();
        $scope.item.imgs[ids]=undefined;
    }

});