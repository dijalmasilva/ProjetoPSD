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
                    <c:if test="${sessionScope.user.tipo == true}">
                    <li><a data-toggle="tab" href="#administrador">Administrador</a></li>
                    </c:if>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>
                <div class="tab-content">
                    <div id="perfil" class="tab-pane fade text-center fade in active">
                        <br>
                        <h3>Perfil de ${sessionScope.userVisitante.apelido}</h3>
                        <div class="form-group">
                            <div class="modal-dialog">
                                <img src="${sessionScope.userVisitante.foto}" alt="${sessionScope.userVisitante.apelido}" title="${sessionScope.userVisitante.apelido}"><br>
                                <br>
                                <h4>Cidade: ${sessionScope.userVisitante.cidade}</h4><br>
                                <h4>Estado: ${sessionScope.userVisitante.estado}</h4><br>
                            </div>
                        </div>
                    </div>
                    <div id="amizade" class="tab-pane fade text-center">
                        <br><br>
                        <h3>Vocês ainda não são amigos!</h3><br>
                        <p>Envia uma solicatação de amizade.</p>
                        <br><br>
                        <button class="botaoPequeno">Solicitar Amizade</button>
                    </div>
                    <div id="administrador" class="tab-pane fade text-center">
                        <c:if test="${sessionScope.userVisitante.tipo == true}">
                            <br><br>
                            <h3>${sessionScope.userVisitante.apelido} já é administrador(a)!</h3>
                        </c:if>
                        <c:if test="${sessionScope.userVisitante.tipo == false}">
                            <br><br>
                            <h3>${sessionScope.userVisitante.apelido} não é administrador(a)!</h3>
                            <br>
                            <p>Torne-o um administrador agora.</p>
                            <br>
                            <form method="post" action="ControleAtualizarParaAdministrador">
                                <button type="submit" class="botaoPequeno">Torná-lo(a) administrador(a)</button>
                            </form>
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