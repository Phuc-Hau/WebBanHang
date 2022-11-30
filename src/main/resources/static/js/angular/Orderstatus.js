var app = angular.module("app", []);

app.controller('orderstatus', function($scope,$http) {

    //list
    $scope.urllist="/accounts/api/listorderstatus";
    //liststatus
    $scope.urlgroup="/accounts/api/listordersDetailStatus/";
    $scope.orderlist =[];
    $scope.orderstatus =[];
    $scope.orderdetail =[];
    $scope.status =[];
    $scope.urlsubmit= "/api/evalute/new";
    // var name = sessionStorage.getItem("users");
    // console.log("name", name)


    $scope.list = function (){
        $http.get($scope.urllist).then(resp => {
            $scope.orderlist = resp.data;
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    $scope.list();

    $scope.urlStatus="/accounts/api/OrderStatus";
    $http.get($scope.urlStatus).then(resp => {
        $scope.status = resp.data;
        console.log("SuccessStatus", resp)
    }).catch(error => {
        console.log("fail", error)
    })

    $scope.urlOrderdetail = "/accounts/api/listordersDetail";
    $http.post($scope.urlOrderdetail).then(resp => {
        $scope.orderdetail = resp.data;
        $scope.getIdOr = function (id){
            return $scope.orderdetail.map(e => e.order.id).indexOf(id);
        }
        console.log("Success Orderdetail", resp)
    }).catch(error => {
        console.log("fail", error)
    })

    $scope.orderid = function (id){
        $http.post($scope.urlgroup+id).then(resp => {
            $scope.orderstatus = resp.data;
            console.log("Success Group", resp)
            // active

            $scope.getAmount= function (){
                let sum=0;
                for (let i = 0; i < $scope.orderstatus.length ; i++) {
                    sum += $scope.orderstatus[i].quantity;
                }
                return sum;
            }


            var u= $scope.orderstatus[0].order.status;
            var track= document.getElementById('track');

            if(u!=5){
                track.style.display="";
                for (let i = 1; i < 5; i++) {
                    let t= document.getElementById("step"+i);
                    if(i<=u){
                        t.classList.add('active');
                    }else{
                        t.classList.remove('active');
                    }
                }

            }else{
                track.style.display="none";
            }

        }).catch(error => {
            console.log("fail", error)
        })

    }
    $scope.productitem;
    $scope.productbyid = function (id){
        $scope.productitem = $scope.orderdetail.filter(e => e.product.id == id)[0];
        delete $scope.productitem ['quantity'];
        console.log("pop", $scope.productitem );
        document.getElementById('myModal1').style.display='none';
    }

    $scope.add = function (){
        document.getElementById('myModal1').style.display='block';
        setTimeout(function () {
            document.getElementById('boody').classList.add('modal-open');
        }, 500);

    }

    $scope.evalute = {};

    $scope.submit = function (productitem){

        $scope.evalute.product = productitem.product;
        $scope.evalute.orders = productitem.order;
        $scope.evalute.footQuality = star;
        $http.post($scope.urlsubmit, $scope.evalute ).then(resp => {


            console.log("Success submit", resp)
            if(resp.data.status){
                window.location='/accounts/cart';
            }else{
                showErrorToast(resp.data.message);
            }


        }).catch(error => {
            console.log("fail", error)
        })
        $scope.add();

    }

    $scope.idHuy;
    $scope.xnHuy = function (id){
        $scope.idHuy = id;
    }

    $scope.Huy = function (){
        $scope.urlHuy = "/accounts/api/OrderHuy/" +     $scope.idHuy;
        $http.post($scope.urlHuy ).then(resp => {
            console.log("Success huy", resp)
            if(resp.data.status){
                showSuccessToast(resp.data.message);
                $scope.list();
            }else{
                showErrorToast(resp.data.message);
            }
        }).catch(error => {
            console.log("fail", error)
        })

    }


    $scope.newCar = function (id){
        $scope.urlnew='/accounts/newcart';
        var newcar = {
            'id':id,
            'quantity': 1
        }
        $http.post($scope.urlnew,newcar).then(resp => {
            $scope.sr = resp.data;
            console.log("p", resp)
            if($scope.sr.status==true){
                window.location='http://localhost:8080/accounts/cart';
            }else{
                showErrorToast($scope.sr.message)
            }
        }).catch(error => {
            console.log("fail", error)
        })
    }




});
