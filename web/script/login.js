/* 
 Document   : login
 Created on : 25 may. 2020, 19:35:21
 Author     : Elesban Antonio Gallardo Hernandez
 */
var app = angular.module('loginApp', []);

app.controller('contenedor', function ($scope, $http) {
    $scope.iniciarSesion = function () {
        let url = `login?accion=iniciarSesion&textUsuario=${$scope.textUsuario}&textPassword=${$scope.textPassword}`;
        $http({
            method: "POST",
            url: url
        }).then(function (response) {
            $scope.respuesta = response.data;
            if(Object.is(response.data, "Usuario encontrado")){
                $scope.colorRespuesta = "green";
                document.location.href = "index.jsp";
            } else {
                $scope.colorRespuesta = "red";
            }
        });
    };
});