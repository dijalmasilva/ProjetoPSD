<%@page import="gerenciador.GerenciadorFilme"%>
<%@page import="entidades.Filme"%>
<%@page import="java.util.List"%>
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
        <div class="margin-top-body">
            <div class="container nav-justified">
                <a href="logado.jsp"><h1 class="text-center textoPreto">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li><a data-toggle="tab" href="#feed" id="home">Feed</a></li>
                    <li class="active"><a data-toggle="tab" href="#amigos">Amigos</a></li>
                    <li><a data-toggle="tab" href="#generos">Gêneros</a></li>
                        <c:if test="${sessionScope.user.tipo == true}">
                        <li><a data-toggle="tab" href="#cadastroFilmes">Cadastrar Filmes</a></li>
                        <li><a data-toggle="tab" href="#grupos">Grupos</a></li>
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
                            <div class="modal-dialog">
                                <c:forEach items="${requestScope.usuariosAchados}" var="userFind">
                                    <br>
                                    <div class="list-inline modal-header">
                                        <form action="ControlePerfilVisitante" method="post">
                                            <button type="submit" class="botaoDeUsuario">
                                                <input type="text" name="idDoUsuario" class="visible-xs" value="${userFind.id}">
                                                <img src="${userFind.foto}" alt="${userFind.apelido}" title="${userFind.apelido}" class="img-perfil">
                                                <a class="text-capitalize active">${userFind.apelido}</a>
                                            </button>
                                        </form>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>
                    <div id="generos" class="tab-pane fade text-center">
                        <br>
                        <h3>Categorias</h3>
                        <p>Selecione a categoria do filme.</p>
                        <br><br>
                        <div class="generosTexto pretoOpaco">
                            <ul class="menuNavegacao">
                                <li><a href="#action">Ação</a></li>
                                <li><a href="#action">Aventura</a></li>
                                <li><a href="#action">Animação</a></li>
                                <li><a href="#action">Comédia</a></li>
                                <li><a href="#action">Clássico</a></li>
                                <li><a href="#action">Documentário</a></li>
                                <li><a href="#action">Drama</a></li>
                                <li><a href="#action">Ficção Científica</a></li>
                                <li><a href="#action">Musical</a></li>
                                <li><a href="#action">Romance</a></li>
                                <li><a href="#action">Terror</a></li>
                                <li><a href="#action">Suspense</a></li>
                            </ul>
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