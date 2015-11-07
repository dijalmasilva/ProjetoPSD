<%-- 
    Document   : generos
    Created on : 27/10/2015, 20:48:08
    Author     : dijalma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="generos" class="tab-pane fade text-center">
    <br>
    <h3>Categorias</h3>
    <p>Selecione a categoria do filme.</p>
    <br><br>
    <div class="generosTexto brancoOpaco">
        <form action="ControleFilmesPorCategoria" method="post">
            <ul class="menuNavegacao">
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Ação">Ação                           </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Aventura">Aventura                   </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Animação">Animação                   </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Comédia">Comédia                     </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Documentário">Documentário           </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Drama">Drama                         </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Ficção Científica">Ficção Científica </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Musical">Musical                     </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Nacional">Nacional                   </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Romance">Romance                     </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Terror">Terror                       </button></a></li>
                <li><a><button name="genero" type="submit" class="botaoTransparente" value="Suspense">Suspense                   </button></a></li>
            </ul>
        </form>
    </div>
</div>