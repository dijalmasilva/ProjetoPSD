package gerenciador;

import entidades.Avaliacao;
import factory.DAOFactoryBD;
import java.util.List;

public class GerenciadorAvaliacao {

    public boolean adicionar(Avaliacao a){
        return new DAOFactoryBD().criaAvaliacaoDAO().adicionar(a);
    }
    
    public boolean atualizar(Avaliacao a){
        return new DAOFactoryBD().criaAvaliacaoDAO().atualizar(a);
    }
    
    public List<Avaliacao> consultarPorIdDoFilme(int idFilme){
        return new DAOFactoryBD().criaAvaliacaoDAO().consultarPorIdDeFilme(idFilme);
    }
}
