<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="javascript/javascriptOutras.js" type="text/javascript"></script>
<div class="nav navbar-fixed-top nav-perfil" id="menuUser">
    <div>
        <img src="${sessionScope.user.foto}" class="img-circle img-perfil">
        <a href="#" id="apelido" class="text-uppercase textoBranco">${sessionScope.user.apelido}</a>
        <div class="flutuarSomenteAdireita">
            <div class="margin-rigth">
                <a href="#" id="solicitacoes" class="margin-rigth">
                    <img src="imagens/plus sign1.png" alt="solicitacoes" class="img-perfil" title="Solicitações">
                </a>
                <a href="#" id="notificacoes" class="margin-rigth">
                    <img class="img-perfil" src="imagens/NotificationIcon.png" alt="notificações" title="Notificações">
                </a>
                <a href="ControleLogout" class="textoBranco">
                    <img src="imagens/logout12.png" alt="sair" class="img-perfil" title="Sair">
                </a>
            </div>
        </div>
        <br><br><br>
        <div id="menuabaixo">
            <a href="#">Editar Perfil</a><br>
            <a href="#">Cofigurações de Segurança</a>
            <div class="flutuarSomenteAdireita">
                <a href="#" class="textoBranco" id="voltar">
                    <img src="imagens/back.png" alt="voltar" title="Voltar">
                </a>
            </div>
        </div>
    </div> 
</div>
