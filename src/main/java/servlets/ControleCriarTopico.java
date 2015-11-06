package servlets;

import entidades.Grupo;
import entidades.Topico;
import entidades.Usuario;
import gerenciador.GerenciadorFilme;
import gerenciador.GerenciadorTopico;
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
@WebServlet(name = "ControleCriarTopico", urlPatterns = {"/ControleCriarTopico"})
public class ControleCriarTopico extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String nomeDoTopico = req.getParameter("nomeDoTopico");
        String nomeDoFilme = req.getParameter("nomeDoFilme");
        int idFilme = new GerenciadorFilme().retornaIdDoFilmePeloNome(nomeDoFilme);
        int idUsuario = ((Usuario) req.getSession().getAttribute("user")).getId();
        int idGrupo = ((Grupo) req.getSession().getAttribute("grupoSelecionado")).getId();
        
        new GerenciadorTopico().adicionar(new Topico(idUsuario, idFilme, idGrupo, nomeDoTopico));
        
        List<Topico> topicos = new GerenciadorTopico().consultarPorIdDoGrupo(idGrupo);
        if (!topicos.isEmpty()){
            req.getSession().setAttribute("topicos", topicos);
        }else{
            req.getSession().setAttribute("topicos", null);
        }
        
        
        req.getRequestDispatcher("verGrupo.jsp").forward(req, resp);
    }
    
    
}
