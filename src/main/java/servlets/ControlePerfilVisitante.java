package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorAmizade;
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
@WebServlet(name = "ControlePerfilVisitante", urlPatterns = {"/ControlePerfilVisitante"})
public class ControlePerfilVisitante extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idVisitante = Integer.parseInt(req.getParameter("idDoUsuario"));
        int idUsuario = ((Usuario) req.getSession().getAttribute("user")).getId();
        Usuario visitante = new GerenciadorUsuario().consultarPorId(idVisitante);
        boolean isFriend = new GerenciadorAmizade().isFriend(idUsuario, idVisitante);

        if (isFriend) {
            req.setAttribute("status", "amigo");
        } else {
            boolean isPendente = new GerenciadorAmizade().isPendente(idUsuario, idVisitante);

            if (isPendente) {
                req.setAttribute("status", "pendente");
            } else {
                if (new GerenciadorAmizade().isPendente(idVisitante, idUsuario)) {
                    req.setAttribute("status", "responder");
                } else {
                    req.setAttribute("status", "nada");
                }
            }
        }
        req.getSession().setAttribute("userVisitante", visitante);
        req.getRequestDispatcher("visualizarPerfilVisitante.jsp").forward(req, resp);
    }

}
