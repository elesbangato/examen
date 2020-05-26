/* 
 Document   : index
 Created on : 25 may. 2020, 21:39:07
 Author     : Elesban Antonio Gallardo Hernandez
 */

var app = angular.module('indexApp', []);

app.controller('menu', ['$scope', '$compile', '$http', function ($scope, $compile, $http) {
        $scope.cargarView = function () {
            var compiledeHTML = $compile("<div usuario></div>")($scope);
            $("#contenedor").html(compiledeHTML);
        };
        
        $scope.cerrarSesion = function () {
            let url = `login?accion=cerrarSesion`;
            $http({
                method: "POST",
                url: url
            }).then(function (response) {
                document.location.href = "index.jsp";
            });
        };
        
    }]).directive('usuario', function () {
    return {
        templateUrl: 'usuarios.jsp'
    };
});

app.controller('tablaUsuarios', function ($scope, $http) {
    let url = `usuario?accion=getAll`;
    $http({
        method: "POST",
        url: url
    }).then(function (response) {
        //$scope.respuesta = response.data;
        console.log(response.data);
        $scope.usuarios = response.data;
    });
    
    $scope.editar = function (idUsuario) {
        console.log(idUsuario);
    };
    
    $scope.eliminar = function (idUsuario) {
        let url = `login?textUsuario=${$scope.textUsuario}&textPassword=${$scope.textPassword}`;
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