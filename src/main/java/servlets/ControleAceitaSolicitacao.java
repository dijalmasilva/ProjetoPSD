/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Solicitacao;
import entidades.Usuario;
import gerenciador.GerenciadorAmizade;
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
@WebServlet(name = "ControleAceitaSolicitacao", urlPatterns = {"/ControleAceitaSolicitacao"})
public class ControleAceitaSolicitacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String resposta = req.getParameter("resposta");
        int idVisitante = Integer.parseInt(req.getParameter("idDaSolicitacao"));
        int idUsuario = ((Usuario) req.getSession().getAttribute("user")).getId();
        if (resposta.equals("true")) {
            new GerenciadorAmizade().aceitaSolicitacao(idVisitante, idUsuario);
        } else {
            new GerenciadorAmizade().cancelaSolicitacao(idUsuario, idVisitante);
        }

        List<Solicitacao> solicitacoes = new GerenciadorAmizade().retornaSolicitacoes(idUsuario);
        if (!solicitacoes.isEmpty()) {
            req.getSession().setAttribute("solicitacoes", solicitacoes);
        } else {
            req.getSession().setAttribute("solicitacoes", null);
        }

        List<Usuario> amigos = new GerenciadorUtilitario().recuperaAmigos(idUsuario);
        if (!amigos.isEmpty()) {
            req.getSession().setAttribute("amigos", amigos);
        } else {
            req.getSession().setAttribute("amigos", null);
        }

        req.getRequestDispatcher("logado.jsp").forward(req, resp);
    }

}
