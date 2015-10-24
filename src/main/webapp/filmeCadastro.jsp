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
        <script src="javascript/javascriptOutras.js" type="text/javascript"></script>

    </head>
    <body>
        <div id="fundo" class="deadPool2">
            <div class="nav navbar-fixed-bottom nav-perfil" id="menuUser">
                <div>
                    <img src="${sessionScope.user.foto}" class="img-circle img-perfil">
                    <a href="#" id="apelido" class="text-uppercase textoBranco">${sessionScope.user.apelido}</a>
                    <a><img src="imagens/NotificationIcon.png" alt="notificações"></a>
                    <a href="ControleLogout" class="flutuarADireita textoBranco">Sair</a>
                    <br><br><br>
                    <a href="#">Editar Perfil</a><br>
                    <a href="#">Cofigurações de Segurança</a>
                    <a href="#" class="flutuarADireita textVermelho" id="voltar">Voltar</a>
                </div>
            </div>
            <div class="container nav-justified">
                <a href="logado.jsp"><h1 class="text-center textoBranco">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li><a data-toggle="tab" href="#inicio" id="home">Início</a></li>
                    <li><a data-toggle="tab" href="#generos">Gêneros</a></li>
                        <c:if test="${sessionScope.user.tipo == true}">
                        <li class="active"><a data-toggle="tab" href="#cadastroFilmes">Cadastrar Filmes</a></li>
                        <li><a data-toggle="tab" href="#criarGrupos">Criar Grupo</a></li>
                        </c:if>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="inicio" class="tab-pane text-center">
                        <br><br><br><br>
                        <div class="">
                            <h3>SUA REDE SOCIAL</h3>
                            <p>Aqui você compartilha todas suas opniões sobre os filmes que adora ou odeia com o mundo todo.</p>
                            <br><br><br><br>
                            <button class="btn-link text-uppercase botaoMedio"><a data-toggle="tab" href="#cadastro" id="btCadastro">Cadastre-se agora</a></button>
                        </div>
                    </div>
                    <div id="generos" class="tab-pane fade text-center">
                        <br>
                        <h3>Categorias</h3>
                        <p>Selecione a categoria do filme.</p>
                        <br><br>
                        <div class="generosTexto brancoOpaco">
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
                        <div id="cadastroFilmes" class="tab-pane text-center fade in active">
                            <br>
                            <c:if test="${cadastrou != true}" var="ca">
                                <div>
                                    <h3>Cadastre o filme</h3>
                                    <p>Campos com mais de um nome separe com ", " sem aspas.</p>
                                    <div class="form-group">
                                        <form class="container" action="ControleCadastroFilme" method="post">
                                            <img src="imagens/movie.png" alt="fotoDoFilme" id="img-filme"><br>
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
                            </c:if>
                            <c:if test="ca == true">
                                <div>
                                    <c:set var="cadastrou" scope="request" value="false"></c:set>
                                        <h2>Filme cadastrado com sucesso!</h2><br><br><br><br>
                                        <p><a href="filmeCadastro.jsp">Clique aqui</a> para cadastrar um novo filme.</p>
                                    </div>
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



