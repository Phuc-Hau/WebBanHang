
const container = document.querySelector(".container");
const formcode = document.getElementById("formcode");
const formsignin = document.getElementById("formsignin");
const pcode = document.getElementById("pcode");

var app = angular.module("app", []);
app.controller('forgetpass', function($scope,$http) {

    $scope.model;

    $scope.next = function() {
        $scope.urlemail="/account/api/email/";

        $http.get($scope.urlemail+$scope.email).then(resp => {
            $scope.model = resp.data;
            console.log("Success", resp)
            if($scope.model.status){
                container.classList.add("sign-up-mode");
                showSuccessToast("Chờ nhận code")
            }else{
                showErrorToast($scope.model.message);
            }
        }).catch(error => {
            console.log("fail", error)
        })

    }

    $scope.entercode= function (code){
        $scope.urlcode="/account/api/code/";
        $http.post($scope.urlcode+code).then(resp => {
            console.log("Success", resp)
            if(resp.data.status){
                container.classList.remove("sign-up-mode");
                setTimeout ( function () {
                    formsignin.style.display='none';
                    formcode.style.display='';
                    pcode.innerHTML="Change Password"
                }, 1000);

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


    var s = 59; // Giây
    var timeout = null; // Timeout
    function start() {
        document.getElementById('cho').style.display = '';
        document.getElementById('setcapcha').style.display = 'none';

        if (s == -1){
            clearTimeout(timeout);
            document.getElementById('cho').style.display = 'none';
            document.getElementById('setcapcha').style.display = '';
            s = 59;
            return false;
        }

        document.getElementById('time').innerText = s.toString();
        timeout = setTimeout(function(){
            s--;
            start();
        }, 1000);
    }
    start();

    $scope.setCapcha = function (){
        $scope.urlcapcha="/account/api/code/resetcode";
        $http.post($scope.urlcapcha).then(resp => {
            start();
        }).catch(error => {
            console.log("fail", error)
        })
    }

});