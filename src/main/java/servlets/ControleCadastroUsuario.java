package servlets;

import entidades.Usuario;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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

        req.setCharacterEncoding("UTF-8");

        JOptionPane.showMessageDialog(null, req.getParameter("imagem"));
        
//        String nomeCompleto = req.getParameter("nomeCompleto");
//        String apelido = req.getParameter("apelido");
//        String senha = req.getParameter("senhaCadastro");
//        String email = req.getParameter("emailCadastro");
//        String data = req.getParameter("dataDeNascimento");
//        String estado = req.getParameter("estado");
//        String cidade = req.getParameter("cidade");
//        String foto = "imagens/user.png";
//
//        Usuario u = new Usuario(email, senha, nomeCompleto, apelido, Date.valueOf(data), cidade, estado, true, foto);
//        boolean cadastrou = new GerenciadorUsuario().adicionar(u);
//        
//        req.setAttribute("cadastrou", cadastrou);
//        req.setAttribute("emailCadastro", email);

        req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
    }

}
