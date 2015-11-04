/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorAmizade;
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
@WebServlet(name = "ControleAchaUsuario", urlPatterns = {"/ControleAchaUsuario"})
public class ControleAchaUsuario extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);  
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String emailOuApelido = req.getParameter("emailOuApelido");
        List<Usuario> amigos = (ArrayList<Usuario>) req.getSession().getAttribute("amigos");
        
        Usuario amigoEncontrado = new GerenciadorAmizade().buscarEmAmigosPorApelido(amigos, emailOuApelido);
        
        if (amigoEncontrado == null){
            amigoEncontrado = new GerenciadorAmizade().buscarEmAmigosPorEmail(amigos, emailOuApelido);   
        }
        
        req.setAttribute("amigoEncontrado", amigoEncontrado);
        
        req.getRequestDispatcher("filmeRecomendado.jsp").forward(req, resp);
    }
    
    
}
