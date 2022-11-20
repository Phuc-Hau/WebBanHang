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
    // var name = sessionStorage.getItem("users");
    // console.log("name", name)
    $http.get($scope.urllist).then(resp => {
        $scope.orderlist = resp.data;
        console.log("Success", resp)
    }).catch(error => {
        console.log("fail", error)
    })

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



});