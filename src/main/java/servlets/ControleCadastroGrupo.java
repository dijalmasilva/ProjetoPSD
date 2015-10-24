/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        if (!cadastrou){
            req.getRequestDispatcher("grupoCadastroErro.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("grupoCadastro.jsp").forward(req, resp);
        }
    }
    
    
}
