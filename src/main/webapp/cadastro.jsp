<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
?<!DOCTYPE html>
<html lang="pt-br">
    <%@include file="head.jsp" %>
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
                    <li><a data-toggle="tab" href="#inicio" id="home">Início</a></li>
                    <li><a data-toggle="tab" href="#generos">Gêneros</a></li>
                    <li class="active"><a data-toggle="tab" href="#login">Login</a></li>
                    <li><a data-toggle="tab" href="#cadastro">Cadastre-se</a></li>
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
                    <div id="login" class="tab-pane fade text-center fade in active">
                        <br>
                        <c:if test="${requestScope.cadastrou == true}">
                            <h3>Cadastro realizado com sucesso!</h3>
                            <p>Faça seu login!</p>
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
                    <div id="cadastro" class="tab-pane fade text-center">
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
                        <div>
                            <input class="botaoMedio" type="text" name="busca" placeholder="Buscar">
                            <input class="botaoPequeno" type="submit" value="Search">
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
