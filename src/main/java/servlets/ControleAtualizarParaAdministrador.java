package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author dijalma
 */
@WebServlet(name = "ControleAtualizarParaAdministrador", urlPatterns = {"/ControleAtualizarParaAdministrador"})
public class ControleAtualizarParaAdministrador extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Usuario visitante = (Usuario) req.getSession().getAttribute("userVisitante");
        visitante.setTipo(true);
        new GerenciadorUsuario().atualizarParaAdministrador(visitante.getId());
        req.getSession().setAttribute("userVisitante", visitante);
        req.getRequestDispatcher("visualizarPerfilVisitante.jsp").forward(req, resp);
    }
}
