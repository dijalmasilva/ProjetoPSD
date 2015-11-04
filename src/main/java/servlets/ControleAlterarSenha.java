package servlets;

import entidades.Usuario;
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
@WebServlet(name = "ControleAlterarSenha", urlPatterns = {"/ControleAlterarSenha"})
public class ControleAlterarSenha extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String retorno = "";
        String senhaAntiga = req.getParameter("senhaAntiga");
        String senhaNova = req.getParameter("senhaNova");
        
        Usuario user = ((Usuario) req.getSession().getAttribute("user")); 
        
        if (!senhaAntiga.equals(user.getSenha())){
            retorno = "Senha atual incorreta";
        }else{
            if(senhaAntiga.equals(senhaNova)){
                retorno = "Senha antiga igual a nova";
            }else{
                user.setSenha(senhaNova);
                new GerenciadorUsuario().alterar(user);
                req.getSession().setAttribute("user", user);
                retorno = "Senha alterada com sucesso!";
            }
        }
        
        req.setAttribute("retorno", retorno);
        req.getRequestDispatcher("configuracoesDeSeguranca.jsp").forward(req, resp);
    }
    
    
}
