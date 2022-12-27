var app = angular.module("app", []);

app.controller('orderstatus', function($scope,$http) {

    //list

    //liststatus

    $scope.orderlist =[];
    $scope.orderstatus =[];
    $scope.orderdetail =[];
    $scope.status =[];
    $scope.urlsubmit= "/api/evalute/new";
    // var name = sessionStorage.getItem("users");
    // console.log("name", name)


    $scope.list = function (){
        $scope.urllist="/accounts/api/listorderstatus";
        $http.get($scope.urllist).then(resp => {
            $scope.orderlist = resp.data;
            $scope.choxacnhan = $scope.orderlist.filter(s=> s.status ===1 ).length;
            $scope.cholayhang= $scope.orderlist.filter(s=> s.status ===2 ).length;
            $scope.danggiao= $scope.orderlist.filter(s=> s.status ===3 ).length;
            $scope.dagiao= $scope.orderlist.filter(s=> s.status ===4 ).length;
            $scope.dahuy= $scope.orderlist.filter(s=> s.status ===5 ).length;
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }
    $scope.list();

    //load tat ca cac trang thai
    $scope.urlStatus="/accounts/api/OrderStatus";
    $http.get($scope.urlStatus).then(resp => {
        $scope.status = resp.data;
        console.log("SuccessStatus", resp)
    }).catch(error => {
        console.log("fail", error)
    })

    //load tat ca chi tiet hoa don cua user
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


    //list chi tiet don hang
    $scope.urlgroup="/accounts/api/listordersDetailStatus/";
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

            // set trang thai thanh mau cam trong chi tiet
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
    //tam an modal 1
    $scope.productitem;
    $scope.productbyid = function (id){
        $scope.productitem = $scope.orderdetail.filter(e => e.product.id == id)[0];
        delete $scope.productitem ['quantity'];
        console.log("pop", $scope.productitem );
        document.getElementById('myModal1').style.display='none';
    }

    // mo modal 2 an modal 1
    $scope.add = function (){
        document.getElementById('myModal1').style.display='block';
        setTimeout(function () {
            document.getElementById('boody').classList.add('modal-open');
        }, 500);

    }

    $scope.evalute = {};

    // danh gia
    $scope.submit = function (productitem){

        $scope.evalute.product_id = productitem.product.id;
        $scope.evalute.orders_id = productitem.order.id;
        $scope.evalute.footQuality = star;
        console.log("ds submit", $scope.evalute)
        $http.post($scope.urlsubmit, $scope.evalute ).then(resp => {

            console.log("Success submit", resp)
            if(resp.data.status){
                showSuccessToast(resp.data.message);
            }else{
                showErrorToast(resp.data.message);
            }
            $scope.evalute ={};

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

    //dat lai
    $scope.newCar = function (item){
        $scope.cardpay = [{
            'product' : item,
            'quantity':1
        }]
        // trang thai sp
        if(item.status == 1) {
            $http.post(`/accounts/cart/newpay`, $scope.cardpay).then(resp => {
                setTimeout(function () {
                    window.location = '/accounts/xacnhandonhang';
                }, 500);
            }).catch(error => {
                console.log("fail", error)
            });
        }else{
            showErrorToast("Sản phẩm không tồn tại!");
        }
    }




});
