/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Filme;
import entidades.Usuario;
import gerenciador.GerenciadorFilme;
import java.io.IOException;
import java.time.LocalDate;
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
@WebServlet(name = "ControleCadastroFilme", urlPatterns = {"/ControleCadastroFilme"})
public class ControleCadastroFilme extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String titulo = req.getParameter("titulo");
        int ano = Integer.parseInt(req.getParameter("ano"));
        String foto = "imagens/movie.png";
        String atores = req.getParameter("atoresPrincipais");
        String diretores = req.getParameter("diretores");
        String sinopse = req.getParameter("sinopse");
        String generos = req.getParameter("generos");
        LocalDate dataDeCadastro = LocalDate.now();
        int idUser = ((Usuario) req.getSession().getAttribute("user")).getId();

        boolean cadastro = new GerenciadorFilme().adicionar(new Filme(idUser, titulo, ano, sinopse, foto, generos, atores, diretores, dataDeCadastro));

        List<Filme> dezFilmesRecentes = new GerenciadorFilme().buscarDezFilmesRecentes();
        if (!dezFilmesRecentes.isEmpty()) {
            getServletContext().setAttribute("dezFilmesRecentes", dezFilmesRecentes);
        }

        req.setAttribute("cadastrou", cadastro);

        req.getRequestDispatcher("filmeCadastro.jsp").forward(req, resp);
    }

}
