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
    
    public List<Notificacoes> recuperar20NotificacoesRecentes(int idUsuario){
        List<Notificacoes> notificacoes = DAOFactory.createFactory().criaNotificacaoDAO().recuperar20NotificacoesRecentes(idUsuario);
        
        for(Notificacoes n: notificacoes){
            if (n.getIdFilme() != 0){
                n.setNomeFilme(new GerenciadorFilme().buscarTituloDoFilmePorId(n.getIdFilme()));
            }
            n.setFoto(new GerenciadorUsuario().retornaFotoPeloId(n.getIdUsuario()));
            n.setApelidoUsuario(new GerenciadorUsuario().retornaApelidoPeloId(n.getIdUsuario()));
        }
        
        return notificacoes;
    }
}
