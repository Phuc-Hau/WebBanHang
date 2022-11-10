
const container = document.querySelector(".container");
const formcode = document.getElementById("formcode");
const formpass = document.getElementById("formpassword");
const pcode = document.getElementById("pcode");

var app = angular.module("app", []);
app.controller('forgetpass', function($scope,$http) {

    $scope.model;

    $scope.next = function() {
        $scope.urlemail="/account/api/email/";
        if($scope.email.length > 3){
            $http.get($scope.urlemail+$scope.email).then(resp => {
                $scope.model = resp.data;
                console.log("Success", resp)
                if($scope.model.status){
                    container.classList.add("sign-up-mode");
                }else{
                    showErrorToast($scope.model.message);
                }
            }).catch(error => {
                console.log("fail", error)
            })

        }
    }

    $scope.entercode= function (code){
        $scope.urlcode="/account/api/code/";
        $http.post($scope.urlcode+code).then(resp => {
            console.log("Success", resp)
            if(resp.data.status){
                formcode.style.display='none';
                formpass.style.display='';
                pcode.innerHTML="Change Password"
            }else{
                showErrorToast(resp.data.message);
            }
        }).catch(error => {
            console.log("fail", error)
        })

    }

    $scope.ChangePassword = function (password){
        $scope.urlpass="/account/api/password/";
        $http.post($scope.urlpass+password).then(resp => {
            console.log("Success", resp)
            if(resp.data.status){
                window.location='http://localhost:8080/account/signin';
            }else{
                showErrorToast(resp.data.message);
            }
        }).catch(error => {
            console.log("fail", error)
        })
    }
});