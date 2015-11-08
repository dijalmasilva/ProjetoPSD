package servlets;

import entidades.Comentarios;
import entidades.Avaliacao;
import entidades.Filme;
import gerenciador.GerenciadorAvaliacao;
import gerenciador.GerenciadorDeComentarios;
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
@WebServlet (name = "ControleVerFilmeNaoLogado", urlPatterns = {"/ControleVerFilmeNaoLogado"})
public class ControleVerFilmeNaoLogado extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int idFilme =  Integer.parseInt(req.getParameter("idFilmeSelecionado"));
        
        Filme filmeSelecionado = new GerenciadorFilme().buscarFilmePorId(idFilme);
        
        double rating = new GerenciadorFilme().retornaMediaRating(idFilme);
        
        req.getSession().setAttribute("rating", rating);
        req.getSession().setAttribute("filmeSelecionado", filmeSelecionado);
        
        
        req.getRequestDispatcher("verFilmeNaoLogado.jsp").forward(req, resp);
    }
    
    
}
