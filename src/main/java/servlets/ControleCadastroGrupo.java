package servlets;

import entidades.Grupo;
import entidades.Usuario;
import gerenciador.GerenciadorGrupo;
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
@WebServlet(name = "ControleCadastroGrupo", urlPatterns = {"/ControleCadastroGrupo"})
public class ControleCadastroGrupo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeDoGrupo = req.getParameter("nomeDoGrupo");
        String descricao = req.getParameter("descricao");

        int IdUsuario = ((Usuario) req.getSession().getAttribute("user")).getId();

        GerenciadorGrupo g = new GerenciadorGrupo();

        g.adicionar(new Grupo(IdUsuario, nomeDoGrupo, descricao));
        g.adicionaRelacaoAdmin(IdUsuario, g.retornaMaximo());

        List<Grupo> grupos = new GerenciadorGrupo().retornaGruposDoUsuario(IdUsuario);
        if (!grupos.isEmpty()) {
            req.getSession().setAttribute("grupos", grupos);
        }else{
            req.getSession().setAttribute("grupos", null);
        }

        req.getRequestDispatcher("grupoCadastro.jsp").forward(req, resp);
    }

}
