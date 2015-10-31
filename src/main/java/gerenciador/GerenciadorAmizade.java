package gerenciador;

import beans.Solicitacao;
import factory.DAOFactory;
import java.util.ArrayList;
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
        return DAOFactory.createFactory().criaAmizadeDAO().isPendente(idUsuarioE, idUsuarioR);
    }
    
    public List<Solicitacao> retornaSolicitacoes(int id){
        List<Solicitacao> solicitacoes = new ArrayList<>();
        
        for (Integer i: retornaIdDeSolicitacoes(id)){
            Solicitacao s = new Solicitacao();
            s.setApelido(new GerenciadorUsuario().retornaApelidoPeloId(i));
            s.setFoto(new GerenciadorUsuario().retornaFotoPeloId(i));
            s.setId(i);
            solicitacoes.add(s);
        }
        
        return solicitacoes;
    }
}
