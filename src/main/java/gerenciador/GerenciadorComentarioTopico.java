package gerenciador;

import java.util.List;

import entidades.ComentarioTopico;
import factory.DAOFactory;

public class GerenciadorComentarioTopico {

    public boolean adicionar(ComentarioTopico c) {
        return DAOFactory.createFactory().criaComentarioTopicoDAO().adicionar(c);
    }

    public boolean remover(int id) {
        return DAOFactory.createFactory().criaComentarioTopicoDAO().remover(id);
    }

    public List<ComentarioTopico> consultarPorIdTopico(int idTopico) {
        return DAOFactory.createFactory().criaComentarioTopicoDAO().consultarPorIdTopico(idTopico);
    }

    public boolean alterar(ComentarioTopico c) {
        return DAOFactory.createFactory().criaComentarioTopicoDAO().atualizar(c);
    }

}
