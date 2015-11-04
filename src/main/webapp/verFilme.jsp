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
                    <li class="active"><a data-toggle="tab" href="#feed" id="home">Filme</a></li>
                    <li><a data-toggle="tab" href="#atores">Atores</a></li>
                    <li><a data-toggle="tab" href="#diretores">Diretores</a></li>
                        <c:if test="${sessionScope.user != null}">
                        <li><a data-toggle="tab" href="#avaliar">Avaliar</a></li>
                        <li><a data-toggle="tab" href="#recomendar">Recomendar</a></li>
                        </c:if>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="feed" class="tab-pane fade text-center in active">
                        <section class="text-center margin-top table-responsive modal-header modal-dialog">
                            <br>
                            <h1><a>${filmeSelecionado.titulo}</a></h1>
                            <p>Postado por <c:if test="${filmeSelecionado.idUser == user.id}"><a href="editarPerfil.jsp">você</a></c:if> 
                                <c:if test="${filmeSelecionado.idUser != user.id}"><a href="ControlePerfilVisitante?idDoUsuario=${filmeSelecionado.idUser}">${usuarioDeCadastro}</a></c:if>
                                em ${filmeSelecionado.dataDeCadastro}</p>
                            <br>
                            <img src="${filmeSelecionado.foto}" alt="${filmeSelecionado.titulo}" width="300" height="230" title="${filmeSelecionado.titulo}">
                            <br><br>
                            <img src="imagens/starP.png" alt="rating" title="rating">
                            <img src="imagens/starP.png" alt="rating" title="rating">
                            <img src="imagens/starV.png" alt="rating" title="rating">
                            <img src="imagens/starV.png" alt="rating" title="rating">
                            <img src="imagens/starV.png" alt="rating" title="rating">
                            <br><br><br>
                            <h3>Sinopse</h3>
                            <h4>${filmeSelecionado.sinopse}</h4>
                            <br><br><br>
                            <h3>Ano de Lançamento</h3>
                            <h4>${filmeSelecionado.ano}</h4>
                        </section>
                    </div>
                    <div id="atores" class="tab-pane fade text-center">
                        <div class="text-center margin-top table-responsive modal-header modal-dialog">
                            <br>
                            <h2><a>Atores Principais</a></h2>
                            <br><br><br>
                            <h4>${filmeSelecionado.atoresPrincipais}</h4>
                        </div>
                    </div>
                    <div id="diretores" class="tab-pane fade text-center">
                        <div class="text-center margin-top table-responsive modal-header modal-dialog">
                            <br>
                            <h2><a>Diretores</a></h2>
                            <br><br><br>
                            <h4>${filmeSelecionado.diretores}</h4>
                        </div>
                    </div>
                    <div id="avaliar" class="tab-pane fade text-center">
                        <div class="text-center margin-top table-responsive modal-header modal-dialog">
                            <h2><a>Avalie agora o filme</a></h2>
                            <br>
                            <br>
                            <div class="form-group">
                                <div class="panel-body">
                                    <img src="imagens/starP.png" alt="rating" id="star1" title="rating">
                                    <img src="imagens/starV.png" alt="rating" id="star2" title="rating">
                                    <img src="imagens/starV.png" alt="rating" id="star3" title="rating">
                                    <img src="imagens/starV.png" alt="rating" id="star4" title="rating">
                                    <img src="imagens/starV.png" alt="rating" id="star5" title="rating">
                                </div>
                                <br><br>
                                <form action="ControleAvaliacao" method="post">
                                    <input class="invisible" name="rating" value="" id="rating">
                                    <textarea class="textArea botaoMedioEspecial" placeholder="Comentário" id="comentario" name="comentario"></textarea> 
                                    <button type="submit" value="Avaliar" class="botaoPequeno" id="enviaAvaliacao">Avaliar</button>
                                </form>
                                <br>
                            </div>
                            <div class="table-overflow-comentarios">
                                <c:if test="${avaliacoes == null}"><h4>Sem comentários posteriores</h4></c:if>
                                <c:if test="${avaliacoes != null}"><h4>Veja alguns comentários posteriores</h4></c:if>
                                    <br><br>
                                <c:forEach items="${avaliacoes}" var="a">
                                    <div class="text-left modal-header">
                                        <img src="${user.foto}" alt="${a.idUsuario}" title="${a.idUsuario}" class="img-perfil">
                                        <c:if test="${a.idUsuario == sessionScope.user.id}"><a href="editarPerfil.jsp" class="text-capitalize active">Você: </a></c:if>
                                        <c:if test="${a.idUsuario != sessionScope.user.id}"><a href="ControlePerfilVisitante?idDoUsuario=${a.idUsuario}" class="text-capitalize active">${a.apelido}: </a></c:if>
                                        <label>${a.comentario}</label><br>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div id="recomendar" class="tab-pane fade text-center">
                        <br>
                        <h3>Recomende esse filme a algum amigo.</h3>
                        <div class="text-center margin-top table-responsive modal-header modal-dialog">
                            <form action="ControleAchaUsuario" method="post">
                                <input class="botaoMedio margin-top" type="text" name="emailOuApelido" placeholder="Digite email ou apelido">
                                <input class="botaoPequeno margin-top" type="submit" value="Procurar">
                            </form>
                        </div>
                    </div>
                    <%@include file="search.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>