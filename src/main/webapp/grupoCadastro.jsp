<%@page import="java.util.List"%>
<%@page import="gerenciador.GerenciadorFilme"%>
<%@page import="entidades.Filme"%>
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
        <%@include file="grupos.jsp" %>
        <div class="margin-top-body">
            <div class="container nav-justified">
                <a href="logado.jsp"><h1 class="text-center textoPreto">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li><a data-toggle="tab" href="#feed" id="home">Feed</a></li>
                    <li><a data-toggle="tab" href="#amigos">Amigos</a></li>
                    <li><a data-toggle="tab" href="#generos">Gêneros</a></li>
                        <c:if test="${sessionScope.user.tipo == true}">
                        <li><a data-toggle="tab" href="#cadastroFilmes">Cadastrar Filmes</a></li>
                        <li class="active"><a data-toggle="tab" href="#grupos">Grupos</a></li>
                        </c:if>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="feed" class="tab-pane fade text-center">
                        <%
                            List<Filme> cincoFilmesRecentes = new GerenciadorFilme().buscarCincoFilmesRecentes();
                        %>
                        <c:forEach items="<%=cincoFilmesRecentes%>" var="f">
                            <section class="text-center margin-top table-responsive modal-header modal-dialog">
                                <br>
                                <h2><a href="#">${f.titulo}</a></h2>
                                <img src="${f.foto}" alt="${f.titulo}" width="300" height="230" title="${f.titulo}">
                                <h5>${f.sinopse}</h5>
                                <button class="botaoPequeno margin-top">Ver Filme</button>  
                            </section>
                        </c:forEach>
                    </div>
                    <div id="amigos" class="tab-pane fade text-center">
                        <c:if test="${sessionScope.friends == null}">
                            <br>
                            <h2>Você ainda não tem amigos!</h2>
                            <p class="margin-top">Adicione agora alguns amigos.</p>
                            <form action="ControleAcharUsuarios" method="post">
                                <input class="botaoMedio margin-top" type="text" name="emailOuApelido" placeholder="Digite email ou apelido">
                                <input class="botaoPequeno margin-top" type="submit" value="Procurar">
                            </form>

                        </c:if>
                    </div>
                    <div id="generos" class="tab-pane fade text-center">
                        <br>
                        <h3>Categorias</h3>
                        <p>Selecione a categoria do filme.</p>
                        <br><br>
                        <div class="generosTexto brancoOpaco">
                            <form action="ControleFilmesPorCategoria" method="post">
                                <ul class="menuNavegacao">
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Ação">Ação</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Aventura">Aventura</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Animação">Animação</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Comédia">Comédia</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Clássico">Clássico</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Documentário">Documentário</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Drama">Drama</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Ficção Científica">Ficção Científica</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Musical">Musical</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Romance">Romance</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Terror">Terror</button></a></li>
                                    <li><a><button type="submit" name="genero" class="botaoDeUsuario" value="Suspense">Suspense</button></a></li>
                                </ul>
                            </form>
                        </div>
                    </div>
                    <c:if test="${sessionScope.user.tipo == true}">
                        <div id="cadastroFilmes" class="tab-pane text-center">
                            <br>
                            <div>
                                <h3>Cadastre o filme</h3>
                                <p>Campos com mais de um nome separe com ", " sem aspas.</p>
                                <div class="form-group">
                                    <form class="container" action="ControleCadastroFilme" method="post">
                                        <img src="imagens/movie.png" alt="fotoDoFilme" class="img-filme"><br>
                                        <input class="botaoMedio margin-top" type="text" name="titulo" placeholder="Título"><br>
                                        <input class="botaoMedio margin-top" type="text" name="ano" placeholder="Ano"><br>
                                        <input class="botaoMedio margin-top" type="text" name="generos" placeholder="Gêneros"><br>
                                        <input class="botaoMedio margin-top" type="text" name="atoresPrincipais" placeholder="Atores Principais"><br>
                                        <input class="botaoMedio margin-top" type="text" name="diretores" placeholder="Diretores"><br>
                                        <textarea class="botaoMedio margin-top textArea" name="sinopse" placeholder="Sinopse"></textarea><br>
                                        <input class="botaoPequeno" type="submit" value="Cadastrar">
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="grupos" class="tab-pane text-center">
                            <br>
                            <c:if test="${sessionScope.grupos == null}">
                                <h3>Você ainda não faz parte de nenhum grupo!</h3>
                            </c:if>
                            <c:if test="${sessionScope.grupos != null}">
                                <h3>Seus grupos!</h3>
                            </c:if>
                            <br>
                            <div class="modal-dialog text-center">
                                <a href="#" id="newGroup">Criar novo grupo</a>
                            </div>
                            <c:forEach items="${sessionScope.grupos}" var="g">
                                <section class="text-center margin-top table-responsive modal-header modal-dialog">
                                    <br>
                                    <h2><a href="#">${g.nomeDoGrupo}</a></h2>
                                    <button class="botaoPequeno margin-top">Ver Grupo</button>  
                                </section>
                            </c:forEach>
                        </div>
                    </c:if>
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