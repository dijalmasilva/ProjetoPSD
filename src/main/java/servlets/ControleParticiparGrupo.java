package servlets;

import entidades.Grupo;
import entidades.Usuario;
import gerenciador.GerenciadorGrupo;
import gerenciador.GerenciadorParticipaGrupo;
import java.io.IOException;
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
@WebServlet(name = "ControleParticiparGrupo", urlPatterns = {"/ControleParticiparGrupo"})
public class ControleParticiparGrupo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idGrupo = ((Grupo) req.getSession().getAttribute("grupoSelecionado")).getId();
        int idUsuario = ((Usuario) req.getSession().getAttribute("user")).getId();

        req.getSession().setAttribute("participa", new GerenciadorParticipaGrupo().adicionaRelacao(idUsuario, idGrupo));

        List<Usuario> usuariosDoGrupo = new GerenciadorParticipaGrupo().retornaUsuariosDeUmGrupo(idGrupo);
        if (!usuariosDoGrupo.isEmpty()) {
            req.getSession().setAttribute("usuariosDoGrupo", usuariosDoGrupo);
        } else {
            req.getSession().setAttribute("usuariosDoGrupo", null);
        }

        List<Grupo> grupos = new GerenciadorGrupo().retornaGruposDoUsuario(idUsuario);
        if (!grupos.isEmpty()) {
            req.getSession().setAttribute("grupos", grupos);
        } else {
            req.getSession().setAttribute("grupos", null);
        }

        req.getRequestDispatcher("verGrupo.jsp").forward(req, resp);
    }

}
