/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorAmizade;
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
@WebServlet(name = "ControleAceitaSolicitacaoPeloPerfilVisitante", urlPatterns = {"/ControleAceitaSolicitacaoPeloPerfilVisitante"})
public class ControleAceitaSolicitacaoPeloPerfilVisitante extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String resposta = req.getParameter("resposta");
        int idUsuario = ((Usuario)req.getSession().getAttribute("user")).getId();
        int idVisitante  = ((Usuario)req.getSession().getAttribute("userVisitante")).getId();
        if (resposta.equals("true")){
            new GerenciadorAmizade().aceitaSolicitacao(idVisitante, idUsuario);
        }else{
            new GerenciadorAmizade().cancelaSolicitacao(idVisitante, idUsuario);
        }
        
        boolean isFriend = new GerenciadorAmizade().isFriend(idUsuario, idVisitante);

        if (isFriend) {
            req.setAttribute("status", "amigo");
        } else {
            boolean isPendente = new GerenciadorAmizade().isPendente(idUsuario, idVisitante);

            if (isPendente) {
                req.setAttribute("status", "pendente");
            } else {
                boolean isWait = new GerenciadorAmizade().isPendente(idVisitante, idUsuario);
                if (isWait) {
                    req.setAttribute("status", "responder");
                } else {
                    req.setAttribute("status", "nada");
                }
            }
        }

        req.getRequestDispatcher("visualizarPerfilVisitante.jsp").forward(req, resp);
    }
    
    
}
