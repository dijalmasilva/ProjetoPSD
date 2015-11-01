<%@page import="java.util.List"%>
<%@page import="gerenciador.GerenciadorFilme"%>
<%@page import="entidades.Filme"%>
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
                    <li class="active"><a data-toggle="tab" href="#feed" id="home">Feed</a></li>
                    <li><a data-toggle="tab" href="#amigos">Amigos</a></li>
                    <li><a data-toggle="tab" href="#generos">Gêneros</a></li>
                        <c:if test="${sessionScope.user.tipo == true}">
                        <li><a data-toggle="tab" href="#cadastroFilmes">Cadastrar Filmes</a></li>
                        <li><a data-toggle="tab" href="#grupos">Grupos</a></li>
                        </c:if>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="feed" class="tab-pane fade text-center in active">
                        <c:forEach items="${applicationScope.dezFilmesRecentes}" var="f">
                            <section class="text-center margin-top table-responsive modal-header modal-dialog">
                                <br>
                                <h2><a href="ControleVerFilme?idFilmeSelecionado=${f.id}">${f.titulo}</a></h2>
                                <img src="${f.foto}" alt="${f.titulo}" width="300" height="230" title="${f.titulo}">
                                <h5>${f.sinopse}</h5>
                                <form action="ControleVerFilme">
                                    <button class="visible-xs" value="${f.id}" name="idFilmeSelecionado"></button>
                                    <button type="submit" class="botaoPequeno margin-top">Ver Filme</button>  
                                </form>
                            </section>
                        </c:forEach>
                    </div>
                    <%@include file="visualizaAmigos.jsp" %>
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