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
@WebServlet (name = "ControleVerFilme", urlPatterns = {"/ControleVerFilme"})
public class ControleVerFilme extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int idFilme =  Integer.parseInt(req.getParameter("idFilmeSelecionado"));
        
        Filme filmeSelecionado = new GerenciadorFilme().buscarFilmePorId(idFilme);
        String usuarioDeCadastro = new GerenciadorUsuario().retornaApelidoPeloId(filmeSelecionado.getIdUser());
        
        List<Avaliacao> a = new GerenciadorAvaliacao().consultarPorIdDoFilme(idFilme);
        List<Comentarios> avaliacoes = new GerenciadorDeComentarios().retornaComentariosDeAvaliacao(a);
        
        req.setAttribute("avaliacoes", avaliacoes);        
        req.getSession().setAttribute("filmeSelecionado", filmeSelecionado);
        req.getSession().setAttribute("usuarioDeCadastro", usuarioDeCadastro);
        
        req.getRequestDispatcher("verFilme.jsp").forward(req, resp);
    }
    
    
}
