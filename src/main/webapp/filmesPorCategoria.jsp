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
                    <li class="active"><a data-toggle="tab" href="#filmes" id="home">Filmes Encontrados</a></li>
                    <li><a data-toggle="tab" href="#amigos">Amigos</a></li>
                    <li><a data-toggle="tab" href="#generos">Gêneros</a></li>
                        <c:if test="${sessionScope.user.tipo == true}">
                        <li><a data-toggle="tab" href="#cadastroFilmes">Cadastrar Filmes</a></li>
                        <li><a data-toggle="tab" href="#grupos">Grupos</a></li>
                        </c:if>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="filmes" class="tab-pane fade text-center fade in active">
                        <%
                            String genero = (String) request.getAttribute("generoEscolhido");
                            List<Filme> filmes = new GerenciadorFilme().buscarFilmesPorGeneros(genero);
                            if (filmes.isEmpty()) {%>
                        <br>
                        <h3>Não há nenhum filme para esta categoria</h3>
                        <%}%>
                        <c:forEach items="<%=filmes%>" var="f">
                            <section class="text-center margin-top table-responsive modal-header modal-dialog">
                                <br>
                                <h2><a href="#">${f.titulo}</a></h2>
                                <img src="${f.foto}" alt="${f.titulo}" width="300" height="230" title="${f.titulo}">
                                <h5>${f.sinopse}</h5>
                                <button class="botaoPequeno margin-top">Ver Filme</button>  
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