
package servlets;

import entidades.Filme;
import gerenciador.GerenciadorFilme;
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
@WebServlet(name = "ControleFilmesPorCategoria", urlPatterns = {"/ControleFilmesPorCategoria"})
public class ControleFilmesPorCategoria extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        String genero = req.getParameter("genero");
        
        List<Filme> filmesDeCategoria = new GerenciadorFilme().buscarFilmesPorGeneros(genero);
        
        if(!filmesDeCategoria.isEmpty())
            req.setAttribute("filmesDeCategoria", filmesDeCategoria);
        else
            req.setAttribute("filmesDeCategoria", null);
        
        req.getRequestDispatcher("filmesPorCategoria.jsp").forward(req, resp);
    }
    
    
}
