package servlets;

import entidades.ComentarioTopico;
import entidades.Comentarios;
import entidades.Topico;
import gerenciador.GerenciadorComentarioTopico;
import gerenciador.GerenciadorDeComentarios;
import gerenciador.GerenciadorTopico;
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
@WebServlet(name = "ControleVerTopico", urlPatterns = {"/ControleVerTopico"})
public class ControleVerTopico extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);  
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int idTopico = Integer.parseInt(req.getParameter("idTopico"));
        
        Topico topicoSelecionado = new GerenciadorTopico().consultarPorId(idTopico);
        String nomeUsuario = new GerenciadorUsuario().retornaApelidoPeloId(topicoSelecionado.getIdUsuario());
        
        List<ComentarioTopico> ct = new GerenciadorComentarioTopico().consultarPorIdTopico(idTopico);
        List<Comentarios> comentarios = new GerenciadorDeComentarios().retornaComentariosDeTopico(ct);
        
        if(!comentarios.isEmpty()){
            req.getSession().setAttribute("comentariosTopicos", comentarios);
        }else{
            req.getSession().setAttribute("comentariosTopicos", null);
        }
        
        req.getSession().setAttribute("nomeUsuario", nomeUsuario);
        req.getSession().setAttribute("topicoSelecionado", topicoSelecionado);
        
        req.getRequestDispatcher("verTopico.jsp").forward(req, resp);
        
    }
    
    
}
