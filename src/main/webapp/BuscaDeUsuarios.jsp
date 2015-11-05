<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <%@include file="head.jsp" %>
    <body  id="fundo" class="textoPreto white-background">
        <%@include file="barraUsuario.jsp"%>
        <%@include file="grupos.jsp" %>
        <div class="margin-top-body">
            <div class="container nav-justified">
                <a href="logado.jsp"><h1 class="text-center textoPreto">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li><a data-toggle="tab" href="#feed" id="home">Feed</a></li>
                    <li class="active"><a data-toggle="tab" href="#amigos">Usuários</a></li>
                    <li><a data-toggle="tab" href="#generos">Gêneros</a></li>
                        <c:if test="${sessionScope.user.tipo == true}">
                        <li><a data-toggle="tab" href="#cadastroFilmes">Cadastrar Filmes</a></li>
                        </c:if>
                    <li><a data-toggle="tab" href="#grupos">Grupos</a></li>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <%@include file="visualizaFilmes.jsp" %>
                    <div id="amigos" class="tab-pane fade text-center fade in active">
                        <c:if test="${requestScope.usuariosAchados == null}">
                            <br>
                            <h2>Não existe usuários com esse email ou apelido!</h2>
                            <p class="margin-top">Faça outra busca.</p>
                            <form action="ControleAcharUsuarios" method="post">
                                <input class="botaoMedio margin-top" type="text" name="emailOuApelido" placeholder="Digite email ou apelido">
                                <input class="botaoPequeno margin-top" type="submit" value="Procurar">
                            </form>
                        </c:if>
                        <c:if test="${requestScope.usuariosAchados != null}">
                            <br>
                            <h3>Usuário(s) encontrado(s)!</h3>
                            <div class="modal-dialog row">
                                <c:forEach items="${requestScope.usuariosAchados}" var="userFind">
                                    <div class="list-inline modal-header table-responsive col-sm-4">
                                        <img src="${userFind.foto}" alt="${userFind.apelido}" title="${userFind.apelido}" class="img-solicitacao">
                                        <h3><a href="ControlePerfilVisitante?idDoUsuario=${userFind.id}" class="text-capitalize active">${userFind.apelido}</a></h3>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>
                    <%@include file="generos.jsp" %>
                    <c:if test="${sessionScope.user.tipo == true}">
                        <%@include file="cadastraFilmes.jsp" %>
                    </c:if>
                    <%@include file="visualizaGrupos.jsp" %>
                    <%@include file="search.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>