package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorImagem;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author dijalma
 */
@WebServlet(name = "ControleCadastroUsuario", urlPatterns = {"/ControleCadastroUsuario"})
public class ControleCadastroUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (ServletFileUpload.isMultipartContent(req)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> itens;

            try {
                itens = (ArrayList<FileItem>) upload.parseRequest(req);

                //Nome Completo
                String nomeCompleto = itens.get(0).getString();
                //Email
                String email = itens.get(1).getString();
                //Senha
                String senha = itens.get(2).getString();
                //Apelido
                String apelido = itens.get(3).getString();
                //Estado
                String estado = itens.get(4).getString();
                //Cidade
                String cidade = itens.get(5).getString();
                //Data  
                String data = itens.get(6).getString();

                //FotoDePerfil
                String realPath = getServletContext().getRealPath("/imagensPerfil");
                String nomeImagem = apelido;
                String foto;
                if (itens.get(7).getString().equals("")){
                    foto = "imagens/user.png";
                }else{
                    new GerenciadorImagem().inserirImagemPerfil(itens.get(7), realPath, nomeImagem);
                    foto = "imagensPerfil/"+nomeImagem+".jpg";
                }

                Usuario u = new Usuario(email, senha, nomeCompleto, apelido, Date.valueOf(data), cidade, estado, true, foto);
                boolean cadastrou = new GerenciadorUsuario().adicionar(u);

                req.setAttribute("cadastrou", cadastrou);
                req.setAttribute("emailCadastro", email);
                
            } catch (FileUploadException ex) {
                ex.printStackTrace();
            }

        }

        req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
    }

}
