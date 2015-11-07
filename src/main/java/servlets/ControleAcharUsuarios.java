package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorUsuario;
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
@WebServlet(name = "ControleAcharUsuarios", urlPatterns = {"/ControleAcharUsuarios"})
public class ControleAcharUsuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = null;

        Usuario user = ((Usuario) req.getSession().getAttribute("user"));
        
        Usuario u = new GerenciadorUsuario().consultarPorEmail(req.getParameter("emailOuApelido"), user.getId());

        if (u == null) {
            usuarios = new GerenciadorUsuario().consultarPorApelido(req.getParameter("emailOuApelido"), user.getId());

            if (usuarios.isEmpty()) {
                req.setAttribute("usuariosAchados", u);
            } else {
                req.setAttribute("usuariosAchados", usuarios);
            }
        } else {
            usuarios = new ArrayList<>();
            usuarios.add(u);
            req.setAttribute("usuariosAchados", usuarios);
        }

        req.getRequestDispatcher("BuscaDeUsuarios.jsp").forward(req, resp);
    }

}
