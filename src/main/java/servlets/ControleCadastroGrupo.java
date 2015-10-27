package servlets;

import entidades.Grupo;
import entidades.Usuario;
import gerenciador.GerenciadorGrupo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dijalma
 */
public class ControleCadastroGrupo extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String nomeDoGrupo = req.getParameter("nomeDoGrupo");
        String descricao = req.getParameter("descricao");
        
        int IdUsuario = ((Usuario) req.getSession().getAttribute("user")).getId();
        
        boolean cadastrou = new GerenciadorGrupo().adicionar(new Grupo(IdUsuario, nomeDoGrupo, descricao));
        
        req.getRequestDispatcher("grupoCadastro.jsp").forward(req, resp);
        
    }
    
    
}
