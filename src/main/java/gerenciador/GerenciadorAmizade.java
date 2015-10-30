package gerenciador;

import factory.DAOFactory;
import java.util.List;

/**
 *
 * @author dijalma
 */
public class GerenciadorAmizade {
    
    public List<Integer> retornaIdDeAmigos(int idUsuario){
        return DAOFactory.createFactory().criaAmizadeDAO().retornaIdDeAmigos(idUsuario);
    };
    
    public List<Integer> retornaIdDeSolicitacoes(int idUsuario){
        return DAOFactory.createFactory().criaAmizadeDAO().retornaIdDeSolicitacoes(idUsuario);
    };
    
    public boolean solicitaAmizade(int idUsuarioE, int idUsuarioR){
        return DAOFactory.createFactory().criaAmizadeDAO().solicitaAmizade(idUsuarioE, idUsuarioR);
    };
    
    public boolean cancelaSolicitacao(int idUsuarioR, int idUsuarioE){
        return DAOFactory.createFactory().criaAmizadeDAO().cancelaSolicitacao(idUsuarioR, idUsuarioE);
    };
    
    public boolean isFriend(int idUsuario, int idVisitante){
        return DAOFactory.createFactory().criaAmizadeDAO().isFriend(idUsuario, idVisitante);
    }
    
    public boolean isSolicitado(int idUsuario, int idVisitante){
        return DAOFactory.createFactory().criaAmizadeDAO().isSolicitado(idUsuario, idVisitante);
    }
    
    public boolean aceitaSolicitacao(int idUsuarioE, int idUsuarioR){
        return DAOFactory.createFactory().criaAmizadeDAO().aceitaSolicitacao(idUsuarioR, idUsuarioE);
    }
    
    public boolean isPendente(int idUsuarioE, int idUsuarioR){
        return DAOFactory.createFactory().criaAmizadeDAO().isPendente(idUsuarioR, idUsuarioR);
    }
}
