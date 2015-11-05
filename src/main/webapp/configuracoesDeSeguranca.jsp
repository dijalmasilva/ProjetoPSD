<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <script src="javascript/javascriptOutras.js"></script>
    <%@include file="head.jsp" %>
    <body  id="fundo" class="textoPreto white-background">
        <%@include file="barraUsuario.jsp"%>
        <div class="margin-top-body">
            <div class="container nav-justified">
                <a href="logado.jsp"><h1 class="text-center textoPreto">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li class="active"><a data-toggle="tab" href="#senha">Senha</a></li>
                    <li><a data-toggle="tab" href="#excluir">Excluir Conta</a></li>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="senha" class="tab-pane fade text-center fade in active">
                        <br>
                        <h3>Alterar senha</h3>
                        <div class="form-group">
                            <form class="container" action="ControleAlterarSenha" method="post">
                                <input class="botaoMedio margin-top" type="password" name="senhaAntiga" placeholder="Senha atual" required="on"><br>
                                <input class="botaoMedio margin-top" type="password" name="senhaNova" placeholder="Nova senha" required="on"><br>
                                <input class="botaoMedio margin-top" type="password" placeholder="Confirmar senha nova" required="on"><br>
                                <input class="botaoPequeno margin-top" type="submit" value="Alterar senha">
                            </form>
                            <div>
                                <h4>${retorno}</h4>
                            </div>
                        </div>
                    </div>
                    <div id="excluir" class="tab-pane fade text-center fade">
                        <br>
                        <h3>Deseja realmente excluir sua conta?</h3>
                        <p>Depois disso não poderá voltar com sua conta antiga.</p>
                        <br>
                        <div class="form-group">
                            <form class="container" action="ControleRemoverConta" method="post">
                                <button class="botaoPequeno margin-top" value="true" name="excluirConta">Excluir</button><br>
                            </form>
                        </div>
                    </div>
                    <%@include file="search.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>