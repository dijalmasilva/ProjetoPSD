package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dijalma
 */
@WebServlet(name = "ControlePerfilVisitante", urlPatterns = {"/ControlePerfilVisitante"})
public class ControlePerfilVisitante extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("idDoUsuario"));
        Usuario visitante = new GerenciadorUsuario().consultarPorId(id);
        req.getSession().setAttribute("userVisitante", visitante);
        req.getRequestDispatcher("visualizarPerfilVisitante.jsp").forward(req, resp);
    }
    
}
