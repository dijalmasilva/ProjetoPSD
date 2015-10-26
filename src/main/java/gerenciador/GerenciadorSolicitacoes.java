package gerenciador;

import entidades.Solicitacoes;
import factory.DAOFactory;

/**
 *
 * @author dijalma
 */
public class GerenciadorSolicitacoes {
    
    
    public boolean adicionar(Solicitacoes s){
        return DAOFactory.createFactory().criaSolicitacaoDAO().adicionar(s);
    }
    
    public boolean atualizar(Solicitacoes s){
        return DAOFactory.createFactory().criaSolicitacaoDAO().atualizar(s);
    }
    
    public boolean remover(int id){
        return DAOFactory.createFactory().criaSolicitacaoDAO().remover(id);
    }
}
