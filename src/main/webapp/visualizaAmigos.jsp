<%-- 
    Document   : visualizaAmigos
    Created on : 27/10/2015, 21:03:22
    Author     : dijalma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="amigos" class="tab-pane fade text-center">
    <c:if test="${sessionScope.friends == null}">
        <br>
        <h2>Você ainda não tem amigos!</h2>
        <p class="margin-top">Adicione agora alguns amigos.</p>
        <form action="ControleAcharUsuarios" method="post">
            <input class="botaoMedio margin-top" type="text" name="emailOuApelido" placeholder="Digite email ou apelido">
            <input class="botaoPequeno margin-top" type="submit" value="Procurar">
        </form>
    </c:if>
    <c:if test="${sessionScope.friends != null}">
        <br>
        <h2>Amigos</h2>
    </c:if>
</div>
