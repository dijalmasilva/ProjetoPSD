package gerenciador;

import entidades.Notificacoes;
import factory.DAOFactory;
import java.util.List;

/**
 *
 * @author dijalma
 */
public class GerenciadorNotificacao {
    
    public boolean adicionarRecomendacao(Notificacoes n){
        return DAOFactory.createFactory().criaNotificacaoDAO().adicionarRecomendacao(n);
    }
    
    public boolean adicionarSolicitacaoAceita(Notificacoes n){
        return DAOFactory.createFactory().criaNotificacaoDAO().adicionarSolicitacaoAceita(n);
    }
    
    public List<Notificacoes> recuperar20NotificacoesRecentes(){
        List<Notificacoes> notificacoes = new GerenciadorNotificacao().recuperar20NotificacoesRecentes();
        
        for(Notificacoes n: notificacoes){
            n.setFoto(new GerenciadorUsuario().retornaFotoPeloId(n.getIdAmigo()));
            n.setApelidoAmigo(new GerenciadorUsuario().retornaApelidoPeloId(n.getIdAmigo()));
        }
        
        return notificacoes;
    }
}
