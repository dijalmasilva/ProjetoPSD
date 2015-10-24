package gerenciador;

import entidades.Solicitacoes;
import factory.DAOFactory;

/**
 *
 * @author dijalma
 */
public class GerenciadorSolicitacoes {
    
    
    public boolean cadastraSolicitacao(Solicitacoes s){
        return DAOFactory.createFactory().criaSolicitacaoDAO().cadastrar(s);
    }
    
    public boolean remover(Solicitacoes s){
        return true;
    }
}
