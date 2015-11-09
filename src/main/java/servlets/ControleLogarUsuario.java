package servlets;

import entidades.Notificacoes;
import entidades.Solicitacao;
import entidades.Filme;
import entidades.Grupo;
import entidades.Usuario;
import gerenciador.GerenciadorAmizade;
import gerenciador.GerenciadorFilme;
import gerenciador.GerenciadorGrupo;
import gerenciador.GerenciadorNotificacao;
import gerenciador.GerenciadorUsuario;
import gerenciador.GerenciadorUtilitario;
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
@WebServlet(name = "ControleLogarUsuario", urlPatterns = {"/ControleLogarUsuario"})
public class ControleLogarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("emailLogin");
        String senha = req.getParameter("senhaLogin");

        Usuario u = new GerenciadorUsuario().login(email, senha);
        if (u == null) {
            req.getRequestDispatcher("loginInvalido.jsp").forward(req, resp);
        } else {

            req.getSession().setAttribute("user", u);
            

            List<Filme> dezFilmesRecentes = new GerenciadorFilme().buscarDezFilmesRecentes();
            if (!dezFilmesRecentes.isEmpty()) {
                getServletContext().setAttribute("dezFilmesRecentes", dezFilmesRecentes);
            }else{
                getServletContext().setAttribute("dezFilmesRecentes", null);
            }

            List<Grupo> grupos = new GerenciadorGrupo().retornaGruposDoUsuario(u.getId());
            if (!grupos.isEmpty()) {
                req.getSession().setAttribute("grupos", grupos);
            }else{
                req.getSession().setAttribute("grupos", null);
            }

            List<Usuario> amigos = new GerenciadorUtilitario().recuperaAmigos(u.getId());
            if (!amigos.isEmpty()) {
                req.getSession().setAttribute("amigos", amigos);
            }else{
                req.getSession().setAttribute("amigos", null);
            }

            List<Solicitacao> solicitacoes = new GerenciadorAmizade().retornaSolicitacoes(u.getId());
            if (!solicitacoes.isEmpty()) {
                req.getSession().setAttribute("solicitacoes", solicitacoes);
            }else{
                req.getSession().setAttribute("solicitacoes", null);
            }

            List<Notificacoes> notificacoes = new GerenciadorNotificacao().recuperar20NotificacoesRecentes(u.getId());
            if (!notificacoes.isEmpty()){
                req.getSession().setAttribute("notificacoes", notificacoes);
            }else{
                req.getSession().setAttribute("notificacoes", null);
            }
            
            req.getRequestDispatcher("logado.jsp").forward(req, resp);
        }
    }

}
