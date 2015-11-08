<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
    <%@include file="head.jsp" %>
    <body  id="fundo" class="textoPreto white-background">
        <%@include file="barraUsuarioNaoLogado.jsp"%>
        <div class="margin-top-body">
            <div class="container nav-justified">
                <a href="index.html"><h1 class="text-center textoPreto">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li class="active"><a data-toggle="tab" href="#feed" id="home">Filme</a></li>
                    <li><a data-toggle="tab" href="#atores">Atores</a></li>
                    <li><a data-toggle="tab" href="#diretores">Diretores</a></li>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="feed" class="tab-pane fade text-center in active">
                        <section class="text-center margin-top table-responsive modal-header modal-dialog">
                            <br>
                            <h1><a>${filmeSelecionado.titulo}</a></h1>
                            <br>
                            <img src="${filmeSelecionado.foto}" alt="${filmeSelecionado.titulo}" width="300" height="230" title="${filmeSelecionado.titulo}">
                            <br><br>
                            <c:choose>
                                <c:when test="${rating == 1}">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                </c:when>
                                <c:when test="${rating == 2}">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                </c:when>
                                <c:when test="${rating == 3}">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                </c:when>
                                <c:when test="${rating == 4}">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                </c:when>
                                <c:when test="${rating == 5}">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                    <img src="imagens/starP.png" alt="rating" title="rating">
                                </c:when>
                                <c:otherwise>
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                    <img src="imagens/starV.png" alt="rating" title="rating">
                                </c:otherwise>
                            </c:choose>
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
                    <div id="buscar" class="tab-pane fade text-center">
                        <br>
                        <h3>Buscar</h3>
                        <p>Digite sua busca.</p><br><br><br>
                        <div class="form-group">
                            <form action="ControleBuscarNaoLogado" method="post">
                                <input class="botaoMedio margin-top" type="text" name="busca" placeholder="Buscar">
                                <input class="botaoPequeno margin-top" type="submit" value="Search">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>