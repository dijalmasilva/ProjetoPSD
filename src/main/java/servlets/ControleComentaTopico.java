package servlets;

import entidades.ComentarioTopico;
import entidades.Comentarios;
import entidades.Topico;
import entidades.Usuario;
import gerenciador.GerenciadorComentarioTopico;
import gerenciador.GerenciadorDeComentarios;
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
@WebServlet(name = "ControleComentaTopico", urlPatterns = {"/ControleComentaTopico"})
public class ControleComentaTopico extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String comentario = req.getParameter("comentario");
        int idUsuario = ((Usuario)req.getSession().getAttribute("user")).getId();
        int idTopico = ((Topico)req.getSession().getAttribute("topicoSelecionado")).getId();
        
        ComentarioTopico c = new ComentarioTopico(idTopico, comentario, idUsuario);
        
        
        if (new GerenciadorComentarioTopico().adicionar(c)){
            req.getSession().setAttribute("retorno", "Comentário realizado!");
        }else{
            req.getSession().setAttribute("retorno", "Erro ao comentar!");
        }
        
        List<ComentarioTopico> ct = new GerenciadorComentarioTopico().consultarPorIdTopico(idTopico);
        List<Comentarios> comentarios = new GerenciadorDeComentarios().retornaComentariosDeTopico(ct);
        
        if(!comentarios.isEmpty()){
            req.getSession().setAttribute("comentariosTopicos", comentarios);
        }else{
            req.getSession().setAttribute("comentariosTopicos", null);
        }
        
        resp.sendRedirect("verTopico.jsp");
        
    }
    
    
}
