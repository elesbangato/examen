<%
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("esValida") == null){
        response.sendRedirect("login.jsp");
    }
%>
<!doctype html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.9/angular.min.js"></script>
    </head>
    <body ng-app="indexApp">
        <div ng-controller="menu">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">Sistema Examen</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" ng-click="cargarView()">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" ng-click="cerrarSesion()">Cerrar Sesión</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <% out.print(sesion.getAttribute("nombre")); %>
                    </form>
                </div>
            </nav>
        </div>
        <div id="contenedor">
            <h1 style="text-align: center; margin-top: 50px;">Bienvenido <% out.print(sesion.getAttribute("nombre")); %></h1>
        </div>
    </body>
    <script src="script/index.js"></script>
</html>