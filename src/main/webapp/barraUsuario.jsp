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
                    <c:if test="${sessionScope.solicitacoes == null}">
                        <img src="imagens/plus sign1.png" alt="solicitacoes" class="img-perfil" title="Solicitações">
                    </c:if>
                    <c:if test="${sessionScope.solicitacoes != null}">
                        <img src="imagens/plus sign1Red.png" alt="solicitacoes" class="img-perfil" title="Solicitações">
                    </c:if>    
                </a>
                <a href="#" id="notificacoes" class="margin-rigth">
                    <c:if test="${sessionScope.notificacoes == null}">
                        <img class="img-perfil" src="imagens/NotificationIcon.png" alt="notificações" title="Notificações">
                    </c:if>
                    <c:if test="${sessionScope.notificacoes != null}">
                        <img class="img-perfil" src="imagens/NotificationIconRed.png" alt="notificações" title="Notificações">
                    </c:if>
                </a>
                <a href="ControleLogout" class="textoBranco">
                    <img src="imagens/logout12.png" alt="sair" class="img-perfil" title="Sair">
                </a>
            </div>
        </div>
        <br><br><br>
        <div id="menuabaixo">
            <a href="editarPerfil.jsp">Editar Perfil</a><br>
            <a href="configuracoesDeSeguranca.jsp">Cofigurações de Segurança</a>
            <div class="flutuarSomenteAdireita">
                <a href="#" class="textoBranco" id="voltar">
                    <img src="imagens/back.png" alt="voltar" title="Voltar">
                </a>
            </div>
        </div>
    </div> 
</div>
<div class="text-center barraDeNoticiasSolicitacoes textoBranco" id="sol">
    <br>
    <div class="arrow up"></div>
    <form action="ControleAcharUsuarios" method="post">
        <p>Buscar amigo</p>
        <input class="botaoSolicitacoesMedio margin-top" type="text" name="emailOuApelido" placeholder="Digite email ou apelido">
        <input class="botaoSolicitacoesPequeno margin-top" type="submit" value="Procurar">
    </form>
    <div class="table-overflow">
        <c:if test="${sessionScope.solicitacoes == null}">
            <h4>Não há solicitações</h4>
        </c:if>
        <c:forEach items="${sessionScope.solicitacoes}" var="s">
            <br>
            <div class="modal-header table-responsive">
                <form action="ControleAceitaSolicitacao" method="post">
                    <div class="flutuarSomenteAEsquerda">
                        <img src="${s.foto}" alt="${s.apelido}" title="${s.apelido}" class="img-solicitacao">
                    </div>
                    <div class="media-middle">
                        <br>
                        <a href="ControlePerfilVisitante?idDoUsuario=${s.id}" class="text-capitalize active textoBranco">${s.apelido}</a><br>
                        <button type="submit" class="botaoSolicitacoesPequeno" name="resposta" value="true">Aceitar</button>
                        <button type="submit" class="botaoSolicitacoesPequeno" name="resposta" value="false">Cancelar</button>
                    </div>
                        <input name="idDaSolicitacao" value="${s.id}" class="invisible">
                </form>
            </div>
            <br>
        </c:forEach>
    </div>
</div>
<div class="text-center barraDeNoticiasNoticacoes textoBranco" id="not">
    <br>
    <div class="arrow up"></div>
    <c:if test="${sessionScope.notificacoes == null}">
        <h4>Não há notificações</h4>
    </c:if>
    <div class="table-overflow">
        <c:forEach items="${sessionScope.notificacoes}" var="n">
            <br>
            <div class="modal-header table-responsive">

                <div class="flutuarSomenteAEsquerda">
                    <img src="${n.foto}" alt="${n.apelidoUsuario}" title="${n.apelidoUsuario}" class="img-solicitacao">
                </div>
                <br>
                <h4>   
                    <a href="ControlePerfilVisitante?idDoUsuario=${n.idUsuario}" class="text-capitalize active">${n.apelidoUsuario}</a>
                    ${n.mensagem} 
                    <c:if test="${n.idFilme != 0}">
                        <a href="ControleVerFilme?idFilmeSelecionado=${n.idFilme}" class="text-capitalize active textoBranco">${n.nomeFilme}</a>
                    </c:if>

                </h4>
            </div>

        </c:forEach>
    </div>
</div>