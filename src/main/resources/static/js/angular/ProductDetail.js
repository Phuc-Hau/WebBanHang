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

     $scope.evalutes ;
     function listevalute () {
             $scope.url="/api/evalute/getEvaluteProduct/"+id;
             $http.get($scope.url).then(resp => {
                 $scope.evalutes = resp.data;
                 console.log("evalutes", resp)
                 stars($scope.evalutes.evalute);
             }).catch(error => {
                 console.log("fail", error)
             })
         }
      listevalute();

    $scope.star;

     function stars(evalute) {
        var y=0;
        for(let i = 0; i< evalute.length; i++){
            y += evalute[i].footQuality
        }

        $scope.star= y/evalute.length;
        starr = $scope.star;
         document.getElementById('filled-stars').style.width=starr/5*100+'%'
     }

     /* Sao hiển thị*/
     $scope.startype= function (x){
        $scope.loaisao=x;
     }

    $scope.newCar = function (item,index){
        $scope.cardpay = [{
            'product' : item,
            'quantity':document.getElementById("quantity").value
        }]
        $http.post(`/accounts/cart/newpay`,$scope.cardpay).then(resp => {
            if(resp.data.indexOf('<!DOCTYPE html>')==0){
                showErrorToast("Chưa đăng nhập")
                setTimeout ( function () {
                    window.location='/account/signin';
                }, 500);
            }else{
                window.location='/accounts/xacnhandonhang';
            }
        }).catch(error => {
            console.log("fail", error)
        });
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

    $scope.cart={
        items:[],
        add(items,x){
            this.loadLocal();
            var item = this.items.find(item=>item.id == items.id)
            if(item){
                if(x==0) {
                    if ( (item.qty + parseInt(document.getElementById('quantity').value)) > item.amount) {
                        item.qty = item.amount;
                    } else {
                        item.qty += parseInt(document.getElementById('quantity').value);
                    }
                }
                if(x==1){
                    item.qty ++;
                }
                showSuccessToast("Cập nhật số lượng sản phẩm: "+item.name+" Thành công");
                this.saveToLocal();
            }else{
                if(x==0) {
                    items.qty = parseInt(document.getElementById('quantity').value);
                }
                if(x==1){
                    items.qty =1;
                }
                this.items.push(items);
                this.saveToLocal();
                showSuccessToast("Thêm sản phẩm: "+items.name+" Thành công");
            }
            loatAmout();
        },
        saveToLocal(){
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);

        },
        loadLocal(){
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];

        },
        get count(){
            return this.items
                .map(item => item.quantity)
                .reduce((total,quantity)=> total+=quantity,0);
        },
    }

})

