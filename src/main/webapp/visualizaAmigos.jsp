<%-- 
    Document   : visualizaAmigos
    Created on : 27/10/2015, 21:03:22
    Author     : dijalma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="amigos" class="tab-pane fade text-center">
    <c:if test="${sessionScope.amigos == null}">
        <br>
        <h2>Você ainda não tem amigos!</h2>
        <p class="margin-top">Adicione agora alguns amigos.</p>
        <form action="ControleAcharUsuarios" method="post">
            <input class="botaoMedio margin-top" type="text" name="emailOuApelido" placeholder="Digite email ou apelido">
            <input class="botaoPequeno margin-top" type="submit" value="Procurar">
        </form>
    </c:if>
    <c:if test="${sessionScope.amigos != null}">
        <br>
        <h2>Amigos</h2>
        <br><br><br><br><br>
        <div class="row media-list">
            <c:forEach items="${sessionScope.amigos}" var="a" varStatus="status">
                <div class="col-sm-3 modal-header">
                    <img src="${a.foto}" alt="${a.apelido}" title="${a.apelido}" class="img-solicitacao img-circle">
                    <h3><a href="ControlePerfilVisitante?idDoUsuario=${a.id}" class="text-capitalize active">${a.apelido}</a></h3>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
