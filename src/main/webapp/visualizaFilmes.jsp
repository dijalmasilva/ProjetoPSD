<%-- 
    Document   : visualizaFilmes
    Created on : 27/10/2015, 21:00:06
    Author     : dijalma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<div id="feed" class="tab-pane fade text-center">
    <c:forEach items="${applicationScope.dezFilmesRecentes}" var="f">
        <section class="text-center margin-top table-responsive modal-header modal-dialog">
            <br>
            <h2><a href="ControleVerFilme?idFilmeSelecionado=${f.id}">${f.titulo}</a></h2>
            <img src="${f.foto}" alt="${f.titulo}" width="300" height="230" title="${f.titulo}">
            <h5>${f.sinopse}</h5>
            <form action="ControleVerFilme">
                <button class="visible-xs" value="${f.id}" name="idFilmeSelecionado"></button>
                <button type="submit" class="botaoPequeno margin-top">Ver Filme</button>  
            </form>
        </section>
    </c:forEach>
</div>