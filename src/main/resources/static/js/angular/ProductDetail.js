var app = angular.module("app", []);
var ur= window.location.href;
var id = ur.slice(ur.indexOf('sanpham/')+8)
var starr;
app.controller('ctrlproductdetail', function($scope,$http) {

    $scope.items =[];

    function list () {
        $scope.url="/api/product/"+id;
        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            console.log("s", resp)
            groupproduct($scope.items.groupProduct.id);
        }).catch(error => {
            console.log("fail", error)
        })
    }
    list();

     $scope.groupproduct =[];
     function groupproduct (id) {
            $scope.url="/api/product/groupproduct/"+id;
            $http.get($scope.url).then(resp => {
                $scope.groupproduct = resp.data;
                console.log("p", resp)
            }).catch(error => {
                console.log("fail", error)
            })
     }

     $scope.evalute ;
     function listevalute () {
             $scope.url="/api/product/listevalute/"+id;
             $http.get($scope.url).then(resp => {
                 $scope.evalute = resp.data;

                 for (let i = 0; i < $scope.evalute.length; i++) {
                     $http.post('/avata/user/'+$scope.evalute[i].orders.order.cutomer.id).then(resp => {
                         $scope.evalute[i].avata = resp.data.img;
                     }).catch(error => {
                         console.log("fail", error)
                     })
                 }

                 console.log("ss", resp);
                 stars($scope.evalute);

             }).catch(error => {
                 console.log("fail", error)
             })
         }
      listevalute();

    $scope.star;
    $scope.ssao=7;

     function stars(evalute) {
        var y=0;
        for(let i = 0; i< evalute.length; i++){
            y += evalute[i].footQuality
        }

        $scope.star= y/evalute.length;
        starr = $scope.star;
     }


     $scope.newCar = function (item,index){
         var newcar = {
             'id':item.id,
             'quantity':document.getElementById("quantity").value
         }
         if(index==1){
             $http.post('/accounts/newcart',newcar).then(resp => {
                 $scope.groupproduct = resp.data;
                 console.log("p", resp)
                 if($scope.groupproduct.status==true){
                     showSuccessToast($scope.groupproduct.message)
                 }else{
                     if(resp.data.indexOf('<!DOCTYPE html>')==0){
                         showErrorToast("Chưa đăng nhập")
                         setTimeout ( function () {
                             window.location='/account/signin';
                         }, 500);
                     }else showErrorToast($scope.groupproduct.message)
                 }
             }).catch(error => {
                 console.log("fail", error)
             })
         }
         if(index==0){
             $scope.cardpay = [{
                 'product' : item,
                 'quantity':document.getElementById("quantity").value
             }]

             $http.post(`/accounts/cart/newpay`,$scope.cardpay).then(resp => {
                 window.location='/accounts/xacnhandonhang';
             }).catch(error => {
                 console.log("fail", error)
             });
         }
     }


     $scope.cr = function addElement() {
       // create a new div element
       const newDiv = document.createElement("div");

       // and give it some content
       const newContent = document.createTextNode("Hi there and greetings!");

       // add the text node to the newly created div
       newDiv.appendChild(newContent);

       // add the newly created element and its content into the DOM
       const currentDiv = document.getElementById("div1");
       document.body.insertBefore(newDiv, currentDiv);
     }



})