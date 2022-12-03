var app = angular.module("app", []);

app.controller('ctrladminorderstatus', function($scope,$http) {

    //list
    $scope.urllist="/admin/api/listorderstatus";
    //liststatus
    $scope.urlgroup="/admin/api/listordersDetailStatus/";
    $scope.orderlist =[];
    $scope.orderstatus =[];
    $scope.orderdetail =[];
    $scope.status =[];
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

    $scope.urlStatus="/admin/api/OrderStatus";
    $http.get($scope.urlStatus).then(resp => {
        $scope.status = resp.data;
        console.log("SuccessStatus", resp)
    }).catch(error => {
        console.log("fail", error)
    })

    $scope.urlOrderdetail = "/admin/api/listordersDetail";
    $http.get($scope.urlOrderdetail).then(resp => {
        $scope.orderdetail = resp.data;
        console.log("Success Orderdetail", resp)
    }).catch(error => {
        console.log("fail", error)
    })

    
    $scope.statusUpdate = function(id,sta){
	
	$scope.statusUpdateURL = "/admin/api/orderstatusChange/"+id+"/"+sta;
	 $http.post($scope.statusUpdateURL).then(resp => {
            if(resp.data.status){
                showSuccessToast(resp.data.message);
                $scope.list();
            }else{
                showErrorToast(resp.data.message);
            }
            console.log("Update status success", resp)
        }).catch(error => {
            console.log("Update fail", error)
        })
}





});
