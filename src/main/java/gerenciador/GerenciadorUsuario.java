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

    public List<Usuario> consultar() {
        return DAOFactory.createFactory().criaUsuarioDAO().consultar();

    }

    public boolean alterar(Usuario u) {
        return DAOFactory.createFactory().criaUsuarioDAO().atualizar(u);
    }

    public Usuario login(String email, String senha) {
        return DAOFactory.createFactory().criaUsuarioDAO().login(email, senha);
    }

}
