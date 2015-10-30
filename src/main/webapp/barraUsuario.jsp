<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a href="editarPerfil.jsp">Editar Perfil</a><br>
            <a href="#">Cofigurações de Segurança</a>
            <div class="flutuarSomenteAdireita">
                <a href="#" class="textoBranco" id="voltar">
                    <img src="imagens/back.png" alt="voltar" title="Voltar">
                </a>
            </div>
        </div>
    </div> 
</div>
<div class="text-center navbar-fixed-top fundoCompleto" id="notifications">
    <aside class="textoBranco flutuarADireita barraLateralDireita">
        <img href="#" src="imagens/back.png" alt="voltar" title="voltar" id="sairNotifications" class="flutuarADireita margin-top">
        <h2 class="text-capitalize">Notificações</h2>
    </aside>
</div>
<div class="text-center navbar-fixed-top fundoCompleto" id="requests">
    <aside class="textoBranco flutuarADireita barraLateralDireita">
        <img href="#" src="imagens/back.png" alt="voltar" title="voltar" id="sairSolicitacoes" class="flutuarADireita margin-top">
        <form action="ControleAcharUsuarios" method="post">
        <h2 class="text-capitalize">Solicitações</h2>
            <p>Buscar amigo</p>
            <input class="botaoMedio margin-top" type="text" name="emailOuApelido" placeholder="Digite email ou apelido">
            <input class="botaoSolicitacoesPequeno margin-top" type="submit" value="Procurar">
        </form>
        <c:forEach items="${solicitacoes}" var="s">
            <br>
            <div class="list-inline modal-header modal-dialog table-responsive">
                <img src="${s.foto}" alt="${s.apelido}" title="${s.apelido}" class="img-perfil">
                <a href="ControlePerfilVisitante?idDoUsuario=${s.id}" class="text-capitalize active">${s.apelido}</a>
                <form action="ControleAceitaSolicitacaoPeloPerfilVisitante" method="post">
                    <button class="botaoPequeno" name="resposta" value="true">Aceitar</button>
                    <button class="botaoPequeno" name="resposta" value="false">Recusar</button>
                </form>
            </div>
            <br>
        </c:forEach>
    </aside>
    <aside class="sobraEsquerda" id="sairSolicitacoes"</aside>
</div>
