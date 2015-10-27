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
@WebServlet(name = "ControleAtualizarPerfil", urlPatterns = {"/ControleAtualizarPerfil"})
public class ControleAtualizarPerfil extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        
        user.setApelido(req.getParameter("apelido"));
        user.setNome(req.getParameter("nomeCompleto"));
        user.setCidade(req.getParameter("cidade"));
        user.setEstado(req.getParameter("estado"));
        
        new GerenciadorUsuario().alterar(user);
        
        req.getRequestDispatcher("editarPerfil.jsp").forward(req, resp);
    }
    
    
}
