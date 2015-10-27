/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorGrupo;
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
            if (!new GerenciadorGrupo().retornaGruposDoUsuario(u.getId()).isEmpty()) {
                req.getSession().setAttribute("grupos", new GerenciadorGrupo().retornaGruposDoUsuario(u.getId()));
            }
            req.getRequestDispatcher("logado.jsp").forward(req, resp);
        }
    }

}
