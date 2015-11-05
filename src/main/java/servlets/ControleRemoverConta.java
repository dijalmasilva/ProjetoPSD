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
@WebServlet(name = "ControleRemoverConta", urlPatterns = {"/ControleRemoverConta"})
public class ControleRemoverConta extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Usuario u = ((Usuario) req.getSession().getAttribute("user"));
        
        boolean excluiu = new GerenciadorUsuario().remover(u.getId());
        
        if (excluiu){
            req.getSession().invalidate();
            resp.sendRedirect("index.html");
        }else{
            req.getRequestDispatcher("configuracoesDeSeguranca.jsp").forward(req, resp);
        }
            
        
    }
    
    
}
