package gerenciador;

import java.util.List;

import DAO.UsuarioDAO;
import entidades.ComentarioTopico;
import entidades.Usuario;
import factory.DAOFactory;
import factory.DAOFactoryBD;
import factory.DAOFactoryPSD;

public class GerenciadorComentarioTopico {

    public boolean adicionar(ComentarioTopico c) {
        return new DAOFactoryBD().criaComentarioTopicoDAO().adicionar(c);
    }

    public void remover(String s) {
        DAOFactoryPSD fabrica = DAOFactory.createFactory();
        UsuarioDAO usu = fabrica.criaUsuarioDAO();
        usu.remover(s);

    }

    public List<Usuario> pesquisar() {
        DAOFactoryPSD fabrica = DAOFactory.createFactory();
        UsuarioDAO usu = fabrica.criaUsuarioDAO();
        return usu.consultar();

    }

    public void alterar(Usuario u) {
        DAOFactoryPSD fabrica = DAOFactory.createFactory();
        UsuarioDAO usu = fabrica.criaUsuarioDAO();
        usu.atualizar(u);

    }

}
