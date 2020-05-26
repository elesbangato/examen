<%-- 
    Document   : login
    Created on : 25 may. 2020, 19:24:03
    Author     : Elesban Antonio Gallardo Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Examen</title>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.9/angular.min.js"></script>
        
    </head>
    <body ng-app="loginApp">
        <div ng-controller="contenedor">
            <form>
                <div style="width: 300px; margin: auto; margin-top: 50px; border: 1px solid; border-radius: 10px; padding: 10px; box-shadow: 5px 10px #888888;">
                    <h3 style="text-align: center;">Bienvenido</h3><br>
                    <div class="form-group">
                        <label for="textUsuario">Usuario: </label>
                        <input type="text" class="form-control" id="textUsuario" placeholder="Usuario" ng-model="textUsuario">
                    </div>
                    <div class="form-group">
                        <label for="textPassword">Contraseña: </label>
                        <input type="password" class="form-control" id="textPassword" placeholder="Contraseña" ng-model="textPassword">
                    </div>
                    <h5 style="color: {{colorRespuesta}};">{{respuesta}}</h5>
                    <button ng-click="iniciarSesion()" type="button" class="btn btn-primary">Iniciar Sesión</button>
                </div>
            </form>
        </div>
    </body>
    
    <script src="script/login.js"></script>
</html>
