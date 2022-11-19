var app = angular.module("app", []);

app.controller('orderstatus', function($scope,$http) {

    //list
    $scope.urllist="/accounts/api/listorderstatus";
    //liststatus
    $scope.urlgroup="/accounts/api/listordersDetailltatus/";
    $scope.orderlist =[];
    $scope.orderstatus =[];
    $scope.status =[];



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



    $scope.orderid = function (id){
        $http.get($scope.urlgroup+id).then(resp => {
            $scope.orderstatus = resp.data;
            console.log("Success Group", resp)
            // active

            var u= $scope.orderstatus[0].order.status;
            if(u!=5){
                document.getElementById("step"+u).classList.add('active')
            }

        }).catch(error => {
            console.log("fail", error)
        })



    }



});