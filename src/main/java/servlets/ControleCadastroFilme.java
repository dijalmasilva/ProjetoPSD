/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Filme;
import entidades.Usuario;
import gerenciador.GerenciadorFilme;
import gerenciador.GerenciadorImagem;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

        int idUser = ((Usuario) req.getSession().getAttribute("user")).getId();
        
         if (ServletFileUpload.isMultipartContent(req)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> itens;

            try {
                itens = (ArrayList<FileItem>) upload.parseRequest(req);

                //Título
                String titulo = itens.get(0).getString("UTF-8");
                //Ano
                int ano = Integer.parseInt(itens.get(1).getString("UTF-8"));
                //Gêneros
                String generos = itens.get(2).getString("UTF-8");
                //Atores Principais
                String atores = itens.get(3).getString("UTF-8");
                //Diretores
                String diretores = itens.get(4).getString("UTF-8");
                //Sinopse
                String sinopse = itens.get(5).getString("UTF-8");
                //Data de Cadastro
                LocalDate dataDeCadastro = LocalDate.now();
                
                //Foto do Filme
                String realPath = getServletContext().getRealPath("/imagensFilme");
                String nomeImagem = titulo;
                String foto;
                if (itens.get(6).getString().equals("")){
                    foto = "imagens/movie.png";
                }else{
                    new GerenciadorImagem().inserirImagemPerfil(itens.get(6), realPath, nomeImagem);
                    foto = "imagensFilme/"+nomeImagem+".jpg";
                }

                boolean cadastro = new GerenciadorFilme().adicionar(new Filme(idUser, titulo, ano, sinopse, foto, generos, atores, diretores, dataDeCadastro));
                
                List<Filme> dezFilmesRecentes = new GerenciadorFilme().buscarDezFilmesRecentes();
                if (!dezFilmesRecentes.isEmpty()) {
                    getServletContext().setAttribute("dezFilmesRecentes", dezFilmesRecentes);
                }

                req.setAttribute("cadastrou", cadastro);
                
            } catch (FileUploadException ex) {
                ex.printStackTrace();
            }

        }
         
        req.getRequestDispatcher("filmeCadastro.jsp").forward(req, resp);
    }

}
