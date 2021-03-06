<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <%@include file="head.jsp" %>
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
                                <img src="${sessionScope.userVisitante.foto}" alt="${sessionScope.userVisitante.apelido}" title="${sessionScope.userVisitante.apelido}" class="img-circle"><br>
                                <br>
                                <h4>Cidade: ${sessionScope.userVisitante.cidade}</h4><br>
                                <h4>Estado: ${sessionScope.userVisitante.estado}</h4><br>
                            </div>
                        </div>
                    </div>
                    <div id="amizade" class="tab-pane fade text-center">
                        <br><br>
                        <h3>Voc�s ainda n�o s�o amigos!</h3><br>
                        <p>Envia uma solicata��o de amizade.</p>
                        <br><br>
                        <form action="ControleSolicitaAmizade">
                            <button class="botaoPequeno">Solicitar Amizade</button>
                        </form>
                    </div>
                    <div id="administrador" class="tab-pane fade text-center">
                        <c:if test="${sessionScope.userVisitante.tipo == true}">
                            <br><br>
                            <h3>${sessionScope.userVisitante.apelido} j� � administrador(a)!</h3>
                        </c:if>
                        <c:if test="${sessionScope.userVisitante.tipo == false}">
                            <br><br>
                            <h3>${sessionScope.userVisitante.apelido} n�o � administrador(a)!</h3>
                            <br>
                            <p>Torne-o um administrador agora.</p>
                            <br>
                            <form method="post" action="ControleAtualizarParaAdministrador">
                                <button type="submit" class="botaoPequeno">Torn�-lo(a) administrador(a)</button>
                            </form>
                        </c:if>
                    </div>
                    <%@include file="search.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>