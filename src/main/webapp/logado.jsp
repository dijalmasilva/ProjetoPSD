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
    <body  id="fundo" class="textoPreto gray-background">
        <div>
            <div class="nav navbar-fixed-bottom nav-perfil" id="menuUser">
                <div>
                    <img src="${sessionScope.user.foto}" class="img-circle img-perfil">
                    <a href="#" id="apelido" class="text-uppercase textoBranco">${sessionScope.user.apelido}</a>
                    <div class="flutuarSomenteAdireita">
                        <a href="#">
                            <strong class="textoBranco">Notificações</strong>
                            <img class="img-perfil" src="imagens/NotificationIcon.png" alt="notificações">
                        </a>
                        <a href="ControleLogout" class="textoBranco">Sair</a>
                    </div>
                    <br><br><br>
                    <a href="#">Editar Perfil</a><br>
                    <a href="#">Cofigurações de Segurança</a>
                    <div class="flutuarSomenteAdireita">
                        <a href="#" class="textoBranco" id="voltar">
                            <strong class="botaoMedio textoBranco">Voltar</strong>
                            <img src="imagens/back.png" alt="voltar">
                        </a>
                    </div>
                </div> 
            </div>
            <div class="container nav-justified">
                <a href="logado.jsp"><h1 class="text-center textoPreto">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li class="active"><a data-toggle="tab" href="#feed" id="home">Feed</a></li>
                    <li><a data-toggle="tab" href="#generos">Gêneros</a></li>
                        <c:if test="${sessionScope.user.tipo == true}">
                        <li><a data-toggle="tab" href="#cadastroFilmes">Cadastrar Filmes</a></li>
                        <li><a data-toggle="tab" href="#criarGrupos">Criar Grupo</a></li>
                        </c:if>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="feed" class="tab-pane fade text-center fade in active">
                        <% for (int i = 0; i < 3; i++) {%>
                        <div class="text-center">
                            <br><br><br><br>
                            <img src="imagens/movie.png" alt="imagemFilme" width="230" height="230">
                            <h2>Esse filme eh bom</h2>
                            <p>Vale a pena viu</p>
                        </div>
                        <%}%>
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
                        <div id="criarGrupos" class="tab-pane text-center">
                            <br>
                            <div>
                                <h3>Crie um grupo</h3>
                                <p>Debata com seus amigos sobre os melhores filmes.</p>
                                <div class="form-group">
                                    <form class="container" action="ControleCadastroGrupo" method="post">
                                        <input class="botaoMedio margin-top" type="text" placeholder="Nome do grupo" name="nomeDoGrupo" required="on"><br>
                                        <textarea class="botaoMedio margin-top textArea" name="descricao" placeholder="Descriçao" required="on"></textarea><br><br>
                                        <input class="botaoPequeno" type="submit" value="Criar">
                                    </form>
                                </div>
                            </div>
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



