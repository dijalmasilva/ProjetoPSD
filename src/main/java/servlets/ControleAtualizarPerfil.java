package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorImagem;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
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
@WebServlet(name = "ControleAtualizarPerfil", urlPatterns = {"/ControleAtualizarPerfil"})
public class ControleAtualizarPerfil extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        
        if (ServletFileUpload.isMultipartContent(req)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            List<FileItem> itens;
            
            try {
                itens = (ArrayList<FileItem>) upload.parseRequest(req);

                //Nome Completo
                user.setNome(itens.get(0).getString());
                //Apelido
                user.setApelido(itens.get(1).getString());
                //Estado
                user.setEstado(itens.get(2).getString());
                //Cidade
                user.setCidade(itens.get(3).getString());

                //FotoDePerfil
                String realPath = getServletContext().getRealPath("/imagensPerfil");
                String nomeImagem = user.getApelido();
                String foto = user.getFoto();
                if (!itens.get(4).getString().equals("")) {
                    new GerenciadorImagem().inserirImagemPerfil(itens.get(4), realPath, nomeImagem);
                    foto = "imagensPerfil/" + nomeImagem + ".jpg";                
                }
                
                user.setFoto(foto);
                
                new GerenciadorUsuario().alterar(user);
                
            } catch (FileUploadException ex) {
                ex.printStackTrace();
            }
            
        }
        
        req.getRequestDispatcher("editarPerfil.jsp").forward(req, resp);
    }
    
}
