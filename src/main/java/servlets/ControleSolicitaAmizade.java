package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorAmizade;
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
@WebServlet(name = "ControleSolicitaAmizade", urlPatterns = {"/ControleSolicitaAmizade"})
public class ControleSolicitaAmizade extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int idUsuarioE = ((Usuario)req.getSession().getAttribute("user")).getId();
        int idUsuarioR = ((Usuario)req.getSession().getAttribute("userVisitante")).getId();
        
        new GerenciadorAmizade().solicitaAmizade(idUsuarioE, idUsuarioR);
        
        req.getRequestDispatcher("ControlePerfilVisitante").forward(req, resp);
    }
    
    
}
