package servlets;

import entidades.Filme;
import entidades.Grupo;
import entidades.Usuario;
import gerenciador.GerenciadorFilme;
import gerenciador.GerenciadorGrupo;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "ControleBuscar", urlPatterns = {"/ControleBuscar"})
public class ControleBuscar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String busca = req.getParameter("busca");
        
        //Busca os usuarios
        List<Usuario> usuarios = null;
        
        Usuario user = ((Usuario) req.getSession().getAttribute("user"));
        
        Usuario u = new GerenciadorUsuario().consultarPorEmail(busca, user.getId());

        if (u == null) {
            usuarios = new GerenciadorUsuario().consultarPorApelido(busca, user.getId());

            if (usuarios.isEmpty()) {
                req.setAttribute("usuariosBuscados", u);
            } else {
                req.setAttribute("usuariosBuscados", usuarios);
            }
        } else {
            usuarios = new ArrayList<>();
            usuarios.add(u);
            req.setAttribute("usuariosBuscados", usuarios);
        }

        
        //Busca os filmes
        List<Filme> filmesBuscados = new GerenciadorFilme().buscaCompletaDeFilme(busca);
        
        if (filmesBuscados.isEmpty()){
            req.setAttribute("filmesBuscados", null);
        }else{
            req.setAttribute("filmesBuscados", filmesBuscados);
        }
        
        //Busca os grupos
        List<Grupo> gruposBuscados = new GerenciadorGrupo().retornaGruposPorNome(busca);
        
        if(gruposBuscados.isEmpty()){
            req.setAttribute("gruposBuscados", null);
        }else{
            req.setAttribute("gruposBuscados", gruposBuscados);
        }
        
        
        req.getRequestDispatcher("verBuscaGeral.jsp").forward(req, resp);
    }

}
