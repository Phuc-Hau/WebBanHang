var app = angular.module("app", []);

app.controller('ctradminhome', function($scope,$http) {

    $scope.url="/admin/api/home";
    $scope.items =[];

        $http.get($scope.url).then(resp => {
            $scope.items = resp.data;
            console.log("Success", resp)
        }).catch(error => {
            console.log("fail", error)
        })

});