var jsAtt = document.getElementById("login").value;
if(jsAtt){
    showErrorToast("Sai password hoac username");
}


const formlogin = document.getElementById("formlogin");
const formcode = document.getElementById("formcode");


var app = angular.module("app", []);

app.controller('signup', function($scope,$http) {

    $scope.item;
    $scope.urlnew='/account/api/signup/new';
    $scope.newUser = function (user){
        $http.post($scope.urlnew,user).then(resp => {
            $scope.item = resp.data;
            if(!resp.data.status){
                showErrorToast(resp.data.message);
            }else{
                formlogin.style.display="none";
                container.classList.remove("sign-up-mode");
                formcode.style.display="";

            }
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })
    }

    $scope.urlcode='/account/api/signup/confirm/';
    $scope.entercode = function (code){
        $http.post($scope.urlcode+code).then(resp => {
            if(!resp.data.status){
                showErrorToast(resp.data.message);
            }else{
                showSuccessToast(resp.data.message)
                sleep(2);
                window.location='http://localhost:8080/account/signin';
            }
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
            showErrorToast("lỗi hệ thống!");
        })
    }

});