var app = angular.module('shopping', []);
app.controller('ctr-shopping', function($scope,$http) {

    $scope.cart={
        items:[],
        add(id){
            var item = this.items.find(item=>item.id==id);
            if(item != null){
                if(item.qty<item.amount){
                    item.qty++;
                    showSuccessToast("Thêm sản phẩm: "+item.name+" Thành công");
                }else{
                    showErrorToast("Hết số lượng sản phẩm: "+item.name+" Để thêm");
                }
                this.saveToLocal();
                loatAmout();
            }else{
                $http.get(`/api/product/${id}`).then(resp => {
                        resp.data.qty = 1;
                        this.items.push(resp.data);
                        this.saveToLocal();
                        loatAmout();
                        showSuccessToast("Thêm sản phẩm: "+resp.data.name+" Thành công")

                }).catch(error => {
                    showErrorToast("Thêm sản phẩm Thất bại")
                })
            }
        },
        saveToLocal(){
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
        },
        loadLocal(){
            this.items = [];
            var json = localStorage.getItem("cart");
            this.items = json != null ? JSON.parse(json) : [];
        },

        get amount(){
            return this.items.length
        },

        get count(){
            return this.items
                .map(item => item.qty)
                .reduce((total,qty)=> total+=parseInt(qty),0);
        },

        get pricesum(){
            let amount = 0;
            for (let index = 0; index < this.items.length; index++) {
                amount += this.items[index].qty * (this.items[index].price*(1-this.items[index].sale));
            }
            return amount;
        },

        delete(id){
            var index = this.items.findIndex(element => element.id == id);
            this.items.splice(index,1);
            this.saveToLocal();
            loatAmout();
        },
        cong(id){
            var index = this.items.findIndex(element => element.id == id);
            if(this.items[index].qty < this.items[index].amount){
                this.items[index].qty++;
                this.saveToLocal();
            }
            if(this.items[index].qty == this.items[index].amount){
                showErrorToast("Khổng thể thêm chỉ còn: "+this.items[index].amount+" sản phẩm!");
            }
            loatAmout();
        },
        tru(id){
            var index = this.items.findIndex(element => element.id == id);
            if(this.items[index].qty > 1){
                this.items[index].qty--;
                this.saveToLocal();
            }
            loatAmout();
        },
        clear(){
            this.items = [];
            $scope.cart.saveToLocal();
            loatAmout();
        }

    }

    $scope.order={
        get odd(){
            return $scope.cart.items.map(item =>{
                return{
                    id:item.id,
                    quantity:item.qty,
                    product:item
                }
            })
        },
        dat(){
            var oder  = angular.copy(this)
            if(oder.odd.length!=0) {
                $http.post(`/accounts/cart/newpay`, oder.odd).then(resp => {
                    if (resp.data.indexOf('<!DOCTYPE html>') == 0) {
                        showErrorToast("Chưa đăng nhập")
                        setTimeout(function () {
                            window.location = '/account/signin';
                        }, 500);
                    } else {
                        window.location = '/accounts/xacnhandonhang';
                    }
                }).catch(error => {
                    console.log('co loi')
                });
            }else{
                showErrorToast("Chưa có sản phẩm để mua");
            }
        }

    }

    $scope.cart.loadLocal();
});