var jsAtt = document.getElementById("login").value;

const formlogin = document.getElementById("formlogin");
const formcode = document.getElementById("formcode");


var app = angular.module("app", []);

app.controller('signup', function($scope,$http) {

    $http.get(`/account/api/login/name`).then(resp => {
        if(resp.data.status == 1){
            showErrorToast(resp.data.message);
        }else if(resp.data.status == 2){
            if(jsAtt){
                showErrorToast("Sai password hoặc username");
            }
        }
    }).catch(error => {
        console.log("fail", error)
    })

    $scope.login = function (username){
        $http.post(`/account/api/login/`+username).then(resp => {

        }).catch(error => {
            console.log("fail", error)
        })
    }


    $scope.item;
    $scope.user ={
        'email': "",
        'fullname': "",
        'password':"",
        'username':""
    };
    $scope.urlnew='/account/api/signup/new';
    $scope.newUser = function (user) {
        if(user.username.length < 3 ){
            showErrorToast("Nhập đầy đủ thông tin");
        }else if(user.fullname.length<3 ){
            showErrorToast("Nhập đầy đủ thông tin");
        }else if(user.email.length < 3  ){
            showErrorToast("Vui lòng nhập đúng email");
        }else if(user.password.length <= 8 ){
            showErrorToast("Mật khẩu từ 8 ký tự");
        }else{
            $http.post($scope.urlnew, user).then(resp => {
                $scope.item = resp.data;
                if (!resp.data.status) {
                    showErrorToast(resp.data.message);
                } else {
                    container.classList.remove("sign-up-mode");
                    setTimeout(function () {
                        showSuccessToast("Chờ nhận Code")
                        formlogin.style.display = "none";
                        formcode.style.display = "";
                    }, 1000);

                }
            }).catch(error => {
                console.log("fail", error)
            })
        }
    }

    $scope.urlcode='/account/api/signup/confirm/';
    $scope.entercode = function (code){
        $http.post($scope.urlcode+code).then(resp => {
            if(!resp.data.status){
                showErrorToast(resp.data.message);
            }else{
                showSuccessToast(resp.data.message)
                setTimeout ( function () {
                    window.location='/account/signin';
                }, 1000);

            }
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
            showErrorToast("lỗi hệ thống!");
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
        $scope.urlcapcha="/account/api/signup/resetcode";
        $http.post($scope.urlcapcha).then(resp => {
            start();
        }).catch(error => {
            console.log("fail", error)
        })
    }



});