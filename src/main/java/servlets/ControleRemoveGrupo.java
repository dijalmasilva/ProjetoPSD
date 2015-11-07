package servlets;

import entidades.Grupo;
import entidades.Notificacoes;
import entidades.Usuario;
import gerenciador.GerenciadorGrupo;
import gerenciador.GerenciadorNotificacao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dijalma
 */
@WebServlet(name = "ControleRemoveGrupo", urlPatterns = {"/ControleRemoveGrupo"})
public class ControleRemoveGrupo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Grupo g = (Grupo) req.getSession().getAttribute("grupoSelecionado");
        List<Usuario> participantes = (ArrayList<Usuario>) req.getSession().getAttribute("usuariosDoGrupo");
        new GerenciadorGrupo().remover(g.getId());
        new GerenciadorNotificacao().notificacaoDeGrupoRemovido(g.getIdUsuario(), participantes, g.getNomeDoGrupo());
        req.getSession().setAttribute("grupos", new GerenciadorGrupo().retornaGruposDoUsuario(g.getIdUsuario()));
        
        resp.sendRedirect("grupoCadastro.jsp");
    }

}
