<%-- 
    Document   : visualizaGrupos
    Created on : 27/10/2015, 20:51:43
    Author     : dijalma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="row">
        <c:forEach items="${sessionScope.grupos}" var="g">
            <div class="col-sm-3 modal-header">
                <br>
                <h2><a href="ControleVerGrupo?idGrupo=${g.id}">${g.nomeDoGrupo}</a></h2>
            </div>
        </c:forEach>
    </div>
</div>