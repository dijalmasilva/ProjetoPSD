<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div>
    <h3>Grupos</h3>
    <p>Aqui estão seus grupos.</p>
    <div class="form-group">
        <form class="container" action="ControleCadastroGrupo" method="post">
            <input class="botaoMedio margin-top" type="text" placeholder="Nome do grupo" name="nomeDoGrupo" required="on"><br>
            <textarea class="botaoMedio margin-top textArea" name="descricao" placeholder="Descriçao" required="on"></textarea><br><br>
            <input class="botaoPequeno" type="submit" value="Criar">
        </form>
    </div>
</div>