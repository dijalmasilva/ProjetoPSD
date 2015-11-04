/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Filme;
import entidades.Notificacoes;
import entidades.Usuario;
import gerenciador.GerenciadorNotificacao;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dijalma
 */
@WebServlet(name = "ControleRecomendaFilme", urlPatterns = {"/ControleRecomendaFilme"})
public class ControleRecomendaFilme extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);  
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int idUsuario = ((Usuario)req.getSession().getAttribute("user")).getId();
        int idAmigo = Integer.parseInt(req.getParameter("idUsuario"));
        int idFilme = ((Filme)req.getSession().getAttribute("filmeSelecionado")).getId();
        
        Notificacoes n = new Notificacoes();
        n.setFoto(new GerenciadorUsuario().retornaFotoPeloId(idAmigo));
        n.setIdAmigo(idAmigo);
        n.setIdFilme(idFilme);
        n.setIdUsuario(idUsuario);
        
        boolean recomendou = new GerenciadorNotificacao().adicionarRecomendacao(n);
        
        req.setAttribute("recomendou", recomendou);
        req.getRequestDispatcher("filmeRecomendado.jsp").forward(req, resp);
    }
    
    
}
