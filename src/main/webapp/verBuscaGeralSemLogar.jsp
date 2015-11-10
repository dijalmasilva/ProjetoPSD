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
                    <li class="active"><a data-toggle="tab" href="#filmes">Filmes</a></li>
                    <li><a data-toggle="tab" href="#generos">Gêneros</a></li>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="filmes" class="tab-pane fade text-center in active">
                        <br>
                        <c:if test="${filmesBuscados != null}"><h3>Filmes encontrados</h3></c:if>
                        <c:if test="${filmesBuscados == null}"><h3>Nenhum filme encontrado</h3></c:if>
                            <br>
                        <c:forEach items="${filmesBuscados}" var="f">
                            <section class="text-center margin-top table-responsive modal-header modal-dialog">
                                <br>
                                <h2><a href="ControleVerFilmeNaoLogado?idFilmeSelecionado=${f.id}">${f.titulo}</a></h2>
                                <img src="${f.foto}" alt="${f.titulo}" width="400" height="450" title="${f.titulo}">
                                <h5>${f.sinopse}</h5>
                                <form action="ControleVerFilmeNaoLogado" method="post">
                                    <input type="submit" class="botaoPequeno margin-top" value="Ver Filme"><br>  
                                    <input class="invisible" value="${f.id}" name="idFilmeSelecionado">
                                </form>
                            </section>
                        </c:forEach>
                    </div>
                    <div id="generos" class="tab-pane fade text-center">
                        <br>
                        <h3>Categorias</h3>
                        <p>Selecione a categoria do filme.</p>
                        <br><br>
                        <div class="generosTexto brancoOpaco">
                            <form action="ControleFilmesPorCategoriaNaoLogado" method="post">
                                <ul class="menuNavegacao">
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Ação">Ação                           </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Aventura">Aventura                   </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Animação">Animação                   </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Comédia">Comédia                     </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Documentário">Documentário           </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Drama">Drama                         </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Ficção Científica">Ficção Científica </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Musical">Musical                     </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Nacional">Nacional                   </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Romance">Romance                     </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Terror">Terror                       </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Suspense">Suspense                   </button></a></li>
                                </ul>
                            </form>
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