package gerenciador;

import entidades.Topico;
import factory.DAOFactory;
import java.util.List;

public class GerenciadorTopico {

    public boolean adicionar(Topico t) {
        return DAOFactory.createFactory().criaTopicoDAO().adicionar(t);
    }

    public boolean remover(int id) {
        return DAOFactory.createFactory().criaTopicoDAO().remover(id);

    }

    public boolean atualizar(Topico t) {
        return DAOFactory.createFactory().criaTopicoDAO().atualizar(t);
    }

    public List<Topico> consultarPorIdDoGrupo(int idDoGrupo){
        return DAOFactory.createFactory().criaTopicoDAO().consultarPorIdDoGrupo(idDoGrupo);
    }
    
    public Topico consultarPorId(int idTopico){
        return DAOFactory.createFactory().criaTopicoDAO().consultarPorId(idTopico);
    }
}
