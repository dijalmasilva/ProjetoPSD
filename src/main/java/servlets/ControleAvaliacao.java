package servlets;

import entidades.Avaliacao;
import entidades.Filme;
import entidades.Usuario;
import gerenciador.GerenciadorAvaliacao;
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
@WebServlet(name="ControleAvaliacao", urlPatterns = {"/ControleAvaliacao"})
public class ControleAvaliacao extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int rating = Integer.parseInt(req.getParameter("rating"));
        String comentario = req.getParameter("comentario");
        int idUsuario = ((Usuario) req.getSession().getAttribute("user")).getId();
        int idFilme = ((Filme) req.getSession().getAttribute("filmeSelecionado")).getId();
        String retorno = "";
        if (new GerenciadorAvaliacao().adicionar(new Avaliacao(idUsuario, idFilme, rating, comentario))){
            retorno = "Avaliação realizada!";
        }else{
            retorno = "Você já avaliou esse filme!";
        }
        
        List<Avaliacao> avaliacoes = new GerenciadorAvaliacao().consultarPorIdDoFilme(idFilme);
        req.setAttribute("avaliacoes", avaliacoes);        
        req.setAttribute("rating", rating);
        req.setAttribute("retorno", retorno);
        req.getRequestDispatcher("verFilme.jsp").forward(req, resp);
    }
    
    
}
