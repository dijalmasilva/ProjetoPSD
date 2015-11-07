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
                    <li class="active"><a data-toggle="tab" href="#topico">Tópico</a></li>
                    <li><a data-toggle="tab" href="#criado">Criado</a></li>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>
                <div class="tab-content">
                    <div id="topico" class="tab-pane fade text-center in active">
                        <br>
                        <h2>${topicoSelecionado.nomeDoTopico}</h2>
                        <br>
                        <h4>${retorno}</h4>
                        <div class="form-group modal-header">
                            <form action="ControleComentaTopico" method="post">
                                <textarea class="textArea botaoMedio margin-top" placeholder="Comentário" name="comentario" required=""></textarea><br>
                                <input type="submit" class="botaoPequeno margin-top" value="Comentar">
                            </form>
                        </div>
                        <div class="table-overflow-comentarios modal-dialog" style="width: 60%">
                            <c:if test="${comentariosTopicos == null}"><h4>Sem comentários posteriores</h4></c:if>
                            <c:if test="${comentariosTopicos != null}"><h4>Veja alguns comentários posteriores</h4></c:if>
                                <br><br>
                            <c:forEach items="${comentariosTopicos}" var="a">
                                <div class="text-left modal-header">
                                    <img src="${a.foto}" alt="${a.idUsuario}" title="${a.idUsuario}" class="img-perfil">
                                    <c:if test="${a.idUsuario == sessionScope.user.id}"><a href="editarPerfil.jsp" class="text-capitalize active">Você: </a></c:if>
                                    <c:if test="${a.idUsuario != sessionScope.user.id}"><a href="ControlePerfilVisitante?idDoUsuario=${a.idUsuario}" class="text-capitalize active">${a.apelido}: </a></c:if>
                                    <label>${a.comentario}</label><br>
                                    <br>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div id="criado" class="tab-pane fade text-center">
                        <br>
                        <h3>Tópico criado por <c:if test="${topico.idUsuario == user.id}"><a href="editarPerfil.jsp">você</a></c:if>
                            <c:if test="${topico.idUsuario != user.id}"><a href="ControlePerfilVisitante?idDoUsuario=${topicoSelecionado.idUsuario}">${nomeUsuario}</a></c:if>
                            </h3>   
                        </div>
                    <%@include file="search.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>