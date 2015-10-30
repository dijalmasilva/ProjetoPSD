<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <%@include file="head.jsp" %>
    <body  id="fundo" class="textoPreto white-background">
        <%@include file="barraUsuario.jsp"%>
        <div class="margin-top-body">
            <div class="container nav-justified">
                <a href="logado.jsp"><h1 class="text-center textoPreto">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li class="active"><a data-toggle="tab" href="#perfil">Perfil</a></li>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="perfil" class="tab-pane fade text-center fade in active">
                        <br>
                        <h3>Seu Perfil</h3>
                        <div class="form-group">
                            <form class="container" action="ControleAtualizarPerfil" method="post">
                                <img class="img-circle" src="${sessionScope.user.foto}" alt="fotoDoPerfil"><br>
                                <input class="botaoMedio margin-top" type="text" name="nomeCompleto" placeholder="Nome Completo" value="${sessionScope.user.nome}"> <br>
                                <input class="botaoMedio margin-top" type="text" name="apelido" placeholder="Apelido" value="${sessionScope.user.apelido}"> <br>
                                <input class="botaoMedio margin-top" type="text" name="estado" placeholder="Estado" value="${sessionScope.user.estado}"> <br>
                                <input class="botaoMedio margin-top" type="text" name="cidade" placeholder="Cidade" value="${sessionScope.user.cidade}"> <br><br><br>
                                <input class="botaoPequeno" type="submit" value="Salvar">
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
        </div>
    </body>
</html>