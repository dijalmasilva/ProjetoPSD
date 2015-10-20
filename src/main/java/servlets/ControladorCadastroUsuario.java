/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dijalma
 */
public class ControladorCadastroUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String nomeCompleto = request.getParameter("nomeCompleto");
        String senha = request.getParameter("senhaCadastro");
        String email = request.getParameter("emailCadastro");
        String apelido = request.getParameter("apelido");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String foto = request.getParameter("imagens/user.png");
        String data = request.getParameter("data");
        
        String[] s = data.split("/");
        
        int day = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int year = Integer.parseInt(s[2]);
        
        Usuario u = new Usuario(1, senha, nomeCompleto, apelido, new Date(year, month, day), cidade, estado, false, foto);
        new GerenciadorUsuario().adicionar(u);
        
        RequestDispatcher d = request.getRequestDispatcher("/jsp/cadastro.jsp");
        d.forward(request, response); 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
