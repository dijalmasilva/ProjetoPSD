package servlets;

import entidades.Filme;
import entidades.Usuario;
import gerenciador.GerenciadorFilme;
import gerenciador.GerenciadorUsuario;
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
        
        List<Filme> dezFilmesRecentes = new GerenciadorFilme().buscarDezFilmesRecentes();
            if (!dezFilmesRecentes.isEmpty()) {
                getServletContext().setAttribute("dezFilmesRecentes", dezFilmesRecentes);
            }else{
                getServletContext().setAttribute("dezFilmesRecentes", null);
            }
        
        if (excluiu){
            req.getSession().invalidate();
            resp.sendRedirect("index.html");
        }else{
            req.getRequestDispatcher("configuracoesDeSeguranca.jsp").forward(req, resp);
        }
            
        
    }
    
    
}
