<%-- 
    Document   : cadastraFilmes
    Created on : 27/10/2015, 20:56:41
    Author     : dijalma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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