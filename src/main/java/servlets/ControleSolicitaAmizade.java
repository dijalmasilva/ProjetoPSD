package servlets;

import entidades.Solicitacao;
import entidades.Usuario;
import gerenciador.GerenciadorAmizade;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ControleSolicitaAmizade", urlPatterns = {"/ControleSolicitaAmizade"})
public class ControleSolicitaAmizade extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idUsuarioE = ((Usuario) req.getSession().getAttribute("user")).getId();
        int idUsuarioR = ((Usuario) req.getSession().getAttribute("userVisitante")).getId();

        new GerenciadorAmizade().solicitaAmizade(idUsuarioE, idUsuarioR);
        boolean isFriend = new GerenciadorAmizade().isFriend(idUsuarioE, idUsuarioR);

        if (isFriend) {
            req.setAttribute("status", "amigo");
        } else {
            boolean isPendente = new GerenciadorAmizade().isPendente(idUsuarioE, idUsuarioR);

            if (isPendente) {
                req.setAttribute("status", "pendente");
            } else {
                boolean isWait = new GerenciadorAmizade().isPendente(idUsuarioR, idUsuarioE);
                if (isWait) {
                    req.setAttribute("status", "responder");
                } else {
                    req.setAttribute("status", "nada");
                }
            }
        }

        List<Solicitacao> solicitacoes = new GerenciadorAmizade().retornaSolicitacoes(idUsuarioE);

        if (!solicitacoes.isEmpty()) {
            req.getSession().setAttribute("solicitacoes", solicitacoes);
        }else{
            req.getSession().setAttribute("solicitacoes", null);
        }

        req.getRequestDispatcher("visualizarPerfilVisitante.jsp").forward(req, resp);
    }

}
