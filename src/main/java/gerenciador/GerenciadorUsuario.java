package gerenciador;

import java.util.List;

import entidades.Usuario;
import factory.DAOFactory;

public class GerenciadorUsuario {

    public boolean adicionar(Usuario u) {
        return DAOFactory.createFactory().criaUsuarioDAO().adicionar(u);
    }

    public boolean remover(String s) {
        return DAOFactory.createFactory().criaUsuarioDAO().remover(s);
    }

    public List<Usuario> consultarPorApelido(String apelido) {
        return DAOFactory.createFactory().criaUsuarioDAO().consultarPorApelido(apelido);
    }

    public Usuario consultarPorEmail(String email){
        return DAOFactory.createFactory().criaUsuarioDAO().consultarPorEmail(email);
    }
    
    public Usuario consultarPorId(int id){
        return DAOFactory.createFactory().criaUsuarioDAO().consultarPorId(id);
    }
    
    public boolean alterar(Usuario u) {
        return DAOFactory.createFactory().criaUsuarioDAO().atualizar(u);
    }

    public Usuario login(String email, String senha) {
        return DAOFactory.createFactory().criaUsuarioDAO().login(email, senha);
    }

}
