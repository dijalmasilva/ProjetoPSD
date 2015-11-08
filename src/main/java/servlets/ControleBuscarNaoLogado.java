package servlets;

import entidades.Filme;
import gerenciador.GerenciadorFilme;
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
@WebServlet(name = "ControleBuscarNaoLogado", urlPatterns = {"/ControleBuscarNaoLogado"})
public class ControleBuscarNaoLogado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String busca = req.getParameter("busca");

        //Busca os filmes
        List<Filme> filmesBuscados = new GerenciadorFilme().buscaCompletaDeFilme(busca);

        if (filmesBuscados.isEmpty()) {
            req.setAttribute("filmesBuscados", null);
        } else {
            req.setAttribute("filmesBuscados", filmesBuscados);
        }

        List<Filme> dezFilmesRecentes = new GerenciadorFilme().buscarDezFilmesRecentes();
        if (!dezFilmesRecentes.isEmpty()) {
            getServletContext().setAttribute("dezFilmesRecentes", dezFilmesRecentes);
        }

        req.getRequestDispatcher("verBuscaGeralSemLogar.jsp").forward(req, resp);
    }

}
