package servlets;

import entidades.Notificacoes;
import entidades.Usuario;
import gerenciador.GerenciadorNotificacao;
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
        
        Notificacoes n = new Notificacoes();
        n.setIdAmigo(visitante.getId());
        n.setIdUsuario(((Usuario)req.getSession().getAttribute("user")).getId());
        n.setMensagem("tornou você um administrador!");
        new GerenciadorNotificacao().adicionarGeral(n);
        
        req.getRequestDispatcher("visualizarPerfilVisitante.jsp").forward(req, resp);
    }
}
