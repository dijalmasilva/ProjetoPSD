<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <%@include file="head.jsp" %>
    <body  id="fundo" class="textoPreto white-background">
        <%@include file="barraUsuario.jsp"%>
        <%@include file="grupos.jsp" %>
        <div class="margin-top-body">
            <div class="container nav-justified">
                <a href="logado.jsp"><h1 class="text-center textoPreto">Social Movies</h1></a>
                <br>    
                <ul class="nav nav-tabs navbar-static-top" id="menuNav">
                    <li class="active"><a data-toggle="tab" href="#topicos">Grupo</a></li>
                    <li><a data-toggle="tab" href="#participantes">Usuarios</a></li>
                    <li><a data-toggle="tab" href="#criar">Criar tópico</a></li>
                        <c:if test="${participa == true}">
                        <li><a data-toggle="tab" href="#participar">Participar</a></li>
                        </c:if>
                    <li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
                </ul>

                <div class="tab-content">
                    <div id="topicos" class="tab-pane fade text-center in active">
                        <section class="text-center margin-top table-responsive modal-header modal-dialog">
                            <h2><a>${grupoSelecionado.nomeDoGrupo}</a></h2>
                            <p>${grupoSelecionado.descricao}</p>
                            <br>
                            <div class="table-overflow-comentarios">
                                <c:forEach items="${topicos}">
                                    
                                </c:forEach>
                            </div>
                        </section>
                    </div>
                    <div id="participantes" class="tab-pane fade text-center">
                        <div class="text-center margin-top table-responsive modal-header modal-dialog">
                            <div class="row">
                                <c:forEach items="${usuariosDoGrupo}">
                                    <div class="col-sm-4">
                                        <img src="" alt="" title="" class="img-solicitacao">
                                        <h4>Nome</h4>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div id="criar" class="tab-pane fade text-center">
                        <div class="text-center margin-top table-responsive modal-header modal-dialog">
                            <br>
                            <h3>Criar novo tópico</h3>
                            <br>
                            <div class="form-group">
                                <form action="ControleCriarTopico" method="post">
                                    <input class="botaoMedio margin-top" name="nomeDoTopico" type="text" placeholder="Nome do tópico">
                                    <input class="botaoMedio margin-top" name="nomeDoFilme" type="text" placeholder="Nome do Filme">
                                    <input class="botaoPequeno margin-top" type="submit" value="Criar">
                                </form>
                            </div>
                        </div>
                    </div>
                    <c:if test="${participa == true}">
                        <div id="participar" class="text-center fade">
                            <br>
                            <h3>Deseja participar deste grupo?</h3>
                            <div class="form-group modal-header modal-dialog">
                                <form action="ControleParticiparGrupo" method="post">
                                    <input type="submit" value="Participar" class="botaoPequeno margin-top">
                                </form>
                            </div>
                        </div>
                    </c:if>        
                    <%@include file="search.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>