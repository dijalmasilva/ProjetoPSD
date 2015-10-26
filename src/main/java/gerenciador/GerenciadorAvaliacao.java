package gerenciador;

import entidades.Avaliacao;
import factory.DAOFactory;
import java.util.List;

public class GerenciadorAvaliacao {

    public boolean adicionar(Avaliacao a){
        return DAOFactory.createFactory().criaAvaliacaoDAO().adicionar(a);
    }
    
    public boolean atualizar(Avaliacao a){
        return DAOFactory.createFactory().criaAvaliacaoDAO().atualizar(a);
    }
    
    public List<Avaliacao> consultarPorIdDoFilme(int idFilme){
        return DAOFactory.createFactory().criaAvaliacaoDAO().consultarPorIdDeFilme(idFilme);
    }
}
