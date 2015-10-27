<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Social Movies</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Carregar css -->

        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">

        <!-- Carregar scritps -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="javascript/javascriptOutras.js"></script>

    </head>
    <body  id="fundo" class="textoPreto white-background">
        <%@include file="barraUsuario.jsp"%>
        <div class="margin-top-body">
            <div class="container nav-justified">
                <a href="logado.jsp"><h1 class="text-center textoPreto">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li class="active"><a data-toggle="tab" href="#perfil">Perfil</a></li>
                    <li><a data-toggle="tab" href="#amizade">Amizade</a></li>
                    <li><a data-toggle="tab" href="#administrador">Administrador</a></li>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>
                <div class="tab-content">
                    <div id="perfil" class="tab-pane fade text-center fade in active">
                        <br>
                        <h3>Perfil de ${requestScope.userVisitante.apelido}</h3>
                        <div class="form-group">
                            <div class="modal-dialog">
                                <img src="${requestScope.userVisitante.foto}" alt="${requestScope.userVisitante.apelido}" title="${requestScope.userVisitante.apelido}"><br>
                                <h4>Cidade: ${requestScope.userVisitante.cidade}</h4>
                                <h4>Estado: ${requestScope.userVisitante.estado}</h4>
                            </div>
                        </div>
                    </div>
                    <div id="amizade" class="tab-pane fade text-center">
                        <h3>Vocês ainda não são amigos!</h3>
                        <p>Envia uma solicatação de amizade.</p>
                        <br><br>
                        <button class="botaoPequeno">Solicitar Amizade</button>
                    </div>
                    <div id="amizade" class="tab-pane fade text-center">
                        <c:if test="${requestScope.userVisitante.tipo == true}">
                            <h3>${requestScope.userVisitante.apelido} já é administrador!</h3>
                        </c:if>
                        <c:if test="${requestScope.userVisitante.tipo == false}">
                            <h3>${sessionScope.userVisitante.apelido} não é administrador!</h3>
                            <p>Torne-o um administrador agora.</p>
                            <br><br>
                            <button class="botaoPequeno">Torná-lo administrador</button>
                        </c:if>
                    </div>
                    <div id="buscar" class="tab-pane fade text-center">
                        <br>
                        <h3>Buscar</h3>
                        <p>Digite sua busca.</p><br><br><br>
                        <div>
                            <input class="botaoMedio" type="text" name="busca" placeholder="Buscar">
                            <input class="botaoPequeno" type="submit" value="Search">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>