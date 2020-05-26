<%-- 
    Document   : usuarios
    Created on : 25 may. 2020, 21:55:35
    Author     : Elesban Antonio Gallardo Hernandez
--%>

<div style="margin-left: 50px; margin-top: 50px;" ng-app="usuarioApp">
    <div class="row">
        <h1>Usuarios</h1>
    </div>
    <br>
    <div class="row">
        <button ng-click="nuevo()" type="button" class="btn btn-info">Nuevo Usuario</button>
    </div>
    <br>
    <div class="row">
        <table style="width: 80%;" class="table" ng-controller="tablaUsuarios">
            <thead>
                <th scope="col">idUsuario</th>
                <th scope="col">Nombre</th>
                <th scope="col">Acciones</th>
            </thead>
            <tbody ng-repeat="i in usuarios">
                <tr>
                    <td>{{i.idUsuario}}</td>
                    <td>{{i.nombre}}</td>
                    <td>
                        <button ng-click="editar(i.idUsuario)" type="button" class="btn btn-warning">Editar</button>
                        <button ng-click="eliminar(i.idUsuario)" type="button" class="btn btn-danger">Eliminar</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<script src="script/usuarios.js"></script>

