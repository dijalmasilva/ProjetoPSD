<%-- 
    Document   : visualizaGrupos
    Created on : 27/10/2015, 20:51:43
    Author     : dijalma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="grupos" class="tab-pane text-center">
    <br>
    <c:if test="${sessionScope.grupos == null}">
        <h3>Você ainda não faz parte de nenhum grupo!</h3>
    </c:if>
    <c:if test="${sessionScope.grupos != null}">
        <h3>Seus grupos!</h3>
    </c:if>
    <br>
    <div class="modal-dialog text-center">
        <a href="#" id="newGroup">Criar novo grupo</a>
    </div>
    <c:forEach items="${sessionScope.grupos}" var="g">
        <section class="text-center margin-top table-responsive modal-header modal-dialog">
            <br>
            <h2><a href="#">${g.nomeDoGrupo}</a></h2>
        </section>
    </c:forEach>
</div>