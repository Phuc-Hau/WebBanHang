var app = angular.module("app", []);
app.controller('changepassword', function($scope,$http) {
    $scope.url="/account/api/changepassword/";
    $scope.change;
    $scope.ChangePassWord = function (){
        if($scope.change.newpassword == $scope.change.confirmpassword){
            console.log("Success", $scope.change)
            $http.post($scope.url,$scope.change).then(resp => {
                console.log("Success", resp)
                if(resp.data.status){
                    showSuccessToast(resp.data.message)
                }else{
                    showErrorToast(resp.data.message);
                }
            }).catch(error => {
                console.log("fail", error)
            })

        }else {
            showErrorToast("PassWord mới và PassWord Xác nhận không dóng nhau!")
        }
    }
});