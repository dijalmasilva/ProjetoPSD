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
        <script src="javascript/jquery.tubular.1.0.js"></script>
        <script src="javascript/javascriptHome.js"></script>

    </head>
    <body>
        <div id="fundo" class="wrapper">
            <div class="text-right" id="volume">
                <label class="espacoEmCima espacamento">Volume</label>
                <button class="espacamento tubular-volume-up volume">+</button>
                <button class="espacamento tubular-volume-down volume">-</button>             
            </div>
            <div class="container nav-justified">
                <a href="index.html"><h1 class="text-center textoBranco">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li><a data-toggle="tab" href="#inicio" id="home">In�cio</a></li>
                    <li><a data-toggle="tab" href="#generos">G�neros</a></li>
                    <li><a data-toggle="tab" href="#login">Login</a></li>
                    <li class="active"><a data-toggle="tab" href="#cadastro">Cadastre-se</a></li>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="inicio" class="tab-pane text-center">
                        <br><br><br><br>
                        <div class="">
                            <h3>SUA REDE SOCIAL</h3>
                            <p>Aqui voc� compartilha todas suas opni�es sobre os filmes que adora ou odeia com o mundo todo.</p>
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
                            <form action="ControleFilmesPorCategoriaNaoLogado" method="post">
                                <ul class="menuNavegacao">
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="A��o">A��o                           </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Aventura">Aventura                   </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Anima��o">Anima��o                   </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Com�dia">Com�dia                     </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Document�rio">Document�rio           </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Drama">Drama                         </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Fic��o Cient�fica">Fic��o Cient�fica </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Musical">Musical                     </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Nacional">Nacional                   </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Romance">Romance                     </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Terror">Terror                       </button></a></li>
                                    <li><a><button name="genero" type="submit" class="botaoTransparente" value="Suspense">Suspense                   </button></a></li>
                                </ul>
                            </form>
                        </div>
                    </div>
                    <div id="login" class="tab-pane fade text-center">
                        <br>
                        <c:if test="${requestScope.cadastrou == true}">
                            <h3>Cadastro realizado com sucesso!</h3>
                            <p>Fa�a seu login!</p>
                            <div class="form-group">
                                <form class="container" action="ControleLogarUsuario" method="post">
                                    <input class="botaoMedio margin-top" type="email" name="emailLogin" placeholder="Email" value="${requestScope.emailCadastro}"><br>
                                    <input class="botaoMedio margin-top" type="password" name="senhaLogin" placeholder="Senha"><br><br><br>
                                    <input class="botaoPequeno" type="submit" value="Logar">
                                </form>
                            </div>
                        </c:if>
                        <c:if test="${requestScope.cadastrou == false}">
                            <h3 class="textVermelho">Erro ao cadastrar</h2>
                            </c:if>
                    </div>
                    <div id="cadastro" class="tab-pane fade text-center fade in active">
                        <br>
                        <h3>Cadastro</h3>
                        <p>Informe seus dados.</p>
                        <div class="form-group">
                            <form class="container" action="ControleCadastroUsuario" method="post">
                                <img src="imagens/user.png" alt="fotoDoPerfil"><br>
                                <input class="botaoMedio margin-top" type="text" name="nomeCompleto" placeholder="Nome Completo"> <br>
                                <input class="botaoMedio margin-top" type="email" name="emailCadastro" placeholder="Email"> <br>
                                <input class="botaoMedio margin-top" type="password" name="senhaCadastro" placeholder="Senha"><br>
                                <input class="botaoMedio margin-top" type="text" name="apelido" placeholder="Apelido"> <br>
                                <input class="botaoMedio margin-top" type="text" name="estado" placeholder="Estado"> <br>
                                <input class="botaoMedio margin-top" type="text" name="cidade" placeholder="Cidade"> <br>
                                <input class="botaoMedio margin-top" type="date" name="dataDeNascimento"> <br><br><br>
                                <input class="botaoPequeno" type="submit" value="Cadastrar">
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

            <div class="navbar-fixed-bottom">
                <footer class="panel-footer text-center rodapeFixo">
                    <p>Site Desenvolvido por Dijalma Silva & Zilderlan</p>
                </footer>
            </div>
        </div>
    </body>
</html>
