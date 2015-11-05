package servlets;

import entidades.Grupo;
import entidades.Usuario;
import gerenciador.GerenciadorFilme;
import gerenciador.GerenciadorGrupo;
import gerenciador.GerenciadorParticipaGrupo;
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
@WebServlet(name = "ControleVerGrupo", urlPatterns = {"/ControleVerGrupo"})
public class ControleVerGrupo extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);  
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int idGrupo = Integer.parseInt(req.getParameter("idGrupo"));
        
        Grupo g = new GerenciadorGrupo().consultarPorId(idGrupo);
        int idUsuario = ((Usuario) req.getSession().getAttribute("user")).getId();
        
        List<Usuario> usuariosDoGrupo = new GerenciadorParticipaGrupo().retornaUsuariosDeUmGrupo(idGrupo);
        List<String> nomeDosFilmes = new GerenciadorFilme().retornaTodosOsFilmes();
        
        req.getSession().setAttribute("grupoSelecionado", g);
        req.setAttribute("nomeDosFilmes", nomeDosFilmes);
        req.getSession().setAttribute("usuariosDoGrupo", usuariosDoGrupo);
        req.getSession().setAttribute("participa", new GerenciadorParticipaGrupo().isParticipa(idUsuario, idGrupo));
        req.getRequestDispatcher("verGrupo.jsp").forward(req, resp);
    }
    
    
}
