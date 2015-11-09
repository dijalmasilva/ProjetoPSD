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
        <script src="javascript/jquery-2.1.4.min.js"></script>
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
                    <li class="active"><a data-toggle="tab" href="#perfil">Perfil</a></li>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="perfil" class="tab-pane fade text-center fade in active">
                        <br>
                        <h3>Seu Perfil</h3>
                        <div class="form-group">
                            <form action="ControleAtualizarPerfil" method="post" enctype="multipart/form-data">
                                <img class="img-circle" src="${sessionScope.user.foto}" alt="fotoDoPerfil"><br><br>
                                <a id="arq" class="botaoMedio btn btn-default btn-file">Upload da Imagem</a><br>
                                <input class="botaoMedio margin-top" type="text" name="nomeCompleto" placeholder="Nome Completo" value="${sessionScope.user.nome}"> <br>
                                <input class="botaoMedio margin-top" type="text" name="apelido" placeholder="Apelido" value="${sessionScope.user.apelido}"> <br>
                                <input class="botaoMedio margin-top" type="text" name="estado" placeholder="Estado" value="${sessionScope.user.estado}"> <br>
                                <input class="botaoMedio margin-top" type="text" name="cidade" placeholder="Cidade" value="${sessionScope.user.cidade}"> <br><br><br>
                                <input class="botaoPequeno" type="submit" value="Salvar">
                                <input type="file" id="upload" class="invisible" name="fotoDePerfil">
                            </form>
                        </div>
                    </div>
                    <%@include file="search.jsp" %>
                </div>
            </div>
        </div>
        <script>

            jQuery("#arq").click(function () {
                jQuery("#upload").trigger('click');
            });

            jQuery("#upload").change(function () {
                var arq = jQuery("#upload").val().replace(/^.*\\/, "");
                jQuery("#arq").text(arq);
            });
        </script>
    </body>
</html>