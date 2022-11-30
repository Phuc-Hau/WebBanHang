var app = angular.module("app", []);
var ur= window.location.href;
var id = ur.slice(ur.indexOf('sanpham/')+8)
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

     }

     $scope.newCar = function (id){
         $scope.urlnew='/accounts/newcart';
         var newcar = {
             'id':id,
             'quantity':document.getElementById("quantity").value
         }
         $http.post($scope.urlnew,newcar).then(resp => {
             $scope.groupproduct = resp.data;
             console.log("p", resp)
             if($scope.groupproduct.status==true){
                 showSuccessToast($scope.groupproduct.message)
             }else{
                showErrorToast($scope.groupproduct.message)
             }
         }).catch(error => {
             console.log("fail", error)

         })
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

//     $scope.fg=function myFunction() {
//     if($scope.star >0){
//       document.getElementById("saoo").setAttribute("class", "democlass");
//       }
//     }
//
//     $scope.fg()



})