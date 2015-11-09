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
                    <li class="active"><a data-toggle="tab" href="#usuarios" id="home">Usuários</a></li>
                    <li><a data-toggle="tab" href="#filmes">Filmes</a></li>
                    <li><a data-toggle="tab" href="#grupos">Grupos</a></li>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="usuarios" class="tab-pane fade text-center in active">
                        <br>
                        <c:if test="${usuariosBuscados != null}"><h3>Usuários encontrados</h3></c:if>
                        <c:if test="${usuariosBuscados == null}"><h3>Nenhum usuário encontrado</h3></c:if>
                        <br>
                        <div class="row modal-dialog">
                            <c:forEach items="${usuariosBuscados}" var="u">
                                <div class="modal-header col-sm-4">
                                    <img src="${u.foto}" alt="${u.apelido}" title="${u.apelido}" class="img-perfil img-circle">
                                    <a href="ControlePerfilVisitante?idDoUsuario=${u.id}" class="text-capitalize">${u.apelido}</a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div id="filmes" class="tab-pane fade text-center">
                        <br>
                        <c:if test="${filmesBuscados != null}"><h3>Filmes encontrados</h3></c:if>
                        <c:if test="${filmesBuscados == null}"><h3>Nenhum filme encontrado</h3></c:if>
                        <br>
                        <c:forEach items="${filmesBuscados}" var="f">
                            <section class="text-center margin-top table-responsive modal-header modal-dialog">
                                <br>
                                <h2><a href="ControleVerFilme?idFilmeSelecionado=${f.id}">${f.titulo}</a></h2>
                                <img src="${f.foto}" alt="${f.titulo}" width="300" height="230" title="${f.titulo}">
                                <h5>${f.sinopse}</h5>
                                <form action="ControleVerFilme" method="post">
                                    <input type="submit" class="botaoPequeno margin-top" value="Ver Filme"><br>  
                                    <input class="invisible" value="${f.id}" name="idFilmeSelecionado">
                                </form>
                            </section>
                        </c:forEach>
                    </div>
                    <div id="grupos" class="tab-pane fade text-center">
                        <br>
                        <c:if test="${gruposBuscados != null}"><h3>Grupos encontrados</h3></c:if>
                        <c:if test="${gruposBuscados == null}"><h3>Nenhum grupo encontrado</h3></c:if>
                        <div class="row">
                            <c:forEach items="${gruposBuscados}" var="g">
                                <div class="col-sm-3 modal-header">
                                    <br>
                                    <h2><a href="ControleVerGrupo?idGrupo=${g.id}">${g.nomeDoGrupo}</a></h2>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <%@include file="search.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>